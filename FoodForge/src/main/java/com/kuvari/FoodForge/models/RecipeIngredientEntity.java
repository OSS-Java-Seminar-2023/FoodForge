package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@Table
@Data
public class RecipeIngredientEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipeEntity;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredientEntity;
}
