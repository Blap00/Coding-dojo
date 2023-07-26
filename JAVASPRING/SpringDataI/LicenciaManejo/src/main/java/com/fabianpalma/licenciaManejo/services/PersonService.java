package com.fabianpalma.licenciaManejo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.licenciaManejo.models.Person;
import com.fabianpalma.licenciaManejo.repositories.PersonRepository;
@Service
public class PersonService {
	@Autowired
	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public List<Person> obtenerPersonasSinLicencia() {
		return personRepository.findByLicenseIsNull();
	}
	
	public Boolean personHadLicense(Long id) {
        // Update the method to use the correct property name
        return personRepository.findPersonById(id).getLicense() != null;
    }

	public Person create(Person user) {
		return personRepository.save(user);
	}

	public Person findByPerson(Long id) {
		Optional<Person> optionalUser = personRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public Person updateUser(Person user) {
		return personRepository.save(user);
	}

	public void deleteUser(Long id) {
		personRepository.deleteById(id);
	}
}
