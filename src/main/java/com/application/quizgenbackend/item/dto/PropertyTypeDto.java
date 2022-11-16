package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object of a {@link com.application.quizgenbackend.item.model.PropertyType}.
 * <p>
 * The {@code mediaType} field informs the client about how the related properties should be displayed. The
 * {@code distinctPropertyCount} also influences the view, because it may need to be changed for example if there are
 * only 3 distinct properties of this type, when the client would normally expect a higher amount.
 */
@Getter
@Setter
public class PropertyTypeDto extends PropertyTypeBaseDto {

    private Long id;
    private String name;
    private String mediaType;
    private String priority;
    private String uniqueness;

}
