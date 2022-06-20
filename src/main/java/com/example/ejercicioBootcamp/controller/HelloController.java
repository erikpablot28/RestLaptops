package com.example.ejercicioBootcamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola desde maquina virtual de heroku";
    }
}
