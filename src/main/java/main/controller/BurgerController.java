package main.controller;

import main.dto.BurgerDTO;
import main.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {

    @Autowired
    BurgerService burgerService ;

    @GetMapping("/getAll")
    public List<BurgerDTO>getAllBurgers(BurgerDTO burgerDTO ) {
        return burgerService.getAllBurgers(burgerDTO);
    }

    @PostMapping("/add")
    public void addBurger(@RequestBody BurgerDTO burgerDTO ){
        burgerService.addBurger(burgerDTO);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteBurger(@PathVariable String title) {
        burgerService.deleteBurger(title);
    }

    @GetMapping("/search/{title}")
    public List<BurgerDTO> searchBurgers(@PathVariable String title) {
        return burgerService.searchBurgers(title);
    }
}
