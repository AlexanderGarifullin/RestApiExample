package hse.example.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hse.example.restapi.entity.Cat;
import hse.example.restapi.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepository catRepository;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
        log.info("New row: " + catRepository.save(cat));
    }

    @SneakyThrows
    @GetMapping("api/all")
    public List<Cat> getAll(){
        return catRepository.findAll();
    }

    @GetMapping("/api")
    public Cat getCat(@RequestParam int id){
        return catRepository.findById(id).orElseThrow();
    }


}
