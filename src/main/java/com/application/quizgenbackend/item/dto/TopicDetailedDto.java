package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TopicDetailedDto extends TopicBaseDto {

    private Long id;
    private ExpressionDto name;
    private List<PropertyTypeDetailedDto> propertyTypes;
    private int itemCount;

}
