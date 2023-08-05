package com.fabianpalma.pagingandsorting.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fabianpalma.pagingandsorting.repositories.DojoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ApiService {
    private final DojoRepository dojoRepository;

    public ApiService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public Page<Object[]> joinDojosAndNinjas(int pageNumber) {
        PageRequest pageRequest = PageRequest.of(pageNumber, 5, Sort.by(Sort.Direction.ASC, "name"));
        Page<Object[]> dojos = dojoRepository.joinDojosAndNinjas(pageRequest);

        return dojos;
    }
}
