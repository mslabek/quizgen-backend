package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PropertyTypeBaseDto {

    private Long id;
    private String mediaType;
    private String priority;
    private String uniqueness;

}
