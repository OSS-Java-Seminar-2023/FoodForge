package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "ShoppingListIngredient")
@Data
public class ShoppingListIngredientEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
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
