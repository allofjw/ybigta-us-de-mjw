package com.example.demo.domain;

import com.example.demo.dto.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;



@Data
@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String email;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User() {
    }
    @Builder
    public User(Integer id, String email, Role role) {
        this.id = id;
        this.email = email;

        this.role = role;
    }

}
