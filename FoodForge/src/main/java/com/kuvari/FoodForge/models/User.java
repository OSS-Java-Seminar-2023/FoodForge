package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "passwd")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    private List<MealPlan> mealPlans;
}
