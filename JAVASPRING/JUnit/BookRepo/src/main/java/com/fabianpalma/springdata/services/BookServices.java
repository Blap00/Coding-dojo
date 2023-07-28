package com.fabianpalma.springdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabianpalma.springdata.models.Book;
import com.fabianpalma.springdata.repositories.BookRepository;

@Service
public class BookServices {
	//Agregando el book al repositorio como una dependencia
    private final BookRepository bookRepository;
    
    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    //Actualizar Libro
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(title);
            book.setDescription(desc);
            book.setLanguage(lang);
            book.setNumberOfPages(numOfPages);
            
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("No se encontró ningún libro con el ID proporcionado.");
        }
    }
    //Eliminar Libro
    public void deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se encontró ningún libro con el ID proporcionado.");
        }
    }
	
}
