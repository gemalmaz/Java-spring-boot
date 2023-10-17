package com.gm.book.business.abstracts;

import java.util.List;

import com.gm.book.business.requests.CreateBookTypeRequest;
import com.gm.book.business.responses.GetAllBookTypeResponse;
import com.gm.book.business.responses.GetByIdBookTypeResponse;

public interface BookTypeService {
	List<GetAllBookTypeResponse> getAllBookTypeResponses();
	void add(CreateBookTypeRequest createBookTypeRequest);
	GetByIdBookTypeResponse byIdBookTypeResponse(int id);

}
