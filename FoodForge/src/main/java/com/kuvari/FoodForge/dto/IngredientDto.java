package com.kuvari.FoodForge.dto;

import lombok.Data;


import java.util.UUID;

@Data
public class IngredientDto {

    private UUID id;
    private String ingredientName;
    private String unit;
}

