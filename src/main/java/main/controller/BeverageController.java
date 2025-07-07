package main.controller;

import main.dto.BeverageDTO;
import main.service.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beverage")
@CrossOrigin

public class BeverageController {

    @Autowired
    BeverageService beverageService;

     @GetMapping("/getAll")
     public List<BeverageDTO> getAllBeverages(BeverageDTO  beverageDTO  ) {
         return beverageService.getAllBeverages(beverageDTO);
     }

     @PostMapping("/add")
     public void addBeverage(@RequestBody BeverageDTO beverageDTO) {
         beverageService.addBeverage(beverageDTO);
     }

     @GetMapping("/search/{title}")
     public List<BeverageDTO> searchBeverages(@PathVariable String title) {
         return beverageService.searchBeverages(title);
     }

     @DeleteMapping("/delete/{title}")
     public void deleteBeverage(@PathVariable String title) {
         beverageService.deleteBeverage(title);
     }

}
