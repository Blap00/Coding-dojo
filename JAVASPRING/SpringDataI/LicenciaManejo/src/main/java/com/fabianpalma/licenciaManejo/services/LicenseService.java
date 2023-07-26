package com.fabianpalma.licenciaManejo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.licenciaManejo.models.License;
import com.fabianpalma.licenciaManejo.models.Person;
import com.fabianpalma.licenciaManejo.repositories.LicenseRepository;
import com.fabianpalma.licenciaManejo.repositories.PersonRepository;
@Service
public class LicenseService {
	// Agregando el license al repositorio como una dependencia
	
	@Autowired
	private final LicenseRepository licenseRepository;
	@Autowired
	private final PersonRepository personRepository;

	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}

	public List<License> findAll() {
		return licenseRepository.findAll();
	}

	public License saveLicense(License license) {
		return licenseRepository.save(license);
	}

	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
	
	public License findLicenseByPersonId(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		Optional<License> optionalLicense = licenseRepository.findByPerson(optionalPerson);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}

	public License updateLicense(License license) {
		return licenseRepository.save(license);
	}

	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
