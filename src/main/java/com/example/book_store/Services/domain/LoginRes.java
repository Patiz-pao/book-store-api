package com.example.book_store.Services.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRes {
    private String customerId;
    private String username;
    private String role;
    private String token;
}
