package com.rpete.mvc.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpete.mvc.models.Author;
import com.rpete.mvc.models.Book;
import com.rpete.mvc.models.Publication;
import com.rpete.mvc.models.Publisher;
import com.rpete.mvc.services.AuthorService;
import com.rpete.mvc.services.BookService;
import com.rpete.mvc.services.PublisherService;

@Controller
public class AuthorController {
	private final AuthorService authorService;
	private final BookService bookService;
	private final PublisherService publisherService;
	
	public AuthorController(AuthorService aService, BookService bService, PublisherService pService) {
		this.authorService = aService;
		this.bookService = bService;
		this.publisherService = pService;
	}
	
	@RequestMapping("")
	public String index(@ModelAttribute("author") Author author, @ModelAttribute("book") Book book, @ModelAttribute("publisher") Publisher publisher, @ModelAttribute("publications") Publication publication,  Model model) {
		model.addAttribute("authors", authorService.allAuthors());
		model.addAttribute("books", bookService.allBooks());
		model.addAttribute("publishers", publisherService.allPublishers());
		return "index.jsp";
	}
	
	@PostMapping("/authors")
	// or
	// @RequestMapping(value="/books", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("author") Author author, BindingResult result) {
		if (result.hasErrors()) {
            return "index.jsp";
        } else {
            authorService.createAuthor(author);
            return "redirect:/";
        }
	}
	
	
}