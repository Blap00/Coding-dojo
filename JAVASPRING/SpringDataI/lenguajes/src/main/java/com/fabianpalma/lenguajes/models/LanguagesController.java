package com.fabianpalma.lenguajes.models;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.lenguajes.services.LanguagesService;

import jakarta.validation.Valid;

@Controller
public class LanguagesController {
private final LanguagesService languagesService;
	
	public LanguagesController(LanguagesService languagesService) {
		this.languagesService= languagesService;
	}
	@RequestMapping("/languages")
	public String index(Model model,@ModelAttribute("languages") Languages language) {
		List<Languages> languages = languagesService.allBooks();
        model.addAttribute("languageList", languages);
		return "index.jsp";
	}
	@PostMapping(value="/adding")
    public String create(@Valid @ModelAttribute("languages") Languages language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/Errors";
        } else {
            languagesService.createLanguage(language);
            return "redirect:/languages";
        }
    }
	@RequestMapping("/Errors")
	public String error() {
		return "Error.jsp";
	}
	
	@RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Languages language = languagesService.findLanguage(id);
        if (language == null) {
            return "redirect:/Errors";
        }
        model.addAttribute("languages", language);
        return "show.jsp";
    }
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
		Languages language = languagesService.findLanguage(id);
		if (language == null) {
            return "redirect:/Errors";
        }
        model.addAttribute("languages", language);
        return "edit.jsp";
    }
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("languages") Languages updatedLanguage, BindingResult result, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            languagesService.updateLanguagesOnCon(id, updatedLanguage);
            return "redirect:/languages";
        }
    }
	@DeleteMapping("/languages/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        languagesService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
