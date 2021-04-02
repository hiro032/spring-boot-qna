package com.codessquad.qna.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;

    protected User() {
    }

    public User(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public boolean isMatchingPassword(String checkPassword) {
        return this.password.equals(checkPassword);
    }

    public User update(User newUser) {
        this.password = newUser.password;
        this.name = newUser.name;
        this.email = newUser.email;

        return this;
    }

    public boolean isMatchingId(Long checkId) {
        return this.id.equals(checkId);
    }
}
