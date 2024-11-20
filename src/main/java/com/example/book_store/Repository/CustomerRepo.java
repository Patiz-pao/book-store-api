package com.example.book_store.Repository;

import com.example.book_store.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, String> {

    CustomerEntity findByUsername(String username);
}
