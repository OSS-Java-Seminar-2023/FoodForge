package com.kuvari.FoodForge.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@Table
@Data
public class MealPlanEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @Column
    private String planName;

    @Column
    private String details;

    @Column
    private java.sql.Date planDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn
    private ShoppingListEntity shoppingListEntity;

}
