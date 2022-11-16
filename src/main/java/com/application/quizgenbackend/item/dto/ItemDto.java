package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemDto {

    private Long id;
    private List<PropertyDto> properties;

}
