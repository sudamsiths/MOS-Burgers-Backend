package main.service;

import main.dto.PastaDTO;
import main.entity.PastaEntity;
import main.repository.PastaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PastaService {

    @Autowired
    PastaRepository pastaRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<PastaDTO> getAllPasta(PastaDTO pastaDTO) {
        List<PastaEntity> all = pastaRepository.findAll();
        List<PastaDTO>pastaDTOS =new ArrayList<>();
        for (PastaEntity pastaEntity : all) {
            PastaDTO pastaDTO1 = modelMapper.map(pastaEntity, PastaDTO.class);
            pastaDTOS.add(pastaDTO1);
        }
        return pastaDTOS;
    }

    public PastaDTO addPasta(PastaDTO pastaDTO) {
        PastaEntity pastaEntity = modelMapper.map(pastaDTO, PastaEntity.class);
        pastaEntity = pastaRepository.save(pastaEntity);
        return modelMapper.map(pastaEntity, PastaDTO.class);
    }

    public void deletePasta(String title) {
        if (pastaRepository.existsById(Long.valueOf(title))) {
            pastaRepository.deleteById(Long.valueOf(title));
        } else {
            throw new RuntimeException("Pasta with id " + title + " does not exist.");
        }
    }

    public PastaDTO searchPasta(String title) {
        Optional<PastaEntity> pastaEntity = pastaRepository.findById(Long.valueOf(title));
        if (pastaEntity.isPresent()) {
            return modelMapper.map(pastaEntity.get(), PastaDTO.class);
        } else {
            throw new RuntimeException("Pasta with title " + title + " not found");
        }
    }
}
