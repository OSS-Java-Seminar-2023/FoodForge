package com.kuvari.FoodForge.mappers;

import com.kuvari.FoodForge.dto.IngredientDto;
import com.kuvari.FoodForge.models.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    @Mapping(target = "id", source = "id", ignore = true)
    IngredientEntity toEntity(IngredientDto ingredientDto);
    @Mapping(target = "id", source = "id", ignore = false)
    IngredientDto toDto(IngredientEntity ingredientEntity);
}
