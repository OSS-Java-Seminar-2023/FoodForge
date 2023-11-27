package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table
@Data
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private UUID id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column(name = "unit")
    private String unit;

}
