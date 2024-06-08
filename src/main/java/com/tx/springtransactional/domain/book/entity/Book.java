package com.tx.springtransactional.domain.book.entity;

import com.tx.springtransactional.domain.bookstore.entity.BookStore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String isbn;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private BookStore bookStore;
}
