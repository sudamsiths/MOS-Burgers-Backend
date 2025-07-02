package main.service;

import main.dto.BeverageDTO;
import main.entity.BeverageEntity;
import main.repository.BeverageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeverageService {

    @Autowired
    BeverageRepository beverageRepository ;

    ModelMapper modelMapper = new ModelMapper();

    public List<BeverageDTO> getAllBeverages(BeverageDTO beverageDTO) {
        List<BeverageEntity> all = beverageRepository.findAll();
        List<BeverageDTO>beverageDTOS =new ArrayList<>();
        for (BeverageEntity beverageEntity : all) {
            BeverageDTO map = modelMapper.map(beverageEntity, BeverageDTO.class);
            beverageDTOS.add(map);
        }
        return beverageDTOS;
    }

    public void addBeverage(BeverageDTO beverageDTO) {
        beverageRepository.save(modelMapper.map(beverageDTO, BeverageEntity.class));
    }

    public List<BeverageDTO> searchBeverages(String title) {
        Optional<BeverageEntity> byId = beverageRepository.findById(Long.valueOf(title));
        List<BeverageDTO> beverageDTOS = new ArrayList<>();
        if (byId.isPresent()) {
            BeverageEntity beverageEntity = byId.get();
            BeverageDTO map = modelMapper.map(beverageEntity, BeverageDTO.class);
            beverageDTOS.add(map);
        } else {
            throw new RuntimeException("Beverage with id " + title + " does not exist.");
        }
        return beverageDTOS;
    }

    public void deleteBeverage(String title) {
        beverageRepository.deleteById(Long.valueOf(title));
    }
}
