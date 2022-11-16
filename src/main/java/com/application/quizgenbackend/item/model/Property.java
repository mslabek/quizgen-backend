package com.application.quizgenbackend.item.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Value object representing a quality of an {@link Item}.
 * <p>
 * The value of a property is defined by its {@code content} field. The format of this value is represented by the //
 * TODO of the {@link PropertyType} of a given property. For example: property of type "Capital" has the media type of
 * String, so the content of the property should be interpreted as such. It would be different for a property with type
 * "Capital location" which value could be stored as url reference to an .png or .svg file - in that case the media type
 * would indicate that.
 * <p>
 * In terms of the domain, properties are not unique - they are value objects, however, as of now they are modeled as
 * entities. This may not be optimal, however at this stage of development it's easier to insert the data this way. This
 * may change in the future.
 */
@Entity
@Getter
@Setter
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;

}
