package com.gm.book.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.book.entities.concretes.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	boolean existsByName(String name);
	

}
