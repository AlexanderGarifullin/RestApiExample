package hse.example.restapi.controller;

import hse.example.restapi.entity.Cat;
import hse.example.restapi.repository.CatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {
    @Mock
    private CatRepository catRepository;

    @InjectMocks
    private MainController controller;

    @Test
    void changeCatFailedTest() {
        int id = 1;
        Cat cat =new Cat();
        cat.setId(id);

        when(catRepository.existsById(id)).thenReturn(false);
        String expected = "No such row";

        Assertions.assertEquals(expected, controller.changeCat(cat));
    }

    @Test
    void changeCatTest() {
        int id = 1;
        Cat cat =new Cat();
        cat.setId(id);
        cat.setName("Malish");

        lenient().when(catRepository.existsById(id)).thenReturn(true);
        Assertions.assertEquals(cat.toString(), controller.changeCat(cat));
    }
}