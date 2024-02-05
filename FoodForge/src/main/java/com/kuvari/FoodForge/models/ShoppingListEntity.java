package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "ShoppingList")
@Data
public class ShoppingListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private UUID id;

    @Column
    private String shoppingListName;

}
