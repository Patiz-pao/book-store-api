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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public GenericResponse<BooksEntity> updateProduct(BooksReq req, String bookId) {
        BooksEntity booksEntity = booksRepo.findByBookId(bookId);

        if (booksEntity == null) {
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Book not found", null);
        }
        booksEntity.setBookId(bookId);
        booksEntity.setTitle(req.getTitle());
        booksEntity.setDescription(req.getDescription());
        booksEntity.setPrice(req.getPrice());
        booksEntity.setStock(req.getStock());
        booksEntity.setCategory(req.getCategory());
        booksEntity.setTypes(req.getTypes());
        booksEntity.setImageUrl(req.getImageUrl());
        booksEntity.setHeight_thickness(req.getHeight_thickness());
        booksEntity.setPages(req.getPages());
        booksEntity.setLanguage(req.getLanguage());
        booksEntity.setSize(req.getSize());
        booksEntity.setDate(req.getDate());

        booksRepo.save(booksEntity);

        return new GenericResponse<>(HttpStatus.OK, "Book updated successfully", booksEntity);
    }

    public GenericResponse<List<BooksEntity>> getBooks() {
        List<BooksEntity> books = booksRepo.findAll();

        return new GenericResponse<>(HttpStatus.OK, "Get Books successfully", books);
    }

    public GenericResponse<BooksEntity> getBooksById(String bookId) {
        BooksEntity booksEntity = booksRepo.findByBookId(bookId);

        if (booksEntity == null) {
            return new GenericResponse<>(HttpStatus.NOT_FOUND, "Book not found", null);
        }
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
