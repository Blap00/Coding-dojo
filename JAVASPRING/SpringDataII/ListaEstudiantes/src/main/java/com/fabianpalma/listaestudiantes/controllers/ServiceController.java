package com.fabianpalma.listaestudiantes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.listaestudiantes.services.ContactService;
import com.fabianpalma.listaestudiantes.services.StudentService;

@Controller
@RequestMapping("/students")
public class ServiceController {
	private final ContactService contactService;
	
	private final StudentService studentService;
	
	public ServiceController(ContactService contactService, StudentService studentService) {
		this.contactService = contactService;
		this.studentService = studentService;
		
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("studentInfo", studentService.allStudent());
		model.addAttribute("contactInfo", contactService.allContact());
		return "index.jsp";
	}
}
