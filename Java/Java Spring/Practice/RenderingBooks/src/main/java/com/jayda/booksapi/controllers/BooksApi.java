package com.jayda.booksapi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jayda.booksapi.models.Book;
import com.jayda.booksapi.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksApi {
	
	private final BookService bookService;
	
	public BooksApi(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("")
	public List<Book> allBooks(){
		return bookService.allBooks();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Book create(
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="numOfPages") Integer numOfPages,
			@RequestParam(value="language") String language
			) {
		Book book = new Book(title , desc , numOfPages , language);
		return bookService.createBook(book);
	}
	
	@RequestMapping("/{id}")
	public Book getOne(@PathVariable("id") Long id) {
		return bookService.findBook(id);
	}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public Book update(
			@PathVariable("id") Long id,
			@RequestParam(value="title") String title,
			@RequestParam(value="description") String desc,
			@RequestParam(value="numOfPages") Integer numOfPages,
			@RequestParam(value="language") String language
			) {
		Book book = new Book(title , desc , numOfPages , language);
		book.setId(id);
		return bookService.updateBook(book);
	}
	
	
	@RequestMapping(value="/{id}" , method=RequestMethod.DELETE)
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
	
}
