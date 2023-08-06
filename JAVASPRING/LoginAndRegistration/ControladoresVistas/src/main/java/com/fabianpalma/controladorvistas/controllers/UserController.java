package com.fabianpalma.controladorvistas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.controladorvistas.models.User;
import com.fabianpalma.controladorvistas.services.UserService;
import com.fabianpalma.controladorvistas.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.Objects;

//imports removidos para resumir.
@Controller
public class UserController {
	@Autowired
	private final UserService userService;
	@Autowired
	private final UserValidator userValidator;

	public UserController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	private String userId= "UserID";

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "redirect:/registration";
		}
		else {
			User us = userService.registerUser(user);
			session.setAttribute(userId, us.getId());
			return "redirect:/login";
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,HttpSession session) {
//Si el usuario está autenticado, guarde su id de usuario en el objeto Session
//sino agregue un mensaje de error y retorne a la página de inicio de sesión.
		boolean areAuth=userService.authenticateUser(email, password);
		if(areAuth) {
			User u= userService.findByEmail(email);
			session.setAttribute(userId, u.getId());
			return "redirect:/home";
		}else {
			model.addAttribute("error", "ERROR AL INICIAR SESIÓN, INTENTA NUEVAMENTE");
			return "redirect:/login";
		}
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		// Obtener el usuario desde session, guardarlo en el modelo y retornar a la
		// página principal
		Long userID= (Long) session.getAttribute(userId);
		if(userID==null) {
			model.addAttribute("ERROR", "No hay un usuario registrado con tu ID");
			return "redirect:/registration";
		}else {
			User user= userService.findUserById(userID);
			model.addAttribute("user", user);
			return "index.jsp";			
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// invalidar la sesión
		// redireccionar a la página de inicio de sesión.
		session.invalidate();
		return "loginPage.jsp";
	}
}
