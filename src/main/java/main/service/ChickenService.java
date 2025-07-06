package main.service;

import main.dto.ChickenDTO;
import main.entity.ChickenEntity;
import main.repository.ChickenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChickenService {

    @Autowired
    ChickenRepository chickenRepository ;

    ModelMapper modelMapper = new ModelMapper();

    public List<ChickenDTO> getAllChickens(ChickenDTO chickenDTO) {
        List<ChickenEntity> all = chickenRepository.findAll();
        List<ChickenDTO> chickenDTOS = new ArrayList<>();
        for (ChickenEntity chickenEntity : all) {
            ChickenDTO map = modelMapper.map(chickenEntity, ChickenDTO.class);
            chickenDTOS.add(map);
        }
        return chickenDTOS;
    }

    public void addChicken(ChickenDTO chickenDTO) {
        ChickenEntity chickenEntity = modelMapper.map(chickenDTO, ChickenEntity.class);
        chickenRepository.save(chickenEntity);
    }

    public List<ChickenDTO> searchChicken(String title) {
        Optional<ChickenEntity> chickenEntities = chickenRepository.findByTitle(title);
        List<ChickenDTO> chickenDTOS = new ArrayList<>();
        if (chickenEntities.isPresent()) {
            ChickenEntity chickenEntity = chickenEntities.get();
            ChickenDTO map = modelMapper.map(chickenEntity, ChickenDTO.class);
            chickenDTOS.add(map);
        } else {
            throw new RuntimeException("Chicken with id " + title + " does not exist.");
        }
        return chickenDTOS;
    }

    public void deleteChicken(String title) {
        if (chickenRepository.existsById(Long.valueOf(title))) {
            chickenRepository.deleteById(Long.valueOf(title));
        } else {
            throw new RuntimeException("Chicken with id " + title + " does not exist.");
        }
    }
}
