//package com.fabianpalma.queryjoin.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.fabianpalma.queryjoin.models.Country;
//import com.fabianpalma.queryjoin.services.CountryService;
//
//@Controller
//@RequestMapping("/country")
//public class countryController {
//	private final CountryService countryService;
//
//    @Autowired
//    public countryController(CountryService countryService) {
//        this.countryService = countryService;
//    }
////
////    @GetMapping("/countries-speaking-slovene")
////    public List<Country> getCountriesSpeakingSlovene() {
////        return countryService.getCountriesSpeakingSlovene();
////    }
////
////    @GetMapping("/total-cities-per-country")
////    public List<Object[]> getTotalCitiesPerCountry() {
////        return countryService.getTotalCitiesPerCountry();
////    }
//
////    @GetMapping("/cities-in-mexico-with-population-greater-than")
////    public List<City> getCitiesInMexicoWithPopulationGreaterThan(int population) {
////        return apiService.getCitiesInMexicoWithPopulationGreaterThan(population);
////    }
//
//}
