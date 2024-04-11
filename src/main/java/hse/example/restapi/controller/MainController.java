package hse.example.restapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hse.example.restapi.DTO.CatDTO;
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
    public void addCat(@RequestBody CatDTO catDTO){
        log.info("New row: " + catRepository.save(Cat.builder()
                        .age(catDTO.getAge())
                        .weight(catDTO.getWeight())
                        .name(catDTO.getName())
                        .build()));
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

    @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id) {
        catRepository.deleteById(id);
    }

//    @PutMapping("/api/edit")
//    public String changeCat(@RequestBody CatDTO catDTO) {
//        if (!catRepository.existsById(cat.getId())) {
//            return "No such row";
//        }
//        return cat.toString();
//    }
}
