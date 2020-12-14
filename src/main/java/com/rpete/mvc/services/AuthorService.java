package com.rpete.mvc.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.rpete.mvc.models.Author;
import com.rpete.mvc.repositories.AuthorRepository;

@Service
public class AuthorService {
private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    // returns all the books
    public List<Author> allAuthors() {
        return authorRepository.findAll();
    }
	public Author createAuthor(@Valid Author author) {
		// TODO Auto-generated method stub
		return authorRepository.save(author);
	}
}