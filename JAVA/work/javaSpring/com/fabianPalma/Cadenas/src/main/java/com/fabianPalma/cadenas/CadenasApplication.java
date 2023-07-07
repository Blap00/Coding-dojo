package com.fabianPalma.cadenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
//2. Importar las dependencias.
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
//1. Annotation
@RestController
public class CadenasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadenasApplication.class, args);
	}
	// 1. Anotación
    @RequestMapping("/")
    // 3. Método que se asigna a la Solicitud anterior.
    public String hello() { // 3
            return "<h1>Hello World!</h1>";
    }
 // 1. Anotación
    @RequestMapping("/random")
    // 3. Método que se asigna a la Solicitud anterior.
    public String random() { // 3
            return "<h3>Spring Boot is great! So easy to just respond with strings</h3>";
    }
}
