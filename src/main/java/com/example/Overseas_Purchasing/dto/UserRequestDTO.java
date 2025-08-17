package com.example.Overseas_Purchasing.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    private String account;
    private String password;
    private String phone;
    private String email;
    private String city;
}