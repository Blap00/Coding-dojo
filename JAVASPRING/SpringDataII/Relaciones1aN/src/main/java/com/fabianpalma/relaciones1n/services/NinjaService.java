package com.fabianpalma.relaciones1n.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.relaciones1.models.Ninja;
import com.fabianpalma.relaciones1n.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> findAll(){
		return ninjaRepository.findAll();
	}

	public Ninja saveNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public Ninja findNinjaById(Long id) {
		Optional<Ninja> optionalNinja= ninjaRepository.findNinjaById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
}
