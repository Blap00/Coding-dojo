package com.fabianpalma.licenciaManejo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.licenciaManejo.models.License;
import com.fabianpalma.licenciaManejo.models.Person;
import com.fabianpalma.licenciaManejo.services.LicenseService;
import com.fabianpalma.licenciaManejo.services.PersonService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;
    @Autowired
    private LicenseService licenseService;
    

    @GetMapping("/new")
    public String showCreatePersonForm(@Valid @ModelAttribute("person") Person person) {
        return "createPerson.jsp"; // Retorna la vista JSP para crear una nueva persona (createPersonForm.jsp)
    }
    

    @PostMapping("/new")
    public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
    	if(result.hasErrors()) {
    		return "redirect:/persons/new";
    	}else {
    		personService.create(person);
    		return "redirect:/persons/new";
    	}
    }

    @GetMapping("/{personId}")
    public String getPerson(@PathVariable Long personId, Model model) {
        Person person = personService.findByPerson(personId);
        License license = licenseService.findLicenseByPersonId(personId);
        if (Boolean.TRUE.equals(personService.personHadLicense(personId)) && person != null) {
            model.addAttribute("person", person);
            model.addAttribute("license", license);
            return "personDetails.jsp"; // Retorna la vista JSP para mostrar los detalles de la persona (personDetails.jsp)
        } else {
            return "createPerson.jsp"; // Retorna una vista JSP para mostrar un mensaje de error.
        }
    }  
}

