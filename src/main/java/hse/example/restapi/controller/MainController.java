package hse.example.restapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hse.example.restapi.entity.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("api/main")
    public String mainListener() {
        return "Hello World";
    }

    @GetMapping("api/cat")
    public String giveCat(){
        Cat cat = new Cat("Malish", 12, 5);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    @PostMapping("api/special")
    public String giveSpecialCat(@RequestParam String name) {
        Cat cat = new Cat(name, 12, 5);
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonData;
    }
}
