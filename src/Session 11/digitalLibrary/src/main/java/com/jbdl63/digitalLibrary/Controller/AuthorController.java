package com.jbdl63.digitalLibrary.Controller;

import com.jbdl63.digitalLibrary.Exceptions.BadRequestException;
import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Service.AuthorService;
import com.jbdl63.digitalLibrary.dto.UpdateAuthorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/authors", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addNewAuthor(@RequestBody @Valid Author author) {
        if(author != null) {
            Author author1 = authorService.addNewAuthor(author);
            if(author1 != null)
                return new ResponseEntity<>(author1, HttpStatus.CREATED);
        }
        return null;
    }

    @GetMapping("/{authorName}")
    public Author fetchAuthorByName(@PathVariable("authorName") String authorName) {
        if(!isBlank(authorName))
            return authorService.fetchAuthorDetailsByName(authorName);
        throw new BadRequestException("Please send Author Name");
    }

    @GetMapping("/usingParam")
    public Author fetchAuthorByNameUsingParam(@RequestParam("authorName") String authorName) {
        if(!isBlank(authorName))
            return authorService.fetchAuthorDetailsByName(authorName);
        throw new BadRequestException("Please send Author Name");
    }

    boolean isBlank(String string) {
        return string == null || string.isBlank();
    }

    @GetMapping
    public List<Author> fetchAllAvailableAuthors() {
        return authorService.fetchAllAvailableAuthors();
    }

    @PutMapping
    public Author updateAuthorAddress(@RequestBody @Valid UpdateAuthorDto updateAuthorDto) {
        return authorService.updateAuthorAddress(updateAuthorDto);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthorByName(@PathVariable("authorId") Integer authorId) {
        authorService.deleteById(authorId);
    }
}
