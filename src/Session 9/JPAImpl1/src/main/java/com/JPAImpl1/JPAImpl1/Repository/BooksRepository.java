package com.JPAImpl1.JPAImpl1.Repository;

import com.JPAImpl1.JPAImpl1.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

     Book findByBookName(String bookName);
}
