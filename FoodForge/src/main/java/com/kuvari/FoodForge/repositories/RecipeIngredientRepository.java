package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.RecipeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeIngredientRepository extends JpaRepository<RecipeIngredientEntity, UUID> {
}
