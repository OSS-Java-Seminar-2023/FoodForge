package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table
@Data
public class ShoppingListIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shoppinglist_id")
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit", length = 10)
    private String unit;
}
