package com.jbdl63.digitalLibrary.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Author Name should not be blank")
    private String authorName;

    private String authorAddress;

    //Relation Attributes

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "author", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Book> booksList = new ArrayList<>();
}