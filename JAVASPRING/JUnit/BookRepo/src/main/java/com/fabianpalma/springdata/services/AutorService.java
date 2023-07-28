package com.fabianpalma.springdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.springdata.models.Autor;
import com.fabianpalma.springdata.repositories.AutorRepository;
@Service
public class AutorService {
	
	@Autowired
	private final AutorRepository autorRepository;
    
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }
    //Devolviendo todos los libros.
    public List<Autor> allAutor() {
        return autorRepository.findAll();
    }
    //Creando un libro.
    public Autor createAutor(Autor a) {
        return autorRepository.save(a);
    }
    //Obteniendo la información de un libro
    public Autor findAutor(Long id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        if(optionalAutor.isPresent()) {
            return optionalAutor.get();
        } else {
            return null;
        }
    }
    //Actualizar Libro
    public Autor updateAutor(Long id, String name, String desc, String apellido) {
        Optional<Autor> optionalBook = autorRepository.findById(id);
        
        if (optionalBook.isPresent()) {
        	Autor autor = optionalBook.get();
            autor.setNombre(name);
            autor.setApellido(apellido);
            autor.setDescription(desc);
            
            return autorRepository.save(autor);
        } else {
            throw new IllegalArgumentException("No se encontró ningún libro con el ID proporcionado.");
        }
    }
    //Eliminar Libro
    public void deleteAutor(Long id) {
        Optional<Autor> optionalBook = autorRepository.findById(id);
        
        if (optionalBook.isPresent()) {
        	autorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró ningún libro con el ID proporcionado.");
        }
    }
}
