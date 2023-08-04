package com.fabianpalma.queryjoin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.queryjoin.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	
	@Query("select c.name, ci.name, ci.district, ci.population "
			+"from City ci join ci.country c "
			+"where c.name='Argentina' AND ci.population > 500000")
	List<Object[]> citiesArgentinas500000();
	



}
