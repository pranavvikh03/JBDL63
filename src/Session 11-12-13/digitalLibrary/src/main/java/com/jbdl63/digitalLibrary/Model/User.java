package com.jbdl63.digitalLibrary.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String userMobileNo;

    private String userEmailId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Books_Issued",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    List<Book> issuedBooks = new ArrayList<>();
}
