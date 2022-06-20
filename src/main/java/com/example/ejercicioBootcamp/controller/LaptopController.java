package com.example.ejercicioBootcamp.controller;

import com.example.ejercicioBootcamp.modelo.Laptop;
import com.example.ejercicioBootcamp.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * http://localhost:8080/api/laptop
 * @return
 *
 * findAll()
 *
 * findOneById()
 *
 * create()
 *
 * update()
 *
 * delete()
 *
 * deleteAll()
 */

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        // recuperar y devolver los libros de base de datos
        return laptopRepository.findAll();
    }
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptop = laptopRepository.findById(id); // 3456546456435
        // opcion 1
        if(laptop.isPresent())
            return ResponseEntity.ok(laptop.get());
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){ // RequestBody aqui trae lo qhaya en el body de la peticion
        //Spring boot ya de por si hace el parseo del objeto de JSON  a book
        //headers.get("User-Agent") esto nos dice quien nos envio la peticion
        System.out.println(headers.get("User-Agent"));
        System.out.println(laptop.toString());
        // guardar el libro recibido por parámetro en la base de datos
        return laptopRepository.save(laptop);
    }

    @PutMapping("api/laptops/")
    public ResponseEntity<Laptop> update (@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            System.out.println("ERROR");
            log.warn("ERROR NO SE ENCUENTRA EL OBJETO");
            return ResponseEntity.badRequest().build();
        }
        //Proceso de la actualizacion.
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("NO EXISTE LIBRO");
            return ResponseEntity.notFound().build();
        }



        Laptop result = laptopRepository.save(laptop);
        return  ResponseEntity.ok(result);

    }
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        if(!laptopRepository.existsById(id)){
            log.warn("NO EXISTE LIBRO PARA BORRAR");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/laptops/")
        public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        log.info("REST Request for delete all books");
        return ResponseEntity.noContent().build();
    }


    }




