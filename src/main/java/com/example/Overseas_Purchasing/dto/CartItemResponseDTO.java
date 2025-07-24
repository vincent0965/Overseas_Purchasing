package com.example.Overseas_Purchasing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemResponseDTO {
    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
}

