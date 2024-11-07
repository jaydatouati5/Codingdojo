package com.jayda.booksapi.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.booksapi.models.Book;
import com.jayda.booksapi.services.BookService;

@Controller
public class BooksController {

	private final BookService bookService;
	
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/books/{id}")
	public String index(
			@PathVariable("id") Long id,
			Model model
			) {
		Book book = bookService.findBook(id);
		model.addAttribute("book" , book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
	
}
