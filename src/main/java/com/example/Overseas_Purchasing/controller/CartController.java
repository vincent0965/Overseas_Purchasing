package com.example.Overseas_Purchasing.controller;

import com.example.Overseas_Purchasing.dto.CartRequestDTO;
import com.example.Overseas_Purchasing.model.Cart;
import com.example.Overseas_Purchasing.model.User;
import com.example.Overseas_Purchasing.service.CartService;
import com.example.Overseas_Purchasing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @PostMapping("/add")
    public Cart addCart(@RequestBody CartRequestDTO cartRequestDTO, Authentication authentication) {
        String username = authentication.getName(); // 從 token 取得 username
        return cartService.addCart(cartRequestDTO, username);
    }

    @GetMapping("/my")
    public List<Cart> getMyCart(Authentication authentication) {
        String username = authentication.getName();
        return cartService.getCartByUsername(username);
    }
}
