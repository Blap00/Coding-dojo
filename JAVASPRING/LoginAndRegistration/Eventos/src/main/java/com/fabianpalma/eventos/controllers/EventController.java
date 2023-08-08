package com.fabianpalma.eventos.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.eventos.models.Comment;
import com.fabianpalma.eventos.models.Confirmation;
import com.fabianpalma.eventos.models.Event;
import com.fabianpalma.eventos.models.User;
import com.fabianpalma.eventos.services.CommentService;
import com.fabianpalma.eventos.services.ConfirmationService;
import com.fabianpalma.eventos.services.EventService;
import com.fabianpalma.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/events")
public class EventController {
	@Autowired
	private final EventService eventService;
	
	@Autowired 
	private final ConfirmationService confirmationService;
	
	@Autowired
	private final CommentService commentService;
	
	@Autowired 
	private final UserService userService;
	
	private final String userId= "IDUsuario";

	public EventController(EventService eventService, ConfirmationService confirmationService,
			CommentService commentService, UserService userService) {
		this.eventService = eventService;
		this.confirmationService = confirmationService;
		this.commentService = commentService;
		this.userService = userService;
	}
	
	@ModelAttribute("stateOptions")
    public String[] getStateOptions() {
        return new String[] {"NY", "CA", "AZ", "WA", "TX", "FL", "IL", "CO", "NC", "GA"};
    }
	private String redirectEvent="redirect:/events/";
	//GET METHODS!
	
	@GetMapping("/")
	public String indexEventsGET(HttpSession session, @ModelAttribute("events") Event event,
			Model model
			) {
		model.addAttribute("userId", session.getAttribute(userId));
		User usuario = userService.findUserById((Long) session.getAttribute(userId));

		model.addAttribute("estadosEventos", eventService.getByStateWithJoinStatusForUser(usuario.getState(), usuario.getId()));
		model.addAttribute("eventosDiferentes",eventService.getByNotStateWithJoinStatusForUser(usuario.getState(), usuario.getId()));
		model.addAttribute("user", usuario);	
		model.addAttribute("idActual",session.getAttribute(userId));
		return "EventsIndex.jsp";
	}
	@GetMapping("/{id}")
	public String idEventsGet(@PathVariable("id") Long id, Model model, @ModelAttribute("comment") Comment comment) {
		Event eventData = eventService.findById(id);
	    List<Comment> comments = commentService.findByEvent(eventData);
	    Long attendeesCount = confirmationService.countConfirmationsByEventId(id);
	    List<Confirmation> confirmations = confirmationService.getConfirmationsByEventId(id);
	    
	    model.addAttribute("eventData", eventData);
	    model.addAttribute("comments", commentService.findByEvent(eventData));
	    model.addAttribute("attendeesCount", attendeesCount);
	    model.addAttribute("confirmations", confirmations);
	    return "eventDetails.jsp"; // Cambia a la vista donde mostrarás los detalles del evento y los comentarios
	}
	
	@GetMapping("/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		User currentUser = userService.findUserById((Long) session.getAttribute("IDUsuario"));
	    Event event = eventService.findById(id);
	    
	    // Verifica si el usuario ya se ha unido antes
	    if (!confirmationService.isConfirmed(currentUser, event)) {
	        confirmationService.confirmEvent(currentUser, event);
	    }
	    
	    return "redirect:/events/" + id;

	}
	
	@GetMapping("/{id}/edit")
	public String showEditEventForm(@PathVariable("id") Long eventId, Model model) {
	    Event event = eventService.findById(eventId);
	    model.addAttribute("event", event); // Agregar el evento al modelo
		return "eventsEdit.jsp";
	}
	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	//POST METHODS!
	@PostMapping("/")
	public String indexEventsPOST(@Valid @ModelAttribute("events") Event event, BindingResult result, HttpSession session,Model model) {
		
		if (result.hasErrors()) {
		    System.out.println("ERROR " + result.getAllErrors());
		    return "EventsIndex.jsp"; 
		} else {
		    Date currentDate = new Date();
		    if (event.getDate().after(currentDate)) {
		        eventService.registerEvent(event);    
		        return "redirect:/events/";
		    }else {
		    	return "redirect:/events/";
		    }
		}
	}
	@PostMapping("/{id}")
	public String addComment(@PathVariable("id") Long id, @ModelAttribute("comment") Comment newComment, HttpSession session) {
	    Event eventData = eventService.findById(id);
	    User currentUser = userService.findUserById((Long) session.getAttribute("IDUsuario"));
	    Comment comment = new Comment();
	    comment.setContent(newComment.getContent());
	    comment.setUser(currentUser);
	    comment.setEvent(eventData);

	    commentService.save(comment);

	    return "redirect:/events/" + id;
	}
	@PostMapping("/{eventId}/edit")
	public String editEvent(@PathVariable Long eventId, @ModelAttribute("event") Event updatedEvent) {
	    // Aquí deberías actualizar los datos del evento con los valores del objeto updatedEvent
	    Event existingEvent = eventService.findById(eventId);

	    existingEvent.setName(updatedEvent.getName());
	    existingEvent.setDate(updatedEvent.getDate());
	    existingEvent.setLocation(updatedEvent.getLocation());
	    // Actualiza otros campos según sea necesario

	    eventService.registerEvent(existingEvent); // Guarda los cambios en la base de datos

	    return "redirect:/events/"; // Redirige a la página de lista de eventos u otra ubicación
	}
	
}
