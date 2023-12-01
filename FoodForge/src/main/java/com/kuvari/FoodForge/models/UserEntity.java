package com.kuvari.FoodForge.models;

import com.kuvari.FoodForge.models.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name="User")
@Data
public class UserEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String passwd;

    @OneToMany(mappedBy = "userEntity")
    private List<RecipeEntity> recipeEntities;

    @OneToMany(mappedBy = "userEntity")
    private List<ReviewEntity> reviewEntities;

    @OneToMany(mappedBy = "userEntity")
    private List<MealPlanEntity> mealPlanEntities;

}
