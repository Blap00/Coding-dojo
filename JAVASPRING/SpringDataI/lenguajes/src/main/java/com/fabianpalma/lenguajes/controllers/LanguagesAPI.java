package com.fabianpalma.lenguajes.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabianpalma.lenguajes.models.Languages;
import com.fabianpalma.lenguajes.services.LanguagesService;
@RestController
public class LanguagesAPI {
	private final LanguagesService languagesService;
	public LanguagesAPI(LanguagesService languagesService) {
		this.languagesService= languagesService;
	}
	@RequestMapping("/api/languages")
	public List<Languages> index(){
		return languagesService.allBooks();
	}
	@PostMapping(value="/api/languages")
	public Languages create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator,@RequestParam(value="currentVersion") float currentVersion) {
		Languages language= new Languages(name, creator, currentVersion);
		return languagesService.createLanguage(language);
	}
	@RequestMapping("/api/languages/{id}")
	public Languages show( @PathVariable("id") Long id) {
		return languagesService.findLanguage(id);
	}
	@PutMapping(value = "/api/languages/{id}")
	public Languages update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="currentVersion") float currentVersion) {
		return languagesService.updateLanguages(id, name, creator, currentVersion);
	}
	@DeleteMapping(value="/api/languages/{id}")
	public void deleteVar(@PathVariable("id") Long id) {
		languagesService.deleteLanguage(id);
	}
}
