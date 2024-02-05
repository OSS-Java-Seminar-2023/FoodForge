package com.kuvari.FoodForge.repositories;
import com.kuvari.FoodForge.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID>{

    UserEntity findByEmail(String email);
    UserEntity findByUsername(String Username);
}
