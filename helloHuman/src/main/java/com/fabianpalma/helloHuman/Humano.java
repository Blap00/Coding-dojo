package com.fabianpalma.helloHuman;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Humano {
	@GetMapping("/")
    public String saludar(@RequestParam(value = "name", defaultValue = "Humano") String nombre,
                          @RequestParam(value = "lastName", defaultValue = "", required = false) String apellido) {
        String mensaje = "Hello " + nombre;
        if (!apellido.isEmpty()) {
            mensaje += " " + apellido;
        }
        return "<h1>"+mensaje+"!</h1><br><p>Welcome to Springboot!</p>";

    }
}
