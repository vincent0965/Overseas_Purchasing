package com.example.Overseas_Purchasing.service;

import com.example.Overseas_Purchasing.dto.CartRequestDTO;
import com.example.Overseas_Purchasing.model.Cart;
import com.example.Overseas_Purchasing.model.User;
import com.example.Overseas_Purchasing.repository.CartRepository;
import com.example.Overseas_Purchasing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    public Cart addCart(CartRequestDTO dto, String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setCreatedAt(dto.getCreatedAt());
        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUsername(String username) {
        return cartRepository.findByUser_Username(username);
    }
}
