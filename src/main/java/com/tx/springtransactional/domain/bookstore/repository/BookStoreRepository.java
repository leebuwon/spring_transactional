package com.tx.springtransactional.domain.bookstore.repository;

import com.tx.springtransactional.domain.bookstore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
}
