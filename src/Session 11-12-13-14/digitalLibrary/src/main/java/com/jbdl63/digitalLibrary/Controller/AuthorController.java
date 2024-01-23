package com.jbdl63.digitalLibrary.Controller;

import com.jbdl63.digitalLibrary.Exceptions.BadRequestException;
import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Service.AuthorService;
import com.jbdl63.digitalLibrary.dto.UpdateAuthorDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/authors", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addNewAuthor(@RequestBody @Valid Author author) {
        try {
            if (author != null) {
                return new ResponseEntity<>(authorService.addNewAuthor(author), HttpStatus.CREATED);
            }
        } catch(Exception e){
            throw new BadRequestException(e.getMessage());
        }
        return null;
    }

    @GetMapping("/{authorName}")
    @Cacheable(value="authors", key = "#authorName")
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
    @CachePut(value="authors", key = "#authorName")
    public Author updateAuthorAddress(@RequestBody @Valid UpdateAuthorDto updateAuthorDto) {
        return authorService.updateAuthorAddress(updateAuthorDto);
    }

    @DeleteMapping("/{authorId}")
    @CacheEvict(value = "authors", allEntries = true)
    public void deleteAuthorByName(@PathVariable("authorId") Integer authorId) {
        authorService.deleteById(authorId);
    }


    @PostMapping("/upload-csv")
    public void uploadAuthorsDataToDatabase(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        String fileContent = new String(multipartFile.getBytes());
        authorService.uploadAuthorsDataToDatabase(fileContent);
    }
}


//Redis is used for caching purpose and also for persistent data


