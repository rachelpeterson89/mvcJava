package com.rpete.mvc.services;

import java.util.List;
import java.util.Optional;

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
        return (List<Book>) bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // updates a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book optionalBook = this.findBook(id);
		optionalBook.setTitle(title);
		optionalBook.setDescription(desc);
		optionalBook.setLanguage(lang);
		optionalBook.setNumberOfPages(numOfPages);
		return bookRepository.save(optionalBook);
	}
	
	// deletes a book by id
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		return;
	}
}
