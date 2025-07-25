package main.service;

import main.dto.FriesDTO;
import main.entity.FriesEntity;
import main.repository.FriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriesService {
    
    @Autowired
    FriesRepository friesRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    public List<FriesDTO> getAllFries(FriesDTO friesDTO) {
        List<FriesEntity> all = friesRepository.findAll();
        List<FriesDTO>friesDTOS =new ArrayList<>();
        for (FriesEntity friesEntity : all) {
            FriesDTO map = modelMapper.map(friesEntity, FriesDTO.class);
            friesDTOS.add(map);
        }
        return friesDTOS;
    }


    public void addFries(FriesDTO friesDTO) {
        friesRepository.save(modelMapper.map(friesDTO, FriesEntity.class));
    }

    public List<FriesDTO> searchFries(String title) {
        Optional<FriesEntity> friesEntity = friesRepository.findByTitle(title);
        List<FriesDTO> friesDTOS = new ArrayList<>();
        if (friesEntity.isPresent()) {
            FriesEntity friesEntity1 = friesEntity.get();
            FriesDTO map = modelMapper.map(friesEntity1, FriesDTO.class);
            friesDTOS.add(map);
            return friesDTOS;
        } else {
            throw new RuntimeException("Fries with title '" + title + "' does not exist.");
        }
    }

    public void deleteFries(String title) {
        if (friesRepository.existsById(Long.valueOf(title))) {
            friesRepository.deleteById(Long.valueOf(title));
        } else {
            throw new RuntimeException("Fries with title " + title + " does not exist.");
        }
    }
}
