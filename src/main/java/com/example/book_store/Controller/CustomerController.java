package com.example.book_store.Controller;

import com.example.book_store.Services.CustomerServices;
import com.example.book_store.Services.domain.LoginRes;
import com.example.book_store.Util.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class CustomerController {

    private CustomerServices customerServices;

    @PostMapping("/login")
    public GenericResponse<LoginRes> login(@RequestParam String username, @RequestParam String password){
        GenericResponse<LoginRes> response = customerServices.login(username, password);
        log.info("login success");
        return response;
    }
}
