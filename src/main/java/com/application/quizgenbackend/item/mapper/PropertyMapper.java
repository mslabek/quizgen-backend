package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.PropertyDto;
import com.application.quizgenbackend.item.model.Property;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyMapper {

    private final PropertySimpleMapper mapper;

    public PropertyDto propertyToDto(Property property) {
        return mapper.propertyToDto(property);
    }

}
