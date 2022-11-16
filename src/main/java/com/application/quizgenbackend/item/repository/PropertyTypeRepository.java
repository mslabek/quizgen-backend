package com.application.quizgenbackend.item.repository;

import com.application.quizgenbackend.item.model.PropertyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyTypeRepository extends JpaRepository<PropertyType, Long> {

    /**
     * Retrieves the property type with the name from the data store.
     *
     * @param name the property type's name
     * @return the matching property type
     */
    @Query("SELECT pt FROM property_type pt " +
            "JOIN FETCH pt.name e " +
            "WHERE e.nominative = :name")
    Optional<PropertyType> findByName(String name);

    /**
     * Retrieves all the property types associated with the topic from the data store.
     *
     * @param topic the topic associated with the searched property type
     * @return list of matching property types
     */
    @Query("SELECT DISTINCT pt FROM Topic t " +
            "JOIN t.items r " +
            "JOIN r.properties p " +
            "JOIN p.propertyType pt " +
            "JOIN FETCH pt.name n " +
            "WHERE t.id = :topicId")
    List<PropertyType> findAllByTopic(@Param("topicId") Long topicId);

}
