package com.fabianpalma.springdata.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fabianpalma.springdata.models.Book;
import com.fabianpalma.springdata.services.BookServices;

import jakarta.validation.Valid;
@Controller
public class BooksController {
	private final BookServices bookServices;
	
	public BooksController(BookServices bookServices) {
		this.bookServices= bookServices;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookServices.allBooks();
        model.addAttribute("books", books);
        return "/Views/index.jsp";
	}
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/Views/new.jsp";
    }
    @PostMapping(value="/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/Views/new.jsp";
        } else {
            bookServices.createBook(book);
            return "redirect:/books";
        }
    }
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookServices.findBook(id);
        
        if (book == null) {
            // Manejar el caso en que no se encuentre el libro con el ID proporcionado
            // Por ejemplo, redirigir a una página de error o mostrar un mensaje de error
            return "error";
        }
        
        model.addAttribute("book", book);
        return "Views/show.jsp";
    }
}
