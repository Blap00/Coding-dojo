package com.fabianpalma.relaciones1n.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.relaciones1.models.Dojo;
import com.fabianpalma.relaciones1n.services.DojoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	
	@Autowired
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoservice) {
		this.dojoService = dojoservice;
	}
	
	@GetMapping("/new")
	public String getDojo(@ModelAttribute("Dojo") Dojo dojo) {
		return "createDojo.jsp";
	}
	@PostMapping("/new")
	public String createDojo(@Valid @ModelAttribute("Dojo") Dojo dojo, BindingResult result) {
		if(!result.hasErrors()) {
			//Si no tiene errores redirijir a;
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}else {
			//En el caso contrario;
			return "redirect:/dojos/new"; 
		}
	}
	@GetMapping("{idDojo}")
	public String showDojo(Model model, @PathVariable("idDojo") Long id) {
        Dojo dojo = dojoService.findDojoById(id);
        model.addAttribute("dojo", dojo);
        return "showDojo.jsp";
    }
	
}
