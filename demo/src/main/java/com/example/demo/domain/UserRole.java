package com.example.demo.domain;


import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),//관리자, User 권한 구분
    USER("ROLE_USER");

    UserRole(String value) {
        this.value=value;
    }

    private String value;
}
