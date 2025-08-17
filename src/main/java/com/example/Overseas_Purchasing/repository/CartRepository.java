package com.example.Overseas_Purchasing.repository;

import com.example.Overseas_Purchasing.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUser_Account(String account);

    Optional<Object> findByUserId(Long userId);
}
