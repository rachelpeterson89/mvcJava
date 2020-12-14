package com.rpete.mvc.controllers;


import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.rpete.mvc.models.Book;
//import com.rpete.mvc.models.Publisher;
import com.rpete.mvc.services.BookService;
//import com.rpete.mvc.services.PublisherService;


@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			bookService.addBook(book);
			return "redirect:/";
		}
	}
    
//    @RequestMapping("")
//    public String show(@ModelAttribute("book") Book book, @ModelAttribute("publisher") Publisher publisher, Model model) {
//        List<Book> books = bookService.allBooks();
//        List<Publisher> publishers = publisherService.allPublishers();
//        model.addAttribute("books", books);
//        model.addAttribute("publishers", publishers);
//        return "/books/show.jsp";
//    }
//    
//    @PostMapping("/book/create")
//    public String addBook(Model model, @ModelAttribute("book") Book book, BindingResult result) {
//    	if (result.hasErrors()) {
//			return "/books/show.jsp";
//		} else {
//			bookService.createBook(book);
//			return "redirect:/";
//		}
//    }
//    
//    
//    @RequestMapping("/books/{id}")
//    public String showOne(@PathVariable("id") Long id, Model model) {
//    	Book oneBook = bookService.findBook(id);
//    	model.addAttribute("book", oneBook);
//    	return "/books/showOne.jsp";
//    }
//    
//    @RequestMapping(value="/books/{id}", method=RequestMethod.POST)
//    public String destroy(@PathVariable("id") Long id) {
//    	bookService.deleteBook(id);
//    	return "redirect:/books";
//    }
}
