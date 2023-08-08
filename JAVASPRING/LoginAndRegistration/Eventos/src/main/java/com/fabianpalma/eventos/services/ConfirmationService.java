package com.fabianpalma.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.eventos.models.Confirmation;
import com.fabianpalma.eventos.models.Event;
import com.fabianpalma.eventos.models.User;
import com.fabianpalma.eventos.repositories.ConfirmationRepository;

@Service
public class ConfirmationService {

	@Autowired
	private final ConfirmationRepository confirmationRepo;
	
	public ConfirmationService(ConfirmationRepository confirmationRepo) {
		this.confirmationRepo = confirmationRepo;
	}
	

	// Verifica si un usuario ya ha confirmado su asistencia a un evento
    public boolean isConfirmed(User user, Event event) {
        return confirmationRepo.existsByUserAndEvent(user, event);
    }

 // Registra una confirmación de asistencia de un usuario a un evento
    public Confirmation confirmEvent(User user, Event event) {
        Confirmation confirmation = new Confirmation();
        confirmation.setUser(user);
        confirmation.setEvent(event);
        return confirmationRepo.save(confirmation);
    }
    
    public Long countConfirmationsByEventId(Long eventId) {
        return confirmationRepo.countByEventId(eventId);
    }


    public List<Confirmation> getConfirmationsByEventId(Long eventId) {
        return confirmationRepo.findByEventId(eventId);
    }




}
