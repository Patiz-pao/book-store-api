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

}
