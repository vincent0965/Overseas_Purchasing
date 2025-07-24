package com.example.Overseas_Purchasing.repository;

import com.example.Overseas_Purchasing.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}

