package com.example.Overseas_Purchasing.controller;

import com.example.Overseas_Purchasing.dto.UserRequestDTO;
import com.example.Overseas_Purchasing.dto.UserResponseDTO;
import com.example.Overseas_Purchasing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // new user
    @PostMapping("/register")
    public UserResponseDTO register(@RequestBody UserRequestDTO request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserResponseDTO login(@RequestBody UserRequestDTO request) {
        return userService.login(request); //return token
    }
}
