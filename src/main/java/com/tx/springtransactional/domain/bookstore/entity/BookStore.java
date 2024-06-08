package com.tx.springtransactional.domain.bookstore.entity;

import com.tx.springtransactional.domain.book.entity.Book;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class BookStore {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "bookStore")
    private Set<Book> books = new HashSet<>();

    public void add(Book book){
        this.books.add(book);
    }
}
