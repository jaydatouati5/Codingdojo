package com.jayda.bookclub.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayda.bookclub.models.Book;
import com.jayda.bookclub.models.User;
import com.jayda.bookclub.services.BookService;
import com.jayda.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookControllers {
	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String books(Model model , HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Book> books = this.bookService.allBooks();
		User user = this.userService.getUser((Long) session.getAttribute("userId"));
		model.addAttribute("books" , books);
		model.addAttribute("user" , user);
		return "books.jsp";
	}
	
	@RequestMapping("/new")
	public String newBook(HttpSession session, Model model) {
		User user = this.userService.getUser((Long) session.getAttribute("userId"));
		model.addAttribute("user" , user);
		model.addAttribute("book" , new Book());
		return "newBook.jsp";
	}
	
	@PostMapping("")
	public String createBook(
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			HttpSession session,
			Model model
			) {
		if (result.hasErrors()) {
			model.addAttribute("user" , this.userService.getUser((Long) session.getAttribute("userId")));
//			model.addAttribute("book" , new Book());
			return "newBook.jsp";
		}
		this.bookService.create(book);
		return "redirect:/books";
	}
	
	@RequestMapping("/{id}")
	public String book(
			@PathVariable("id") Long id,
			HttpSession session,
			Model model
			) {
		Book book = this.bookService.getBook(id);
		User user = this.userService.getUser((Long) session.getAttribute("userId"));
		model.addAttribute("book" , book);
		model.addAttribute("user" , user);
		return "book.jsp";
	}
	
	@RequestMapping("/{id}/edit")
	public String editBook(
			@PathVariable("id") Long id,
			Model model
			) {
		Book book = this.bookService.getBook(id);
		System.out.println(book.getUser());
		model.addAttribute("book" , book);
		return "editBook.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book,
			BindingResult result,
			Model model
			) {
//		book.setId(id);
		if (result.hasErrors()) {
			model.addAttribute("book" , book);
			return "editBook.jsp";
		}
		System.out.println(book.getUser());
		this.bookService.update(book);
		return "redirect:/books";
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		this.bookService.delete(id);
		return "redirect:/books";
	}
}
