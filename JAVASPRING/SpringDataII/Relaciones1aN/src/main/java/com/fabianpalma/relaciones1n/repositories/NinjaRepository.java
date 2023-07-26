package com.fabianpalma.relaciones1n.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.relaciones1.models.Ninja;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long>{

	List<Ninja> findAll();
	
	Optional<Ninja> findNinjaById(Long id);
}
