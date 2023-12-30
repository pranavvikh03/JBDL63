package com.jbdl63.digitalLibrary.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "library_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(nullable = false, length = 200)
    private String bookName;

    @Column(nullable = false)
    private String publicationYear;

    @Column(nullable = false)
    private Double bookPrice;

    @Column(nullable = false, length = 10)
    private String bookEdition;

    @Column(nullable = false)
    private String bookCategory;

    //Relation Attributes

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @CreationTimestamp
    private LocalDateTime creationTime;

    @UpdateTimestamp
    private LocalDateTime updationTime;
}




