package com.fabianpalma.contador.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class contadorController {
	private int counter = 0;
	private String route = "Views/index.jsp";
	@RequestMapping("/")
    public String index() {
		counter +=1;
        return route;
    }
	@RequestMapping("/counter")
    public String counter(HttpSession session) {
		session.setAttribute("counter", counter);
        return "Views/counter.jsp";
    }
	@RequestMapping("/plustTwo")
    public String plusTwo() {
		counter += 2;
        return route;
    }
	@RequestMapping("/reset")
    public String reset(Model model) {
		counter = 0;
        return route;
    }
}
