package com.fabianpalma.paneladministracion.controllers;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabianpalma.paneladministracion.models.User;
import com.fabianpalma.paneladministracion.services.UserService;
import com.fabianpalma.paneladministracion.validator.UserValidator;


@Controller
public class HomeController {
	
	private final UserService userService;
	private final UserValidator userValidator;
	
	private String registrationSite= "registrationPage.jsp";

	public HomeController(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}

	//===================PAGINA HOME======================
	@GetMapping("/")
    public String showForm(@ModelAttribute("user") User user, Model model) {
        return registrationSite;

    }

	@PostMapping("/log")
	public String processForm(@RequestParam(value = "action", required = false) String action,
	                          @Valid @ModelAttribute("user") User user, BindingResult result,
	                          Model model, HttpSession session) {
		System.out.println(action);
	    if ("action,register".equals(action)) {
	    	System.out.println("Register");
	        userValidator.validate(user, result);
	        if (result.hasErrors()) {
	            return registrationSite;
	        }
	        User registeredUser = userService.registerUser(user);
	        session.setAttribute("userId", registeredUser.getId());
	        return "redirect:/";
	        
	    } else {
	    	System.out.println("action,login");
	        boolean isAuthenticated = userService.authenticateUser(user.getEmail(), user.getPassword());
	        if (isAuthenticated) {
	            User loggedInUser = userService.findByEmail(user.getEmail());
	            session.setAttribute("userId", loggedInUser.getId());
	            if (loggedInUser.isAdmin()) {
	            	System.out.println("loged as Admin");
	                return "redirect:/admin"; 
	            } else {
	            	System.out.println("loged as IDK");
	            	return "redirect:/dashboard"; 
	            }
	        } else {
	            model.addAttribute("error", "Invalid Credentials. Please try again!");
	            System.out.println("There is Invalid Credentials!");
	            return registrationSite;
	        }
	    }
	}

   	@GetMapping("/dashboard")
    public String showUser(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
	    model.addAttribute("user", user); 
        return "showUser.jsp";
    }
	@GetMapping("/dashboard/logout")
	public String logout(HttpSession session) {
	    Long userId = (Long) session.getAttribute("userId");
	    
	    if (userId != null) {
	        User user = userService.findUserById(userId);
	        
	        if (user != null) {
	            session.invalidate();
	            user.setLastLogoutDate(new Date()); // Actualiza la fecha de cierre de sesión
	            userService.updateUser(user);
	        }
	    }
	    
	    return "redirect:/";
	}

	//==================PANEL DE ADMINISTRACION=================
	@GetMapping("/admin")
	public String adminPanel(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User admin = userService.findUserById(userId);
		List<User> users = userService.findAll();
	    model.addAttribute("users", users);
	    model.addAttribute("admin", admin);
	    return "adminPanel.jsp";
	}
	
    @DeleteMapping("/admin/{userId}/delete")
    public String deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return "redirect:/admin";
    }
    
    @PostMapping("/admin/assign-admin/{userId}")
    public String assignAdminRole(@PathVariable Long userId) {
        userService.assignAdminRole(userId);
        return "redirect:/admin";
    }
    
    
}
    

    




	







