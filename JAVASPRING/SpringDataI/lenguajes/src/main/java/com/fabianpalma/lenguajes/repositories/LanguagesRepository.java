package com.fabianpalma.lenguajes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.lenguajes.models.Languages;
@Repository
public interface LanguagesRepository extends CrudRepository<Languages, Long> {
	
	//Este método recupera todos los libros de la base de datos
    List<Languages> findAll();
    //FILTER
    //Este método encuentra un libro por su descripción
    List<Languages> findByNameContaining(String search);
    //Count(title)
    //Este método cuenta cuántos Creadores contiene cierta cadena en el nombre
    Long countByCreatorContaining(String search);
    //filter delete
    //Este método borra un Creador que empieza con un Nombre específico
    Long deleteByCreatorStartingWith(String search);
    

}
