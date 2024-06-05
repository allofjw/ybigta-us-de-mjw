package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity

@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {
    }
    @Builder
    public User(Integer id, String email, String password, UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // getters and setters for id, name, email, role

    public String gotUserRoleKey() {
        return this.role.getKey();
    }
}
