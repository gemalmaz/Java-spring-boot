package com.gm.book.business.abstracts;

import java.util.List;

import com.gm.book.business.requests.CreateBookRequest;
import com.gm.book.business.requests.DeleteBookRequest;
import com.gm.book.business.requests.UpdateBookRequest;
import com.gm.book.business.responses.GetAllBookResponse;
import com.gm.book.business.responses.GetByIdResponse;
import com.gm.book.entities.concretes.Book;

public interface BookService {
	List<GetAllBookResponse> getAll();
	GetByIdResponse getByIdResponse(int id);
	void add(CreateBookRequest createBookRequest) throws Exception;
	void update (UpdateBookRequest bookRequest);
	void delete(DeleteBookRequest deleteBookRequest);

}
