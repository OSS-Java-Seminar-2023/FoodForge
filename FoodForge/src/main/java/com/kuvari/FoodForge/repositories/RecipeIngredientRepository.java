package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredient, UUID> {
}
