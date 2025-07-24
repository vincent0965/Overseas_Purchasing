package com.example.Overseas_Purchasing.dto;

import lombok.Data;

@Data
public class CartItemRequestDTO {
    private Long productId;
    private int quantity;
}
