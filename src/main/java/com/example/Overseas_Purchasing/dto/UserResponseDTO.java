package com.example.Overseas_Purchasing.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String account;
    private String role;
    private String token; //認證token
}
