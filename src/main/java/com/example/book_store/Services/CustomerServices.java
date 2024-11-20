package com.example.book_store.Services;

import com.example.book_store.Entity.CustomerEntity;
import com.example.book_store.Repository.CustomerRepo;
import com.example.book_store.Services.domain.LoginRes;
import com.example.book_store.Services.domain.RegisterReq;
import com.example.book_store.Util.GenericResponse;
import com.example.book_store.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final JwtUtil jwtUtil;

    public GenericResponse<LoginRes> login(String username, String password) {

        CustomerEntity customerEntity = customerRepo.findByUsername(username);

        if (customerEntity != null){
            if (password.equals(customerEntity.getPassword())){
                log.info("pass");
                String token = jwtUtil.generateToken(username, customerEntity.getRole());
                LoginRes loginRes = new LoginRes(customerEntity.getCustomerId(), customerEntity.getUsername(), customerEntity.getRole(), token);
                return new GenericResponse<>(HttpStatus.OK, "Login successful", loginRes);
            }else {
                log.info("failed");
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
            }
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
        }
    }

    public GenericResponse<CustomerEntity> register(RegisterReq req) {

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(UUID.randomUUID().toString());
        customerEntity.setUsername(req.getUsername());
        customerEntity.setPassword(req.getPassword());
        customerEntity.setRole("customer");

        customerRepo.save(customerEntity);

        return new GenericResponse<>(HttpStatus.CREATED, "Register success", customerEntity);
    }
}
