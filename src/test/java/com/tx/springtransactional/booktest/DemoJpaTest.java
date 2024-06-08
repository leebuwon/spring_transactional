package com.tx.springtransactional.booktest;

import com.tx.springtransactional.domain.book.entity.Book;
import com.tx.springtransactional.domain.book.repository.BookRepository;
import com.tx.springtransactional.domain.bookstore.entity.BookStore;
import com.tx.springtransactional.domain.bookstore.repository.BookStoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class DemoJpaTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookStoreRepository bookStoreRepository;

    @Test
    @Rollback(false)
    public void contextLoad(){
        BookStore bookStore = new BookStore();
        bookStore.setName("책 이름");
        bookStoreRepository.save(bookStore);

        Book book = new Book();
        book.setTitle("공부하자 공부");
        book.setBookStore(bookStore);
        bookStore.add(book);
        bookRepository.save(book);
    }
}
