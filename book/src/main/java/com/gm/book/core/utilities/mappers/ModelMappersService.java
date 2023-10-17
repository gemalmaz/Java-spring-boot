package com.gm.book.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMappersService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();

}
