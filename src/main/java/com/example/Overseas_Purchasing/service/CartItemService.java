package com.example.Overseas_Purchasing.service;

import com.example.Overseas_Purchasing.dto.CartItemRequestDTO;
import com.example.Overseas_Purchasing.dto.CartItemResponseDTO;
import com.example.Overseas_Purchasing.model.Cart;
import com.example.Overseas_Purchasing.model.CartItem;
import com.example.Overseas_Purchasing.model.Product;
import com.example.Overseas_Purchasing.repository.CartItemRepository;
import com.example.Overseas_Purchasing.repository.CartRepository;
import com.example.Overseas_Purchasing.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Transactional
    public CartItemResponseDTO addItemToCart(Long cartId, CartItemRequestDTO request) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem item = CartItem.builder()
                .cart(cart)
                .product(product)
                .quantity(request.getQuantity())
                .build();

        CartItem saved = cartItemRepository.save(item);

        return CartItemResponseDTO.builder()
                .id(saved.getId())
                .productId(product.getId())
                .productName(product.getName())
                .quantity(saved.getQuantity())
                .build();
    }
}
