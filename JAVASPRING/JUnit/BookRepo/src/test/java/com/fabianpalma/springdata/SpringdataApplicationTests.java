package com.fabianpalma.springdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fabianpalma.springdata.controllers.BookApi;
import com.fabianpalma.springdata.models.Autor;
import com.fabianpalma.springdata.models.Book;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
@SpringBootTest
class SpringdataApplicationTests {

	@Autowired
    private BookApi controller;
	
    @Test
    void contextLoads() {
    }
    
    @Test
    void testController() {
        assertThat(controller).isNotNull();
    }
    
    @Test //TEST WORKING
    void testingBook() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Book autor = new Book();
        autor.setTitle("Harry Potter and the Goblet of Fire");
        autor.setDescription("Great autor");
        autor.setLanguage("English");
        autor.setNumberOfPages(734);
        Set<ConstraintViolation<Book>> violations = validator.validate(autor);
        for (ConstraintViolation<Book> violation : violations) {
            System.out.println(violation.getMessage());
        }
        assertTrue(violations.isEmpty());
    }
    @Test
    void assumeAutorIsNull() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("");
        autor.setApellido("");
        autor.setDescription("");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        for (ConstraintViolation<Autor> violation : violations) {
            System.out.println(violation.getMessage());
        }
        assertFalse(violations.isEmpty());
    }

    // Prueba 1
    @Test
    void assumeNombreIsShorterThanMinLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("A");
        autor.setApellido("Palma");
        autor.setDescription("Great autor");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertFalse(violations.isEmpty());
    }

    // Prueba 2
    @Test
    void assumeApellidoIsShorterThanMinLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("Fabian");
        autor.setApellido("P");
        autor.setDescription("Great autor");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertFalse(violations.isEmpty());
    }

    // Prueba 3
    @Test
    void assumeDescriptionIsShorterThanMinLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("Fabian");
        autor.setApellido("Palma");
        autor.setDescription("Desc");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertFalse(violations.isEmpty());
    }

    // Prueba 4
    @Test
    void assumeNombreIsPresentAndLongerThanMinLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("Fabian");
        autor.setApellido("Palma");
        autor.setDescription("Great autor");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertTrue(violations.isEmpty());
    }

    // Prueba 5
    @Test
    void assumeApellidoIsPresentAndBiggerThanMaxLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("Fabian");
        autor.setApellido("Palmaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        autor.setDescription("Great autor");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertTrue(violations.isEmpty());
    }

    // Prueba 6
    @Test
    void assumeNameIsPresentAndBiggerThanMinLength() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Autor autor = new Autor();
        autor.setNombre("Fabiaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaan");
        autor.setApellido("Palma");
        autor.setDescription("Great author");
        Set<ConstraintViolation<Autor>> violations = validator.validate(autor);
        assertTrue(violations.isEmpty());
    }

}
