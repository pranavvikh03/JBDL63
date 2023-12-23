package com.JPAImpl1.JPAImpl1.Repository;

import com.JPAImpl1.JPAImpl1.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

     List<Book> findByBookName(String bookName);

     List<Book> findByPublicationYearGreaterThanEqual(String year);

     List<Book> findByPublicationYearAfter(String year);

     List<Book> findByOrderByBookNameDesc();


     @Query(value = "select * from books where year >= :year", nativeQuery = true)
     List<Book> findPublicationYearGreaterThanUsingNativeQuery(@Param("year") String year);

     @Query("select b FROM Book b WHERE b.publicationYear >= ?1")
     List<Book> findPublicationYearGreaterThanUsingJPQL(String year);
}
