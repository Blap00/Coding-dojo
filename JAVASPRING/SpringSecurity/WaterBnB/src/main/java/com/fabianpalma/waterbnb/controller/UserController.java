package com.fabianpalma.waterbnb.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.waterbnb.models.User;
import com.fabianpalma.waterbnb.services.UserService;
import com.fabianpalma.waterbnb.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private final UserService userService;
	@Autowired
	private final UserValidator userValidator;
	@Autowired
	private final UserDetailsService userDetail;
	
	public UserController(UserService userService, UserValidator userValidator, UserDetailsService userDetail) {
		this.userService = userService;
		this.userValidator = userValidator;
		this.userDetail = userDetail;
	}
	
	@RequestMapping("/guest/signin")
	public String loginAndReg(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials. Please try again.");
		}
		
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		
		return "loginRegView";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		
		if (result.hasErrors()) {
			return "loginRegView";
		} else {
			if ((user.getRole()).equals("host")) {
				userService.saveWithHostRole(user);
			} else if ((user.getRole()).equals("guest")) {
				userService.saveWithGuestRole(user);
			}
			return "redirect:/reroute";
		}
	}
	
	@RequestMapping(value= {"/", "/reroute"})
	public String selectView (Principal principal) {
		User currentUser = userService.findByEmail(principal.getName());
		
		if ((currentUser.getRole()).equals("host")) {
			return "redirect:/host/dashboard";
		} else if ((currentUser.getRole()).equals("guest")) {
			return "redirect:/search";
		} else {
			return "redirect:/landing";
		}
	}
	
	
}