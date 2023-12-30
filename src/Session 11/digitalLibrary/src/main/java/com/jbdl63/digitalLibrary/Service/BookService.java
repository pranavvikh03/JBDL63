package com.jbdl63.digitalLibrary.Service;

import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Model.Book;
import com.jbdl63.digitalLibrary.Repository.AuthorRepository;
import com.jbdl63.digitalLibrary.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book addNewBook(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getAuthorId()).get();
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public void deleteBookById(Integer bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<Book> findBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthorName(authorName);
    }
}
