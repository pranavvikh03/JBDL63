package com.JPAImpl1.JPAImpl1.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Books",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "bookName_Unique",
                    columnNames = "bookName"
            )
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId_generator")
    @SequenceGenerator(name = "bookId_generator", sequenceName = "bookId_sequence_table", allocationSize = 1, initialValue = 1)
    private Integer bookId;

    private String bookName;

    @Column(unique = true)
    private String author;

    @Column(name = "year", unique = true)
    private String publicationYear;

    @CreationTimestamp
    private LocalDateTime insertionTime;

    @UpdateTimestamp
    private LocalDateTime updationTime;
}
