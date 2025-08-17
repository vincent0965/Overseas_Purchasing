package com.example.Overseas_Purchasing.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "useraccount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // 名字
    private String firstname;

    @Column(nullable = false) // 姓氏
    private String lastname;

    @Column(nullable = false, unique = true) // 帳號
    private String account;

    @Column(nullable = false)
    private String password;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String city;

    @Column
    private String role; // 帳號權限
}
