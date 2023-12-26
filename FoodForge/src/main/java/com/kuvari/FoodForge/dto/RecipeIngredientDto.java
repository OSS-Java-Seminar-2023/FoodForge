package com.kuvari.FoodForge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class RecipeIngredientDto {

    private UUID ingredientId;
    private UUID recipeId;
    private Integer quantity;

}
