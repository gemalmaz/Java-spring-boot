package com.gm.book.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gm.book.business.abstracts.BookService;
import com.gm.book.business.requests.CreateBookRequest;
import com.gm.book.business.requests.DeleteBookRequest;
import com.gm.book.business.requests.UpdateBookRequest;
import com.gm.book.business.responses.GetByIdResponse;

@RestController
@RequestMapping("/api/book")
public class BooksController {
	private BookService bookService;
  @Autowired
	public BooksController(BookService bookService) {
		
		this.bookService = bookService;
	}
	@GetMapping("/{id}")
 public GetByIdResponse getByIdResponse(@PathVariable int id){
	return bookService.getByIdResponse(id);
		
	}
	 @PostMapping()
	 @ResponseStatus(code=HttpStatus.CREATED)
	 public void add(CreateBookRequest createBookRequest) throws Exception {
		 this.bookService.add(createBookRequest);
	 }
	 @PutMapping("/update")
	 public void update(UpdateBookRequest updateBookRequest) {
		 this.bookService.update(updateBookRequest);
	 }
	 @DeleteMapping("/{id}")
		 public void delete(DeleteBookRequest deleteBookRequest) {
			 this.bookService.delete(deleteBookRequest);
		 }
	 }
	 
 

