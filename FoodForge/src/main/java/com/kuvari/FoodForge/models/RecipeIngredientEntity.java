package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "RecipeIngredient")
@Data
public class RecipeIngredientEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
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
