package com.fabianpalma.listaestudiantes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.listaestudiantes.models.Contact;
import com.fabianpalma.listaestudiantes.models.Student;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

	List<Contact> findAll();
	
//	Optional<Contact> findByContact(Optional<Student> optionalPerson);

//	Optional<Contact> findContactById(Long id);
	
//	List<Contact> findByContactNotContaining(Student student);

}
