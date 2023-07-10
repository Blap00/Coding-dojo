package com.fabianPalma.FamiliarizarEnrutamiento;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class CodingController {
	@RequestMapping("coding")
	public String coding() {
		return "¡Hola Coding Dojo!";
	}
	@RequestMapping("coding/python")
	public String codingPython(){
		return "¡Python/Django fue increíble!";
	}
	@RequestMapping("coding/java")
	public String codingJava(){
		return "¡Java/Spring es mejor!";
	}
}
