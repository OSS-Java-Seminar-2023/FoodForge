package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "Recipe")
@Data
public class RecipeEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @Column
    private String title;

    @Column
    private String details;

    @Column
    private String difficulty;

    @Column(name="prep_time")
    private Short prepTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "recipeEntity", cascade = CascadeType.ALL)
    private List<RecipeIngredientEntity> recipeIngredients;

    @OneToMany(mappedBy = "recipeEntity")
    List<ReviewEntity> reviews;
}
