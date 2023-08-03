package com.fabianpalma.listaestudiantes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fabianpalma.listaestudiantes.models.Student;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class ListaEstudiantesApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test //TEST WORKING
    void testingStudent() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Student student = new Student();
        student.setFirstName("Fabian");
        student.setLastName("Palma");
        student.setAge(20);
        Set<ConstraintViolation<Student>> violations = validator.validate(student);
        for (ConstraintViolation<Student> violation : violations) {
            System.out.println(violation.getMessage());
        }
        assertTrue(violations.isEmpty());
    }
}
