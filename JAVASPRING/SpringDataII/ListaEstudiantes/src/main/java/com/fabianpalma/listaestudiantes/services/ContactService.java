package com.fabianpalma.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.listaestudiantes.models.Contact;
import com.fabianpalma.listaestudiantes.models.Student;
import com.fabianpalma.listaestudiantes.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	// GET ALL ON CATEGORIES (R)
	public List<Contact> allContact() {
		return contactRepository.findAll();
	}

	// Get a null category
//	public List<Contact> nullContact(Student student) {
//		return contactRepository.findByContactNotContaining(student);
//	}

	// GET by ID
	public Optional<Contact> findById(Long id) {
		return contactRepository.findById(id);
	}

	// Create or Upadte
	public Contact createContact(Contact c) {
		return contactRepository.save(c);
	}

	// Delete
	public void deleteCategory(Long id) {
		contactRepository.deleteById(id);
	}

}
