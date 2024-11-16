package com.example.book_store.Controller;

import com.example.book_store.Entity.BooksEntity;
import com.example.book_store.Services.DocumentServices;
import com.example.book_store.Services.domain.BooksReq;
import com.example.book_store.Util.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class DocumentController {

    private DocumentServices documentServices;

    @PostMapping("/books")
    public GenericResponse<BooksEntity> saveBooks(@RequestBody BooksReq req){
        GenericResponse<BooksEntity> response = documentServices.saveBooks(req);
        log.info("save books success");

        return response;
    }

    @GetMapping("/books")
    public GenericResponse<List<BooksEntity>> getBooks(){
        GenericResponse<List<BooksEntity>> response = documentServices.getBooks();
        log.info("get books success");

        return response;
    }
}
