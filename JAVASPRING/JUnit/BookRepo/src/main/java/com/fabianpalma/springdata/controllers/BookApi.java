package com.fabianpalma.springdata.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabianpalma.springdata.models.Autor;
import com.fabianpalma.springdata.models.Book;
import com.fabianpalma.springdata.services.AutorService;
import com.fabianpalma.springdata.services.BookServices;

@RestController
public class BookApi {
	private final BookServices bookService;
	private final AutorService autorService;
	
	public BookApi(BookServices bookService,AutorService autorService) {
		this.bookService = bookService;
		this.autorService= autorService;
	}

	@RequestMapping("/api/books")
	public List<Book> indexbooks() {
		return bookService.allBooks();
	}

	@RequestMapping(value = "/api/books", method = RequestMethod.POST)
	public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc,
			@RequestParam(value = "language") String lang, @RequestParam(value = "pages") Integer numOfPages) {
		Book book = new Book(title, desc, lang, numOfPages);
		return bookService.createBook(book);
	}

	@RequestMapping("/api/books/{id}")
	public Book show(@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		return book;
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public Book update(@PathVariable("id") Long id, @RequestParam(value = "title") String title,
			@RequestParam(value = "description") String desc, @RequestParam(value = "language") String lang,
			@RequestParam(value = "pages") Integer numOfPages) {
		Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
		return book;
	}

	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	public void destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
	@RequestMapping("/api/autor")
	public List<Autor> indexautor(){
		return autorService.allAutor();
	}
	@PostMapping("/api/autor")
	public Autor createautor(@RequestParam(value = "name") String name, @RequestParam(value = "last_name") String last_name,
			@RequestParam(value = "desc") String desc) {
		Autor autor= new Autor(name,last_name,desc);
		return autorService.createAutor(autor);
	}
	@GetMapping("/api/autor/{id}")
	public Autor showautor(@PathVariable("id") Long id) {
		Autor autor= autorService.findAutor(id);
		return autor;
	}
	@PutMapping("/api/autor/{id}")
	public Autor update(@PathVariable("id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "last_name") String last_name,
			@RequestParam(value = "desc") String desc) {
		Autor autor=autorService.updateAutor(id, name, last_name, desc);
		return autor;
	}
	@DeleteMapping("/api/autor/{id}")
	public void deleteAutor(@PathVariable("id") Long id) {
		autorService.deleteAutor(id);
	}
	
}
