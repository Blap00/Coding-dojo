package com.fabianpalma.licenciaManejo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.licenciaManejo.models.License;
import com.fabianpalma.licenciaManejo.models.Person;
import com.fabianpalma.licenciaManejo.services.LicenseService;
import com.fabianpalma.licenciaManejo.services.PersonService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;
    @Autowired
    private PersonService personService;
    @RequestMapping("/create")
	public String formLicense(Model model,@Valid @ModelAttribute("license") License license) {
		List<Person> persons = personService.obtenerPersonasSinLicencia();
		model.addAttribute("persons", persons);
		return "newLicense.jsp";
	}
	@PostMapping("/create")
	public String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "newLicense.jsp";
		}else {
			licenseService.saveLicense(license);
			return "redirect:/licenses/create";			
		}

	}
	

    
}
