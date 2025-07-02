package main.controller;

import main.dto.SubmarinesDTO;
import main.service.SubmarinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submarines")
public class SubmarinesController {

    @Autowired
    SubmarinesService submarinesService;

    @GetMapping("/getAll")
    public List<SubmarinesDTO>getAll(SubmarinesDTO submarinesDTO ) {
        return submarinesService.getAll(submarinesDTO);
    }

    @PostMapping("/add")
    public SubmarinesDTO addSubmarines(@RequestBody SubmarinesDTO submarinesDTO) {
        return submarinesService.addSubmarines(submarinesDTO);
    }

    @DeleteMapping("/delete/{title}")
    public void deleteSubmarines(@PathVariable String title) {
        submarinesService.deleteSubmarines(title);
    }

    @GetMapping("/search/{title}")
    public SubmarinesDTO searchSubmarines(@PathVariable String title) {
        return submarinesService.searchSubmarines(title);
    }
}
