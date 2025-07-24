package com.example.Overseas_Purchasing.controller;

import com.example.Overseas_Purchasing.dto.CartItemRequestDTO;
import com.example.Overseas_Purchasing.dto.CartItemResponseDTO;
import com.example.Overseas_Purchasing.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart-items")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping("/{cartId}")
    public ResponseEntity<CartItemResponseDTO> addItem(@PathVariable Long cartId, @RequestBody CartItemRequestDTO request) {
        return ResponseEntity.ok(cartItemService.addItemToCart(cartId, request));
    }
}
