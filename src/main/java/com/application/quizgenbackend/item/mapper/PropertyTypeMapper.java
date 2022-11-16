package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.PropertyTypeDetailedDto;
import com.application.quizgenbackend.item.dto.PropertyTypeDto;
import com.application.quizgenbackend.item.model.PropertyType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyTypeMapper {

    private final PropertyTypeSimpleMapper propertyTypeSimpleMapper;

    public PropertyTypeDto propertyTypeToDto(PropertyType source) {
        return propertyTypeSimpleMapper.propertyTypeToDto(source);
    }

    public PropertyTypeDetailedDto propertyTypeDetailedDto(PropertyType source) {
        return propertyTypeSimpleMapper.propertyTypeToDetailedDto(source);
    }

}
