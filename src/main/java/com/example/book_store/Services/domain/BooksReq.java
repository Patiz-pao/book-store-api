package com.example.book_store.Services.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class BooksReq {
    private String bookId;
    private String title;
    private String description;
    private BigDecimal price;
    private int stock;
    private String category;
    private String types;
    private String imageUrl;
    private String height_thickness;
    private String pages;
    private String language;
    private String size;
    private LocalDate date;
}
