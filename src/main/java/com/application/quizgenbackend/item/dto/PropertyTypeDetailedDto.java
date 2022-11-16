package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyTypeDetailedDto extends PropertyTypeBaseDto {

    private Long id;
    private ExpressionDto name;
    private String mediaType;
    private String priority;
    private String uniqueness;
    private String questionEndingTemplate;

}
