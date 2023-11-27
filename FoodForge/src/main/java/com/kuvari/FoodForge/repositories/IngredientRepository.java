package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {
}