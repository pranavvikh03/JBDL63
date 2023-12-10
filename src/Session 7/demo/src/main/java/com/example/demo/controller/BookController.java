package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books/{id}")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<String> getAllBooks(@RequestBody Book input){
        if(bookService.addNewBook(input))
            return new ResponseEntity<>("Book Added Successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Problem while adding book", HttpStatus.BAD_REQUEST);
    }
}
