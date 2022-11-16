package com.application.quizgenbackend.item.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Data Transfer Object of a {@link com.application.quizgenbackend.item.model.Topic}.
 * <p>
 * The information stored in this dto should enable the client to navigate the api related to the items in this topic .
 * For example the client can generate quizzes based on the topic name and the names of its property types. Through the
 * {@code itemCount} field the client is also informed about the maximum number of questions the quiz can consist of.
 */
@Getter
@Setter
public class TopicDto extends TopicBaseDto {

    private Long id;
    private String name;
    private List<PropertyTypeDto> propertyTypes;
    private int itemCount;

}
