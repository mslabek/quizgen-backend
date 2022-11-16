package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.PropertyTypeDetailedDto;
import com.application.quizgenbackend.item.dto.PropertyTypeDto;
import com.application.quizgenbackend.item.model.PropertyType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = ExpressionSimpleMapper.class)
abstract class PropertyTypeSimpleMapper {

    @Mapping(target = "name", source = "name.nominative")
    protected abstract PropertyTypeDto propertyTypeToDto(PropertyType propertyType);

    protected abstract PropertyTypeDetailedDto propertyTypeToDetailedDto(PropertyType propertyType);


}
