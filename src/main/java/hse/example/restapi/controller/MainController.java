package hse.example.restapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hse.example.restapi.entity.Cat;
import hse.example.restapi.repository.CatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MainController {

    @Autowired
    private CatRepository catRepository;

    @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
        log.info("New row: " + catRepository.save(cat));
    }

}
