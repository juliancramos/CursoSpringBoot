package org.empresax.cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/saludo/{name}")
    public String greeting(@PathVariable String name) {
        System.out.println("Solicitud ejecutada para: "+name);
        return "Hello " + name + "!";

    }

}
