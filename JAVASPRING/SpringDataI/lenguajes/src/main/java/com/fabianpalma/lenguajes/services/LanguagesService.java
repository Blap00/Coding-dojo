package com.fabianpalma.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabianpalma.lenguajes.models.Languages;
import com.fabianpalma.lenguajes.repositories.LanguagesRepository;
@Service
public class LanguagesService {
	//Agregando el book al repositorio como una dependencia
    private final LanguagesRepository languageRepository;
    
    public LanguagesService(LanguagesRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    //Devolviendo todos los libros.
    public List<Languages> allBooks() {
        return languageRepository.findAll();
    }
    //Creando un libro.
    public Languages createLanguage(Languages b) {
        return languageRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Languages findLanguage(Long id) {
        Optional<Languages> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    //Actualizar Libro
    public Languages updateLanguages(Long id, String name, String creator, Float currentVersion) {
        Optional<Languages> optionalLanguage= languageRepository.findById(id);
        
        if (optionalLanguage.isPresent()) {
            Languages languages = optionalLanguage.get();
            languages.setName(name);
            languages.setCreator(creator);
            languages.setCurrentVersion(currentVersion);
            
            return languageRepository.save(languages);
        } else {
            throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado!.");
        }
    }
    //Actualizar desde el sitio; 
    public Languages updateLanguagesOnCon(Long id, Languages updatedLanguage) {
        Optional<Languages> optionalBook = languageRepository.findById(id);
        
        if (optionalBook.isPresent()) {
        	Languages language = optionalBook.get();
        	language.setName(updatedLanguage.getName());
        	language.setCreator(updatedLanguage.getCreator());
            language.setCurrentVersion(updatedLanguage.getCurrentVersion()+1);
            return languageRepository.save(language);
        } else {
            throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
        }
    }
    //Eliminar Libro
    public void deleteLanguage(Long id) {
        Optional<Languages> optionalLanguage = languageRepository.findById(id);
        
        if (optionalLanguage.isPresent()) {
            languageRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró ningún lenguaje con el ID proporcionado.");
        }
    }
}
