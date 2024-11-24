package com.example.book_store.Controller;

import com.example.book_store.Entity.BooksEntity;
import com.example.book_store.Services.DocumentServices;
import com.example.book_store.Services.domain.BooksReq;
import com.example.book_store.Util.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/books")
    public GenericResponse<BooksEntity> updateBooks(@RequestBody BooksReq req, @RequestParam String bookId){
        GenericResponse<BooksEntity> response = documentServices.updateProduct(req, bookId);
        log.info("update books success");

        return response;
    }

    @GetMapping("/books")
    public GenericResponse<List<BooksEntity>> getBooks(){
        GenericResponse<List<BooksEntity>> response = documentServices.getBooks();
        log.info("get books success");

        return response;
    }

    @GetMapping("/booksId")
    public GenericResponse<BooksEntity> getBooksById(@RequestParam String bookId){
        GenericResponse<BooksEntity> response = documentServices.getBooksById(bookId);
        log.info("get books id success");

        return response;
    }

    @GetMapping("/books/search")
    public GenericResponse<List<BooksEntity>> getBooksByCriteria(@RequestParam (required = false) String title,
                                                                 @RequestParam (required = false) String description,
                                                                 @RequestParam (required = false) Double price,
                                                                 @RequestParam (required = false) String category,
                                                                 @RequestParam (required = false) String types){
        GenericResponse<List<BooksEntity>> response = documentServices.getBooksByCriteria(title, description, price, category, types);
        log.info("get books by criteria success");

        return response;
    }
}
