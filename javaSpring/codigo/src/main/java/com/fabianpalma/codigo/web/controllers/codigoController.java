package com.fabianpalma.codigo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class codigoController {
	private String route = "Views/index.jsp";
	@RequestMapping("/")
    public String index() {
        return route;
    }
	@RequestMapping("/code")
    public String counter() {
        return "Views/bushidoCode.jsp";
    }
	@PostMapping(value="/checkCode")
    public String checkCode(@RequestParam(value="textAdd") String code) {
        if(code.equals("bushido")) {
        	return "redirect:/code";
        }
        else {
        	return "redirect:/createError";        	
        }
    }
	@RequestMapping("/createError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You must train Harder!");
        return "redirect:/";
	}
}
