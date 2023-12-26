package com.kuvari.FoodForge.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class IngredientDto {

    private UUID id;
    private String ingredientName;
    private String unit;
}

