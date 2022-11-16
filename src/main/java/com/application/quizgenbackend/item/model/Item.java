package com.application.quizgenbackend.item.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representing an item.
 * <p>
 * Item is a thing or an idea which belongs to a certain {@link Topic}. For example: "Poland" is an item belonging to
 * the "Countries" topic.
 * <p>
 * Item can be identified by its unique name. Item also possesses {@link Property}s, however they don't have to be
 * unique. For example: chemical element "Hydrogen" has a {@link PropertyType} "State of matter" with the name "Gas".
 * The element "Helium" also has the same property of the same type.
 */
@Entity
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Property> properties;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

}
