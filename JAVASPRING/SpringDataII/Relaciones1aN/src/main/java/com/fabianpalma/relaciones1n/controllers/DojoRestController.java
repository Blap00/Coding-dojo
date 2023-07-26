package com.fabianpalma.relaciones1n.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabianpalma.relaciones1.models.Dojo;
import com.fabianpalma.relaciones1n.services.DojoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dojo")
public class DojoRestController {
	
	private final DojoService dojoservice;
	
	public DojoRestController(DojoService dojoservice) {
		this.dojoservice = dojoservice;
		
	}
	@GetMapping("/new")
	public String index() {
		return "APIWORK";
	}
	@PostMapping("/new")
	public Dojo apiTest(@Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result) {
		return dojoservice.createDojo(dojo);
	}
}
