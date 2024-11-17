package com.example.demo.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;

import org.springframework.ui.Model;

@Controller
public class BooksController {
	
	@Autowired
	BookRepository books;
	
	@GetMapping("/")
	public String addBook() {
		return "index";
	}
	
	@PostMapping("/storedata")
	public String addBook(Book book) {
		//TODO: process POST request
		
		books.save(book);
		
		return "redirect:/books/display";
	}
	@GetMapping("/books/display")
	public String display(Model model) {
		List<Book> booklist = (List<Book>)books.findAll();
		model.addAttribute("books",booklist);	
//		model.addAttribute("cars",car_list);

		return "display";
 	}
	
	@GetMapping("/books/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		books.deleteById(id);
		return "redirect:/books/display";
	}
	
	@GetMapping("/books/update/{id}")
	public String updateBook(@PathVariable Integer id, Model model) {
		Book book = books.findById(id).get();
		
		model.addAttribute("book",book);
		return "edit";
	}
	
	@PostMapping("/updatedata")
	public String UpdateBook(Book book) {
		
		Integer id = book.getId();
		String bookName = book.getBookName();
		String borrowerName = book.getBorrowerName();
		Long borrowerPhone = book.getBorrowerPhone();
		Date borrowDate = book.getBorrowDate();
		Date returnDate = book.getReturnDate();
		
		Book bookdb = books.findById(id).get();
		
		bookdb.setBookName(bookName);
		bookdb.setBorrowerName(borrowerName);
		bookdb.setBorrowerPhone(borrowerPhone);
		bookdb.setBorrowDate(borrowDate);
		bookdb.setReturnDate(returnDate);

		return "redirect:/books/display";

	}
	
}
