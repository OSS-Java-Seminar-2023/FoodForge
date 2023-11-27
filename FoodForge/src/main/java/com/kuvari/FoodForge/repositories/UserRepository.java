package com.kuvari.FoodForge.repositories;

import com.kuvari.FoodForge.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
