package com.fabianpalma.queryjoin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.queryjoin.repositories.CityRepository;
import com.fabianpalma.queryjoin.repositories.CountryRepository;
import com.fabianpalma.queryjoin.repositories.LanguageRepository;

@Service
public class ApiService {
	@Autowired
	private final CountryRepository countryRepository;

	@Autowired
	private final LanguageRepository languageRepository;
	
	@Autowired
	private final CityRepository cityRepository;
	
	public ApiService(CountryRepository countryRepository,LanguageRepository languageRepository, CityRepository cityRepository) {
		this.countryRepository = countryRepository;
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
	}
	
	
	public List<Object[]> obtenerPaisesLenguajeEsloveno() {
		return countryRepository.obtenerPaisesLenguajeEsloveno();
	}
	
	public List<Object[]> obtenerCiudadesPorPais(){
		return countryRepository.obtenerCiudadesPorPais();
	}
	public List<Object[]> obtenerCiudadesCantidad01(){
		return countryRepository.obtenerCiudadConPopulation01();
	}
	public List<Object[]> obtenerPaisesCon89Lenguaje(){
		return languageRepository.ObtenerEl89Porcent();
	}
	public List<Object[]> obtenerCountriesConTamanos(){
		return countryRepository.obtenerCountriesConTamanos();
	}
	
	public List<Object[]> obtenerPaisesMonarquia(){
		return countryRepository.obtenerPaisesMonarquia();
	}
	public List<Object[]> citiesArgentinas500000(){
		return cityRepository.citiesArgentinas500000();
	}
	public List<Object[]> obtenerCantidadPorRegion(){
		return countryRepository.obtenerCantidadPorRegion();
	}
	




}
