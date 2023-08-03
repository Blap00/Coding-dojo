package com.fabianpalma.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.listaestudiantes.models.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

	List<Classe> findAll();
	

}
