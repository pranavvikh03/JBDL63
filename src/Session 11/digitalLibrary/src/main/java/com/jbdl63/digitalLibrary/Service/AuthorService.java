package com.jbdl63.digitalLibrary.Service;

import com.jbdl63.digitalLibrary.Exceptions.BadRequestException;
import com.jbdl63.digitalLibrary.Exceptions.DataNotFoundException;
import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Repository.AuthorRepository;
import com.jbdl63.digitalLibrary.dto.UpdateAuthorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author addNewAuthor(Author author) throws Exception{
        return authorRepository.save(author);
    }

    public Author fetchAuthorDetailsByName(String authorName) {
        return authorRepository.findByAuthorName(authorName);
    }

    public List<Author> fetchAllAvailableAuthors() {
        return authorRepository.findAll();
    }

    public Author updateAuthorAddress(UpdateAuthorDto updateAuthorDto) {
        try {
            Author author = authorRepository.findById(updateAuthorDto.getAuthorId()).orElseThrow(
                    () -> new DataNotFoundException("Author not exist")
            );
            author.setAuthorAddress(updateAuthorDto.getAddress());
            return authorRepository.save(author);
        }
        catch(RuntimeException e) {
            log.error("Error is occurred while working with update operations with exception : {}", e.getMessage());
            throw new BadRequestException("Update Operation is Failed due to Exception :" + e.getMessage());
        }
    }

    //For New Entry - Persist
    //For Update Entry - Merge

    public void deleteById(Integer authorId) {
        authorRepository.deleteById(authorId);
    }

    public void uploadAuthorsDataToDatabase(String fileContent) {
        List<String> authorsData = List.of(fileContent.split("\n"));
        List<Author> authors = new ArrayList<>();
        for(int i = 1; i < authorsData.size(); i++) {
            String[] row = authorsData.get(i).split(",");
            authors.add(Author.builder()
                            .authorId(Integer.valueOf(row[0]))
                            .authorName(row[1])
                            .authorAddress(row[2])
                    .build());
        }
        authorRepository.saveAll(authors);
    }
}
