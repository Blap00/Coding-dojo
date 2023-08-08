package com.fabianpalma.eventos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabianpalma.eventos.models.Event;
import com.fabianpalma.eventos.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private final EventRepository eventRepo;
	
	public EventService(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}
	
	public List<Event> findAll(){
		return eventRepo.findAll();
	}	
	
	public List<Event> findByState(String state){
		return eventRepo.findByState(state);
	}
	
	public List<Object[]> getByStateWithJoinStatusForUser(String state, Long userId){
		return eventRepo.getByStateWithJoinStatusForUser(state,userId);
	}
	
	public List<Object[]> getByNotStateWithJoinStatusForUser(String state, Long userId){
		return eventRepo.getEventsWithDifferentStateForUser(state,userId);
	}
	
	public Event registerEvent(Event e) {
        return eventRepo.save(e);
    }
	public Event findById(Long id) {
		Optional<Event> eventOpt= eventRepo.findById(id);
		if(eventOpt.isPresent()) {
			return eventOpt.get();
		}else {
			return null;
		}
	}	
}
