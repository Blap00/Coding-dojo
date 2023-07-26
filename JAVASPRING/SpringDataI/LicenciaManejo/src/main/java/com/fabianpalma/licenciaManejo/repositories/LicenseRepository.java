package com.fabianpalma.licenciaManejo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.licenciaManejo.models.License;
import com.fabianpalma.licenciaManejo.models.Person;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long>{
	List<License> findAll();
	Optional<License> findByPerson(Optional<Person> optionalPerson);
	

}
