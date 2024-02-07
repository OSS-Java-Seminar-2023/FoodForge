package com.kuvari.FoodForge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.kuvari.FoodForge.dto.RecipeDto;
import com.kuvari.FoodForge.models.RecipeEntity;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    @Mapping(target = "userEntity", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    RecipeEntity toEntity(RecipeDto dto);

    @Mapping(target = "ingredients", source = "recipeIngredients")
    RecipeDto toDto(RecipeEntity entity);
}