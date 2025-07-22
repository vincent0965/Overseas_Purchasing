package com.example.Overseas_Purchasing.repository;

import com.example.Overseas_Purchasing.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
