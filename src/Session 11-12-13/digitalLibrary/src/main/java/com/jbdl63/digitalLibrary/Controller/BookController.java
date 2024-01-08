package com.jbdl63.digitalLibrary.Controller;

import com.jbdl63.digitalLibrary.Model.Book;
import com.jbdl63.digitalLibrary.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addNewBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.addNewBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public void deleteExistingBook(@PathVariable("bookId") Integer bookId) {
        bookService.deleteBookById(bookId);
    }

    @GetMapping("/{authorName}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable("authorName") String authorName) {
        return new ResponseEntity<>(bookService.findBooksByAuthorName(authorName), HttpStatus.OK);
    }
}
