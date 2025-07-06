package main.service;

import main.dto.SubmarinesDTO;
import main.entity.SubmarinesEntity;
import main.repository.SubmarinesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SubmarinesService {

    @Autowired
    SubmarinesRepository submarinesRepository;

    ModelMapper modelMapper = new ModelMapper();


    public List<SubmarinesDTO> getAll(SubmarinesDTO submarinesDTO) {
        List<SubmarinesEntity> all = submarinesRepository.findAll();
        List<SubmarinesDTO>submarinesDTOS =new ArrayList<>();
        for (SubmarinesEntity submarinesEntity : all) {
            SubmarinesDTO submarinesDTO1 = modelMapper.map(submarinesEntity, SubmarinesDTO.class);
            submarinesDTOS.add(submarinesDTO1);
        }
        return submarinesDTOS;
    }


    public SubmarinesDTO addSubmarines(SubmarinesDTO submarinesDTO) {
        SubmarinesEntity submarinesEntity = modelMapper.map(submarinesDTO, SubmarinesEntity.class);
        submarinesEntity = submarinesRepository.save(submarinesEntity);
        return modelMapper.map(submarinesEntity, SubmarinesDTO.class);
    }

    public void deleteSubmarines(String title) {
        if (submarinesRepository.existsById(Long.valueOf(title))) {
            submarinesRepository.deleteById(Long.valueOf(title));
        } else {
            throw new RuntimeException("Submarine with id " + title + " does not exist.");
        }
    }

    public SubmarinesDTO searchSubmarines(String title) {
        Optional<SubmarinesEntity> submarinesEntity = submarinesRepository.findByTitle(title);
        List<SubmarinesDTO>submarinesDTOS= new ArrayList<>();
        if (submarinesEntity.isPresent()){
            SubmarinesDTO submarinesDTO = modelMapper.map(submarinesEntity.get(), SubmarinesDTO.class);
            submarinesDTOS.add(submarinesDTO);
            return submarinesDTO;
        } else {
            throw new RuntimeException("Submarine with title '" + title + "' does not exist.");
        }
    }
}
