package com.example.book_store.Repository;

import com.example.book_store.Entity.BooksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Book;
import java.util.List;

public interface BooksRepo extends JpaRepository<BooksEntity, String> {

    @Query(value = """
    SELECT * FROM bookstore.books b
    WHERE (:title IS NULL OR b.title LIKE CONCAT('%', :title, '%'))
    AND (:description IS NULL OR b.description LIKE CONCAT('%', :description, '%'))
    AND (:price IS NULL OR b.price = CAST(:price AS DECIMAL))
    AND (:category IS NULL OR b.category LIKE CONCAT('%', :category, '%'))
    AND (:types IS NULL OR b.types LIKE CONCAT('%', :types, '%'))
    """, nativeQuery = true)
    List<BooksEntity> getBooksByCriteria(
            @Param("title") String title,
            @Param("description") String description,
            @Param("price") Double price,
            @Param("category") String category,
            @Param("types") String types
    );

    BooksEntity findByBookId(@Param("bookId") String bookId);

}
