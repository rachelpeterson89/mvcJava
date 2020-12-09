package com.rpete.mvc.controllers;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rpete.mvc.models.Book;
import com.rpete.mvc.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String show(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/show.jsp";
    }
    
    @RequestMapping("/books/{id}")
    public String showOne(@PathVariable("id") Long id, Model model) {
    	Book oneBook = bookService.findBook(id);
    	model.addAttribute("book", oneBook);
    	return "/books/showOne.jsp";
    }
}
