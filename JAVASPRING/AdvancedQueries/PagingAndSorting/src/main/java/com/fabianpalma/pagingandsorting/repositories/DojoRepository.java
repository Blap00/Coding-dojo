package com.fabianpalma.pagingandsorting.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fabianpalma.pagingandsorting.models.Dojo;

public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{
	@Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
	Page<Object[]> joinDojosAndNinjas(PageRequest pageRequest);
}
