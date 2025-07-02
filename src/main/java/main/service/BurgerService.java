package main.service;

import main.dto.BurgerDTO;
import main.entity.BurgerEntity;
import main.repository.BurgerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BurgerService {

    @Autowired
    BurgerRepository burgerRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<BurgerDTO> getAllBurgers(BurgerDTO burgerDTO) {
        List<BurgerEntity> all = burgerRepository.findAll();
        List<BurgerDTO> burgerDTOS = new ArrayList<>();
        for (BurgerEntity burgerEntity : all) {
            BurgerDTO map = modelMapper.map(burgerEntity, BurgerDTO.class);
            burgerDTOS.add(map);
        }
        return burgerDTOS;
    }

    public void addBurger(BurgerDTO burgerDTO) {
        burgerRepository.save(modelMapper.map(burgerDTO, BurgerEntity.class));

    }

    public void deleteBurger(String title) {
        if (burgerRepository.existsById(Long.valueOf(title))) {
            burgerRepository.deleteById(Long.valueOf(title));
        } else {
            throw new RuntimeException("Burger with id " + title + " does not exist.");
        }
    }

    public List<BurgerDTO> searchBurgers(String title) {
        Optional<BurgerEntity> byId = burgerRepository.findById(Long.valueOf(title));
        List<BurgerDTO> burgerDTOS = new ArrayList<>();
        if (byId.isPresent()) {
            BurgerEntity burgerEntity = byId.get();
            BurgerDTO map = modelMapper.map(burgerEntity, BurgerDTO.class);
            burgerDTOS.add(map);
        }
        else {
            throw new RuntimeException("Burger with id " + title + " does not exist.");
        }
        return burgerDTOS;
    }
}
