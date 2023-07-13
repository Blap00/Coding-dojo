package com.fabianpalma.MostrarFecha.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MostrarFechaController {
	@RequestMapping("/")
    public String index(Model model) {
        return "index.jsp";
    }
	@RequestMapping("/date")
    public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");
		String dateToday = dateFormat.format(date);
		model.addAttribute("date", dateToday);
        return "date.jsp";
    }
	@RequestMapping("/time")
    public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH':'mm a");
		String datetime = dateFormat.format(date);
        model.addAttribute("dateTime", datetime);
        return "time.jsp";
    }
}
