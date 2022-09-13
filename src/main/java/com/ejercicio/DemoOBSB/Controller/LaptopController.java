package com.ejercicio.DemoOBSB.Controller;

import com.ejercicio.DemoOBSB.Entities.Laptop;
import com.ejercicio.DemoOBSB.Repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    //Atributos
    private LaptopRepository laptopRepository;

    //Constructores
    public LaptopController(LaptopRepository laptopRepository){this.laptopRepository = laptopRepository;}

    //Desde LaptopController crear un método que devuelva una lista de objetos Laptop
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }


    // crear un nuevo libro en base de datos
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        // guardar el libro recibido por parámetro en la base de datos
        return laptopRepository.save(laptop);
    }

}
