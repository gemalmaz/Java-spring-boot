package com.gm.book.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gm.book.business.abstracts.BookTypeService;
import com.gm.book.business.requests.CreateBookTypeRequest;
import com.gm.book.business.responses.GetAllBookTypeResponse;
import com.gm.book.business.responses.GetByIdBookTypeResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/booktype")
@AllArgsConstructor
public class BookTypesController {
	private BookTypeService bookTypeService;
	
	@GetMapping
	public List<GetByIdBookTypeResponse>getByIdBookTypeResponses(){
		return this.getByIdBookTypeResponses();
		
	}
	
	@GetMapping("/{id}")
	public GetByIdBookTypeResponse getByIdBookTypeResponse(@PathVariable int id) {
		return this.bookTypeService.byIdBookTypeResponse(id);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public void add(@org.springframework.web.bind.annotation.RequestBody CreateBookTypeRequest createBookTypeRequest) {
		this.bookTypeService.add(createBookTypeRequest);
	}

}
