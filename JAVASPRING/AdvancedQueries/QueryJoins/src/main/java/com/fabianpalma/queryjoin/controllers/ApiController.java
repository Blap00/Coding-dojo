package com.fabianpalma.queryjoin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fabianpalma.queryjoin.services.ApiService;

@Controller
public class ApiController {
	@Autowired
	private final ApiService countryService;
	

	public ApiController(ApiService countryService) {
		this.countryService = countryService;
		
	}


	@GetMapping("/Slovenne")
	public String mostrarPaisesLenguajeEsloveno(Model model) {
		List<Object[]> table = countryService.obtenerPaisesLenguajeEsloveno();
		System.out.println("Actualmente en '/' ");
		model.addAttribute("table", table);
		return "showJpa.jsp";
	}
	
	@GetMapping("/cityCountry")
	public String totalCiudadesPorPais(Model model) {
		List<Object[]> table = countryService.obtenerCiudadesPorPais();
		model.addAttribute("table", table);
		return "showJpa2.jsp";
	}
	
	@GetMapping("/ciudadCantidad01")
	public String cantidadCiudad01(Model model) {
		List<Object[]> table = countryService.obtenerCiudadesCantidad01();
		model.addAttribute("table", table);
		return "showJpa3.jsp";		
	}
	@GetMapping("/paises89Lang")
	public String paises89Lang(Model model) {
		List<Object[]> table = countryService.obtenerPaisesCon89Lenguaje();
		model.addAttribute("table", table);
		return "showJpa4.jsp";		
	}
	@GetMapping("/paisesTamaños")
	public String paisesTamanos(Model model) {
		List<Object[]> table = countryService.obtenerCountriesConTamanos();
		model.addAttribute("table", table);
		return "showJpa5.jsp";		
	}
	@GetMapping("/paisesMonarquia")
	public String paisesMonarquia(Model model) {
		List<Object[]> table = countryService.obtenerPaisesMonarquia();
		model.addAttribute("table", table);
		return "showJpa6.jsp";		
	} //2 HORAS DE ESTUDIO PARA CONSEGUIR ESTO, MEJORAR
	@GetMapping("/citiesArgentinas500000")
	public String citiesArgentinas500000(Model model) {
		List<Object[]> table = countryService.citiesArgentinas500000();
		model.addAttribute("table", table);
		return "showJpa7.jsp";		
	}
	@GetMapping("/obtenerCantidadPorRegion")
	public String obtenerCantidadPorRegion(Model model) {
		List<Object[]> table = countryService.obtenerCantidadPorRegion();
		model.addAttribute("table", table);
		return "showJpa8.jsp";		
	}
//	@GetMapping("/test")
//	public void test() {
////		List<Object[]> table = countryRepository.test();
////		
////		for (Object[] row : table) {
////			System.out.println("- "+row[0]);
////			System.out.println("- "+row[1]);
////		}
//		List<City> table = countryService.test();
//		for (City city : table) {
//			System.out.println(city.getName()+"-"+ city.getPopulation());
//	
//		}
//		
//
//	}
}
