package com.JPAImpl1.JPAImpl1.Repository;

import com.JPAImpl1.JPAImpl1.Model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;

    @Test
    public void insertData(){
        Book book = Book.builder()
                .bookName("Chavaa")
                .author("Sawanta")
                .publicationYear("2020a")
                .build();
        booksRepository.save(book);
    }

    @Test
    public void multipleAdd(){
        List<Book> books = List.of(
                Book.builder().bookName("Chava1").author("Sawant1").publicationYear("2021").build(),
                Book.builder().bookName("Chava2").author("Sawant2").publicationYear("2022").build(),
                Book.builder().bookName("Chava3").author("Sawant3").publicationYear("2023").build(),
                Book.builder().bookName("Chava4").author("Sawant4").publicationYear("2024").build()
        );
        booksRepository.saveAll(books);
    }

    @Test
    public void updateData(){
        Book existingBook = booksRepository.findById(102).get();
        existingBook.setAuthor("Pranav");
        existingBook.setPublicationYear("2025");
        booksRepository.save(existingBook);
    }

    @Test
    public void deleteData(){
        booksRepository.deleteById(103);
    }

    @Test
    public void fetchData(){
        Book book = booksRepository.findById(104).get();
        System.out.println(book);
        System.out.println("---------------------------------------------------------");

        List<Book> books = booksRepository.findAll();
        books.forEach( bookObj -> System.out.println(bookObj.toString()));
    }

    @Test
    public void fetchByName(){
        Book book = booksRepository.findByBookName("Chava");
        System.out.println(book);
    }
}