package com.example.book_store.Services;

import com.example.book_store.Entity.BooksEntity;
import com.example.book_store.Entity.CustomerEntity;
import com.example.book_store.Repository.CustomerRepo;
import com.example.book_store.Services.domain.BooksReq;
import com.example.book_store.Util.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional
public class CustomerServices {

    private final CustomerRepo customerRepo;

    public GenericResponse<CustomerEntity> login(String username, String password) {

        CustomerEntity customerEntity = customerRepo.findByUsername(username);

        if (customerEntity != null){
            if (password.equals(customerEntity.getPassword())){
                log.info("pass");
                return new GenericResponse<>(HttpStatus.OK, "Login successful", customerEntity);
            }else {
                log.info("failed");
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
    }
}
