package com.example.SoloTune.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username, password,email;
    private boolean enable;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password, String email, boolean enable, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enable = enable;
        this.roles = roles;
    }
}
