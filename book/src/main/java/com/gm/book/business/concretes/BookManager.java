package com.gm.book.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.book.business.abstracts.BookService;
import com.gm.book.business.requests.CreateBookRequest;
import com.gm.book.business.requests.DeleteBookRequest;
import com.gm.book.business.requests.UpdateBookRequest;
import com.gm.book.business.responses.GetAllBookResponse;
import com.gm.book.business.responses.GetByIdResponse;
import com.gm.book.business.rules.BookBusinessRules;
import com.gm.book.core.utilities.mappers.ModelMappersService;
import com.gm.book.dataAccess.abstracts.BookRepository;
import com.gm.book.entities.concretes.Book;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookManager implements BookService{
   private BookRepository bookRepository;
   private ModelMappersService modelMappersService;
   private BookBusinessRules bookBusinessRules;
   

	@Override
	public List<GetAllBookResponse> getAll() {
		
		List<Book> books = bookRepository.findAll();
		List<GetAllBookResponse> bookResponses = books.stream()
				.map(book->this.modelMappersService.forResponse().map(books, GetAllBookResponse.class))
				.collect(Collectors.toList());
		return bookResponses;
	}

	@Override
	public void add(CreateBookRequest createBookRequest)  {
		this.bookBusinessRules.checkIfBookNameExists(createBookRequest.getName());
		Book book = modelMappersService.forRequest().map(createBookRequest, Book.class);
			this.bookRepository.save(book);
		
	}
		
	

	@Override
	public void update(UpdateBookRequest updateBookRequest) {
		Book book = modelMappersService.forRequest().map(updateBookRequest, Book.class);
		this.bookRepository.save(book);
		
	}

	@Override
	public void delete(DeleteBookRequest deleteBookRequest) {
		Book book = new Book();
		book.setId(deleteBookRequest.getId());
		bookRepository.delete(book);
		
	}

	@Override
	public GetByIdResponse getByIdResponse(int id) {
       Book book= bookRepository.findById(id).orElseThrow();
       GetByIdResponse getByIdResponse = this.modelMappersService.forResponse().map(book,GetByIdResponse.class);
		return getByIdResponse;
	}

	
		
	}


