package com.fabianpalma.relaciones1n.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.relaciones1.models.Dojo;
import com.fabianpalma.relaciones1n.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> findAll() {
		return dojoRepository.findAll();
	}
	
	public Dojo findDojoById(Long id) {
		Optional<Dojo> optionalDojo= dojoRepository.findById(id); //Generamos un optional con el valor de la ID
		if(optionalDojo.isPresent()) {//Preguntamos si el valor esta presente
			return optionalDojo.get();//Retornamos el valor en DOJO para su uso
		}else { //SINO
			return null; //RETORNA NULL
		}
	}
	public Dojo uptadeDojo(Dojo dojo) { //ACTUALIZA DOJO
		return dojoRepository.save(dojo);	//Guarda valores actualizados de DOJO
	}
	public Dojo createDojo(Dojo dojo) { //ACTUALIZA DOJO
		return dojoRepository.save(dojo);	//Guarda valores actualizados de DOJO
	}
	public void deleteDojo(Long id) {//BORRA DOJO
		dojoRepository.deleteById(id);	//Elimina los valores presentes de DOJO
	}
}
