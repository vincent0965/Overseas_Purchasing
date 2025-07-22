package com.example.Overseas_Purchasing.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "username")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role; // USER, ADMIN
}
