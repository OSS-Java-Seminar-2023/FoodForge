package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {
}
