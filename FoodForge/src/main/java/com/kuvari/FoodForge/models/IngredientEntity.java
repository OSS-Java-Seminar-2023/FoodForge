package com.kuvari.FoodForge.models;

import com.kuvari.FoodForge.models.enums.Unit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table(name = "Ingredient")
@Data
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private  UUID id;

    @Column(name = "ingredient_name")
    private String ingredientName;

    @Column
    @Enumerated(EnumType.STRING)
    private Unit unit;
}
