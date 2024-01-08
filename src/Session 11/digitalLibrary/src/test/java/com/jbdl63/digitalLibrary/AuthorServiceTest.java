package com.jbdl63.digitalLibrary;

import com.jbdl63.digitalLibrary.Exceptions.BadRequestException;
import com.jbdl63.digitalLibrary.Model.Author;
import com.jbdl63.digitalLibrary.Repository.AuthorRepository;
import com.jbdl63.digitalLibrary.Service.AuthorService;
import com.jbdl63.digitalLibrary.dto.UpdateAuthorDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @InjectMocks
    private AuthorService authorService;

    @Mock
    private AuthorRepository authorRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNewAuthor() throws Exception {
        Author author = Author.builder().authorId(1111).authorName("pranav").authorAddress("nashik").build();
        when(authorRepository.save(any())).thenReturn(author);
        Author a = authorService.addNewAuthor(author);
        Assertions.assertThat(a).isEqualTo(author);
    }

    @Test
    public void testUploadAuthorsDataToDatabase() {
        String fileContent = "authorId, authorName, authorAddress\n" +
                "11, ABC, Kolkata\n" +
                "12, PQR, Jaipur\n" +
                "13, Rahul, Raipur\n" +
                "14, Divya, Nagpur";
        authorService.uploadAuthorsDataToDatabase(fileContent);
        verify(authorRepository, times(1)).saveAll(any());
    }

    @Test
    public void testUpdateAuthor_Exception() {
        when(authorRepository.findById(1)).thenReturn(null);
        Exception exception = assertThrows(BadRequestException.class, () -> authorService.updateAuthorAddress(UpdateAuthorDto.builder().address("abc").authorId(1).build()));
        assertTrue(exception.getMessage().contains("Update Operation is Failed due to Exception"));
    }

    @Test
    public void testUpdateAuthorAddress() {
        Author author = Author.builder().authorId(1111).authorName("pranav").authorAddress("nashik").build();
        when(authorRepository.findById(any())).thenReturn(Optional.ofNullable(author));
        when(authorRepository.save(any())).thenReturn(author);
        Author a = authorService.updateAuthorAddress(UpdateAuthorDto.builder().address("Mumbai").authorId(1111).build());
        Assertions.assertThat(a).isEqualTo(author);
    }

    // any() can be use with only mock objects and not to call actual functions
}
