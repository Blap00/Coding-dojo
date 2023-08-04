package com.fabianpalma.empleadosgerentes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.empleadosgerentes.models.Empleado;
import com.fabianpalma.empleadosgerentes.services.EmpleadoService;

@Controller
@RequestMapping("/employeer")
public class EmpleadoController {
	@Autowired
	private final EmpleadoService empleadoService;
	
	public EmpleadoController(EmpleadoService empleadoService) {
		this.empleadoService= empleadoService;
	}
	
	@GetMapping("/gerente/{id}")
	public String indexGerente(Model model, @PathVariable("id") Long id) {
		model.addAttribute("employees", empleadoService.findEmployerById(id));
		return "gerente.jsp";
	}
	@GetMapping("{id}")
	public String getIdEmployeer(Model model, @PathVariable("id") Long id) {
	    List<Object[]> empleadoData = empleadoService.findEmployeer(id);
	    model.addAttribute("employeeData", empleadoData);
	    
	    Optional<Empleado> empleadoOptional = empleadoService.getEmployeerRepository().findById(id);
	    if (empleadoOptional.isPresent()) {
	        Empleado empleado = empleadoOptional.get();
	        Empleado gerente = empleado.getManager();
	        
	        model.addAttribute("employee", empleado);
	        model.addAttribute("manager", gerente);
	    }
	    
	    return "showEmployeer.jsp";
	}
}
