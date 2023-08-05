package com.fabianpalma.pagingandsorting.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fabianpalma.pagingandsorting.models.Ninja;

public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{

}