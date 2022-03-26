package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase User
 */

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="User_")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long ID_user;

    @Column(name="name_")
    private String name;

    @Column(name="username_")
    private String username;

    @Column(name="password_")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection <Role> roles = new ArrayList<>();
}
