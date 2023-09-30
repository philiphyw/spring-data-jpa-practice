package com.outlook.philiphyw.springdatajpapractice.book.repository;

import com.outlook.philiphyw.springdatajpapractice.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {
}
