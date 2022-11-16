package com.application.quizgenbackend.item.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Value object representing the type of given {@link Property}.
 */
@Entity(name = "property_type")
@Getter
@Setter
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "name_id")
    private Expression name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyType")
    private List<Property> properties;

    @Column(name = "question_ending_template")
    private String questionEndingTemplate;

    @Column(name = "media_type")
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Enumerated(EnumType.STRING)
    private Uniqueness uniqueness;

    @Enumerated(EnumType.STRING)
    private Priority priority;

}
