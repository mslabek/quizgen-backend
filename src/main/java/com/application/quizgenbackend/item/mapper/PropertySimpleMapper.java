package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.PropertyDto;
import com.application.quizgenbackend.item.model.Property;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = PropertyTypeSimpleMapper.class)
abstract class PropertySimpleMapper {

    protected abstract PropertyDto propertyToDto(Property source);

}
