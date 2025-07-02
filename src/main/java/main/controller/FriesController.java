package main.controller;

import main.dto.FriesDTO;
import main.service.FriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fries")
public class FriesController {


    @Autowired
    FriesService friesService ;

    @GetMapping("/getAll")
    public List<FriesDTO>getAllFries(FriesDTO friesDTO ){
        return friesService.getAllFries(friesDTO);
    }
    @PostMapping("/add")
    public void addFries(@RequestBody FriesDTO friesDTO) {
        friesService.addFries(friesDTO);
    }

    @GetMapping("/search/{title}")
    public List<FriesDTO> searchFries(@PathVariable String title) {
        return friesService.searchFries(title);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteFries(@PathVariable String title) {
        friesService.deleteFries(title);
    }
}
