package com.gm.book.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gm.book.business.abstracts.BookTypeService;
import com.gm.book.business.requests.CreateBookTypeRequest;
import com.gm.book.business.responses.GetAllBookTypeResponse;
import com.gm.book.business.responses.GetByIdBookTypeResponse;
import com.gm.book.core.utilities.mappers.ModelMappersService;
import com.gm.book.dataAccess.abstracts.BookTypeRepository;
import com.gm.book.entities.concretes.BookType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor

public class BookTypeManager implements BookTypeService{
	private BookTypeRepository bookTypeRepository;
	private ModelMappersService mappersService;
	
	@Override
	public List<GetAllBookTypeResponse> getAllBookTypeResponses() {
		
		List<BookType> bookTypes = bookTypeRepository.findAll();
		List<GetAllBookTypeResponse>bookTypeResponses= bookTypes.stream()
				.map(booktype->this.mappersService.forResponse().map(bookTypes, GetAllBookTypeResponse.class))
				.collect(Collectors.toList());
		return bookTypeResponses;
	}

@Override
public void add(CreateBookTypeRequest createBookTypeRequest) {
	BookType bookType = mappersService.forRequest().map(createBookTypeRequest, BookType.class);
			this.bookTypeRepository.save(bookType);
	
}

@Override
public GetByIdBookTypeResponse byIdBookTypeResponse(int id) {
	BookType bookType=bookTypeRepository.findById(id).orElseThrow();
	GetByIdBookTypeResponse byIdBookTypeResponse=this.mappersService.forResponse()
		.map(bookType, GetByIdBookTypeResponse.class);	
		
	return byIdBookTypeResponse;
}


	

}
