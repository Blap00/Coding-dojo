package com.fabianpalma.relaciones1n.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.relaciones1.models.Ninja;
import com.fabianpalma.relaciones1n.services.DojoService;
import com.fabianpalma.relaciones1n.services.NinjaService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;

	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
		
	}

	@GetMapping("/new")
	public String createNinjaGet(Model model, @ModelAttribute("ninja") Ninja ninja) {
		model.addAttribute("dojos", dojoService.findAll());
		return "createNinja.jsp";
	}

	@PostMapping("/new")
	public String createNinjaPost(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (!result.hasErrors()) { //no tiene error
			ninjaService.saveNinja(ninja);
			return "redirect:/ninjas/new";
		}else {
			return "redirect:/ninjas/new";			
		}
	}
	

}
