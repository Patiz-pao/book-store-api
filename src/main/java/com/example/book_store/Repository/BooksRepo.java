package com.example.book_store.Repository;

import com.example.book_store.Entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<BooksEntity, String> {
}
