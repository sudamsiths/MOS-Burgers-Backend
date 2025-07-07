package main.controller;

import main.dto.PastaDTO;
import main.service.PastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pasta")
@CrossOrigin

public class PastaController {

    @Autowired
    PastaService pastaService;

    @GetMapping("/getAll")
    public List<PastaDTO>getAllPasta(PastaDTO pastaDTO ){
        return pastaService.getAllPasta(pastaDTO);
    }

    @PostMapping("/add")
    public PastaDTO addPasta(@RequestBody PastaDTO pastaDTO) {
        return pastaService.addPasta(pastaDTO);
    }

    @DeleteMapping("/delete/{title}")
    public void deletePasta(@PathVariable String title) {
        pastaService.deletePasta(title);
    }

    @GetMapping("search/{title}")
    public PastaDTO searchPasta(@PathVariable String title) {
        return pastaService.searchPasta(title);
    }
}
