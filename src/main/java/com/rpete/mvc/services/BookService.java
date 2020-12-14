package com.rpete.mvc.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.rpete.mvc.models.Book;
import com.rpete.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
	public void addBook(@Valid Book book) {
		bookRepository.save(book);
	}
}

