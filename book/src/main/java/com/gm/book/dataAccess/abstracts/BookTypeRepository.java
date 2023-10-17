package com.gm.book.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.book.entities.concretes.BookType;

public interface BookTypeRepository extends JpaRepository<BookType, Integer>{

}
