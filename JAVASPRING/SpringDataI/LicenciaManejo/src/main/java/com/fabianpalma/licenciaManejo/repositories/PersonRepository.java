package com.fabianpalma.licenciaManejo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.licenciaManejo.models.License;
import com.fabianpalma.licenciaManejo.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findAll();
	
    Person findPersonById(Long id);

    // Update the method to use the property name representing the License relationship
    License findByLicensePerson(Person person);

    List<Person> findByLicenseIsNull();
	
}
