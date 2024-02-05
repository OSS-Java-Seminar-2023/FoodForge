package com.kuvari.FoodForge.dto;



import com.kuvari.FoodForge.models.enums.Difficulty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RecipeDto {

    private String title;
    private String details;
    private Difficulty difficulty;
    private Short prepTime;
    private List<RecipeIngredientDto> ingredients;
}

