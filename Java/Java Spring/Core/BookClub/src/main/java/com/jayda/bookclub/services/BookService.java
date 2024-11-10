package com.jayda.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayda.bookclub.models.Book;
import com.jayda.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}
	
	public Book create(Book book) {
		return bookRepository.save(book);
	}
	
	public Book update(Book book) {
		return bookRepository.save(book);
	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
}
