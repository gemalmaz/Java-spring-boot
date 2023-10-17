package com.gm.book;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gm.book.core.utilities.exception.BusinessException;
import com.gm.book.core.utilities.exception.ProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
		@ExceptionHandler
		@ResponseStatus(code = HttpStatus.BAD_REQUEST)
		public ProblemDetails handleBusinessException(BusinessException businessException) {
			ProblemDetails problemDetails= new  ProblemDetails();
			problemDetails.setMessage(businessException.getMessage());
			return problemDetails;
		}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}

}
