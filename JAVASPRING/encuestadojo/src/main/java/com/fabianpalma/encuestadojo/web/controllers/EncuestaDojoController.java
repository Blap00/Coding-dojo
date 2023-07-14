package com.fabianpalma.encuestadojo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class EncuestaDojoController {
	@RequestMapping("/")
    public String index() {
        return "Views/index.jsp";
    }
	@RequestMapping("/result")
    public String counter(HttpSession session, Model model) {
		//ADD VALUES TO STRING
		String name = (String) session.getAttribute("name");
		String dojoLoc = (String) session.getAttribute("dojoLoc");
		String favLang = (String) session.getAttribute("favLang");
		String commentarea = (String) session.getAttribute("commentarea");
		//ADD VALUES TO MODEL
	    model.addAttribute("name", name);
		model.addAttribute("dojoLoc",dojoLoc);
		model.addAttribute("favLang",favLang);
		model.addAttribute("commentarea",commentarea);
		//RETURN THE SITE
        return "Views/result.jsp";
    }
	@PostMapping(value="/checkForm")
    public String checkForm(
    		@RequestParam(value="name", required=true) String name,
    		@RequestParam(value="dojoLoc", required=true) String dojoLoc,
    		@RequestParam(value="favLang", required=true) String favLang,
    		@RequestParam(value="commentarea", required=false) String commentarea,
    		HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("dojoLoc", dojoLoc);
		session.setAttribute("favLang", favLang);
		session.setAttribute("commentarea", commentarea);
		
        if(!name.isEmpty()) {
        	if(favLang.equals("Java")) {
            	return "redirect:/anotherSite";
            }else {
            	return "redirect:/result";
            }
        }
        else{
        	return "redirect:/createError";        	
        }
    }
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "¡Deberias escribir un nombre!");
        return "redirect:/";
	}
	@RequestMapping("/anotherSite")
	public String anoSite() {
		return "Views/site.jsp";
	}
}
