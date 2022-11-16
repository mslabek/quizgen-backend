package com.application.quizgenbackend.item.repository;

import com.application.quizgenbackend.item.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

    /**
     * Retrieves property belonging to the item and having the property type from the data store.
     *
     * @param item         the item possessing the searched property
     * @param propertyType the property type of the searched property
     * @return the matching property
     */
    @Query("SELECT p FROM Property p " +
            "WHERE p.item.id = :itemId " +
            "AND p.propertyType.id = :propertyTypeId")
    Optional<Property> findByPropertyTypeAndItem(@Param("propertyTypeId") Long propertyTypeId,
                                                 @Param("itemId") Long itemId);

    @Query("SELECT p2 FROM Property p " +
            "JOIN p.item i " +
            "JOIN i.properties p2 " +
            "WHERE p2.propertyType.id = :propertyTypeId " +
            "AND p.id = :otherPropertyId")
    Optional<Property> findByPropertyTypeAndOtherProperty(@Param("propertyTypeId") Long propertyTypeId,
                                                          @Param("otherPropertyId") Long otherPropertyId);

    /**
     * Retrieves all properties belonging to the topic and having the property type.
     *
     * @param topic        the topic possessing the searched properties
     * @param propertyType the property type of the searched properties
     * @return list of matching properties
     */
    @Query("SELECT p FROM Topic t " +
            "JOIN t.items r " +
            "JOIN r.properties p " +
            "WHERE t.id = :topicId " +
            "AND p.propertyType.id = :propertyTypeId")
    List<Property> findAllByPropertyTypeAndTopic(@Param("propertyTypeId") Long propertyTypeId,
                                                 @Param("topicId") Long topicId);

    /**
     * Returns the number of distinct properties in the data store having the property type.
     * <p>
     * The uniqueness of properties in this case refers to the uniqueness of its content. There may be many properties
     * referring to items from the same topic and having the same content, but with different IDs. That's why the method
     * counts the distinct contents, not distinct objects.
     *
     * @param propertyType the property type of the searched property
     * @return the number of matching properties
     */
    @Query("SELECT COUNT(DISTINCT p.content) FROM Property p " +
            "WHERE p.propertyType.id = :propertyTypeId")
    int countDistinctByPropertyType(@Param("propertyTypeId") Long propertyTypeId);

}
