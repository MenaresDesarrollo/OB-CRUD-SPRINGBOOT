package com.ejercicio.DemoOBSB.controller;

import com.ejercicio.DemoOBSB.entities.Laptop;
import com.ejercicio.DemoOBSB.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //Atributos
    private LaptopRepository laptopRepository;


    public LaptopController(LaptopRepository laptopRepository){this.laptopRepository = laptopRepository;}

    //Desde LaptopController crear un método que devuelva una lista de objetos Laptop
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }


    //Se busca dentro de base de datos la laptop segun su id
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un libro por id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("id del tipo Long") @PathVariable Long id){

        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // crear un nuevo libro en base de datos
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() != null){//verifica que el id existe
            log.warn("trying to create a book with id");
            System.out.println("trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return  ResponseEntity.ok(result); //el libro devuelto tiene clave primaria
    }

    //Actulizar un laptop existente en bbdd
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){ //si no tiene id quiere decir que si es una creacion
            log.warn("Estas tratando de actualizar un laptop existente");
            return ResponseEntity.ok(laptop);
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("Estas tratando de actualizar un laptop existente");
            return ResponseEntity.notFound().build();
        }

        //aqui se procede a actualizar
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    //Eliminamos un elemento segun su id
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){

        if (!laptopRepository.existsById(id)){ //si el id que se busca para eliminar no existe
            log.warn("Estas intentando eliminar una laptop que no existe");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id); //se elimina segun id

        return ResponseEntity.noContent().build();
    }

    //Se eliminan todos los elementos dentro de la lista
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.warn("Se aliminan todos los elementos");
        laptopRepository.deleteAll();
        return  ResponseEntity.noContent().build();
    }

}
