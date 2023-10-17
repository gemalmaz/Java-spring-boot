package com.gm.book.business.rules;

import org.springframework.stereotype.Service;

import com.gm.book.core.utilities.exception.BusinessException;
import com.gm.book.dataAccess.abstracts.BookRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookBusinessRules {
	private BookRepository bookRepository;
	
	public void checkIfBookNameExists(String name) {
		if(this.bookRepository.existsByName(name)) {
			throw new BusinessException("already exist name");
		}
			
	}

}
