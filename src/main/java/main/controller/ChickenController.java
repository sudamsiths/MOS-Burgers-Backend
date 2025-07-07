package main.controller;

import main.dto.BeverageDTO;
import main.dto.ChickenDTO;
import main.service.BeverageService;
import main.service.ChickenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/chicken")
@CrossOrigin

public class ChickenController {
    @Autowired
    ChickenService chickenService;

    @GetMapping("/getAll")
    public List<ChickenDTO> getAllChicken(ChickenDTO chickenDTO  ) {
        return chickenService.getAllChickens(chickenDTO);
    }

    @PostMapping("/add")
    public void addChicken(@RequestBody ChickenDTO chickenDTO) {
        chickenService.addChicken(chickenDTO);
    }

    @GetMapping("/search/{title}")
    public List<ChickenDTO> searchChicken(@PathVariable String title) {
        return chickenService.searchChicken(title);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteChicken(@PathVariable String title) {
        chickenService.deleteChicken(title);
    }
}
