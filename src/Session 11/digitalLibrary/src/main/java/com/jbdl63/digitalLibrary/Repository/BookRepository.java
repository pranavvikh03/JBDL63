package com.jbdl63.digitalLibrary.Repository;

import com.jbdl63.digitalLibrary.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query("SELECT a FROM Book a WHERE a.author.authorName = ?1")
    List<Book> findByAuthorAuthorName(String authorName);

}
