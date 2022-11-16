package com.application.quizgenbackend.item.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representing thematic grouping of {@link Item}s.
 * <p>
 * Topic serves as an aggregate of items. Items belonging to the same topic are mostly guaranteed to have the same
 * property types. For example: items belonging to the topic "Countries" will have properties of the same type - that is
 * "Capital" and "Head of state". This allows for dynamic generation of quizzes based on items from the same topic.
 */
@Entity
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "name_id")
    private Expression name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Item> items;

}
