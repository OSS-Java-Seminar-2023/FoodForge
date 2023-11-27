package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.ShoppingListIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingListIngredientRepository extends JpaRepository<ShoppingListIngredient, UUID> {
}
