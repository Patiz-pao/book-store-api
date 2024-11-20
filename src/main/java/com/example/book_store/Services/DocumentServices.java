package com.example.book_store.Services;

import com.example.book_store.Entity.BooksEntity;
import com.example.book_store.Repository.BooksRepo;
import com.example.book_store.Services.domain.BooksReq;
import com.example.book_store.Util.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class DocumentServices {

    private final BooksRepo booksRepo;

    public GenericResponse<BooksEntity> saveBooks(BooksReq req) {

        BooksEntity booksEntity = new BooksEntity();

        BeanUtils.copyProperties(req, booksEntity);
        booksEntity.setBookId(UUID.randomUUID().toString());

        booksRepo.save(booksEntity);

        return new GenericResponse<>(HttpStatus.CREATED, "Books Created success", booksEntity);
    }

    public GenericResponse<List<BooksEntity>> getBooks() {
        List<BooksEntity> books = booksRepo.findAll();

        return new GenericResponse<>(HttpStatus.OK, "Get Books successfully", books);
    }

    public GenericResponse<BooksEntity> getBooksById(String bookId) {
        // Fetch book entity by ID
        BooksEntity booksEntity = booksRepo.findByBookId(bookId);

        if (booksEntity == null) {
            // Handle case when book is not found
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Book not found", null);
        }

        // Return the response if book is found
        return new GenericResponse<>(HttpStatus.OK, "Get Books successfully", booksEntity);
    }


    public GenericResponse<List<BooksEntity>> getBooksByCriteria(String title, String description, Double price, String category, String types) {
        if ((title == null || title.isEmpty()) &&
                (description == null || description.isEmpty()) &&
                (price == null || price.isNaN()) &&
                (category == null || category.isEmpty()) &&
                (types == null || types.isEmpty())) {

            List<BooksEntity> books = booksRepo.findAll();

            return new GenericResponse<>(HttpStatus.OK, "Get Books All successfully", books);
        }
        List<BooksEntity> books = booksRepo.getBooksByCriteria(title, description, price, category, types);

        return new GenericResponse<>(HttpStatus.OK, "Get Books successfully", books);
    }

}
