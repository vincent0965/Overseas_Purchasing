package com.example.Overseas_Purchasing.service;

import com.example.Overseas_Purchasing.dto.UserRequestDTO;
import com.example.Overseas_Purchasing.dto.UserResponseDTO;
import com.example.Overseas_Purchasing.model.User;
import com.example.Overseas_Purchasing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.Overseas_Purchasing.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserResponseDTO register(UserRequestDTO request) {
        if (userRepository.findByAccount(request.getAccount()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .account(request.getAccount())
                .password(passwordEncoder.encode(request.getPassword()))
                .role("USER") //之後要調整
                .phone(request.getPhone())
                .email(request.getEmail())
                .city(request.getCity())
                .build();

        User savedUser = userRepository.save(user);
        return new UserResponseDTO(savedUser.getId(), savedUser.getAccount(), savedUser.getRole(), savedUser.getEmail(),null);
    }

    public UserResponseDTO login(UserRequestDTO request) {
        User user = userRepository.findByAccount(request.getAccount())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtTokenProvider.generateToken(user);
        return new UserResponseDTO(user.getId(), user.getAccount(), user.getRole(), user.getEmail(),token);
    }
}
