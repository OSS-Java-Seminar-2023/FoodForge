package com.kuvari.FoodForge.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;
@Entity
@Table
@Data
public class MealPlan {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "plan_name")
    private String planName;

    @Column(name = "details", columnDefinition = "text")
    private String details;

    @Column(name = "plan_date")
    private java.sql.Date planDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
