package com.kuvari.FoodForge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private UUID id;

    @Column(name = "role")
    private String role;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "passwd")
    private String password;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

}
