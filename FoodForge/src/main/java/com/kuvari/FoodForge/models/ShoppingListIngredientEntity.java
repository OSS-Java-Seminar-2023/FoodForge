package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "ShoppingListIngredient")
@Data
@AllArgsConstructor
public class ShoppingListIngredientEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private Integer quantity;

    @Column
    private String unit;

    @ManyToOne
    @JoinColumn(name = "shoppinglist_id")
    private ShoppingListEntity shoppingListEntity;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private IngredientEntity ingredientEntity;


}
