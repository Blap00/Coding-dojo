package com.fabianpalma.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fabianpalma.eventos.models.Confirmation;
import com.fabianpalma.eventos.models.Event;
import com.fabianpalma.eventos.models.User;

@Repository
public interface ConfirmationRepository extends CrudRepository<Confirmation, Long>{
	// Verifica si existe una confirmación para un usuario y un evento dados
    boolean existsByUserAndEvent(User user, Event event);
    
    // Busca una confirmación específica por usuario y evento
    Confirmation findByUserAndEvent(User user, Event event);

    Long countByEventId(Long eventId);
    
    List<Confirmation> findByEventId(Long eventId);
}
