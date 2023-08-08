package com.fabianpalma.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.eventos.models.User;
import com.fabianpalma.eventos.services.UserService;
import com.fabianpalma.eventos.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller

public class UserController {
	@Autowired
	private final UserService userService;
	@Autowired
	private final UserValidator userValidator;
	
	private String userId= "IDUsuario";
	
	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@ModelAttribute("stateOptions")
    public String[] getStateOptions() {
        return new String[] {"NY", "CA", "AZ", "WA", "TX", "FL", "IL", "CO", "NC", "GA"};
    }
	
	@GetMapping("/")
	public String loginRegisterPage(@ModelAttribute("user") User User) {

		return "index.jsp";
	}
	
	@PostMapping("/")
	public String loginPageSend(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpSession session) {
		boolean areAuth=userService.authenticateUser(email, password);
		if(areAuth) {
			User u= userService.findByEmail(email);
			session.setAttribute(userId, u.getId());
			return "redirect:/events/";	
		}else {
			return "redirect:/";
		}
	}	
	@PostMapping("/register")
	public String registerFormSend(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			User usuario = userService.registerUser(user);
			session.setAttribute(userId, usuario.getId());
			return "redirect:/";			
		}
	}
}
