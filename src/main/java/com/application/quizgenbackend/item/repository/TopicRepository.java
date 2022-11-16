package com.application.quizgenbackend.item.repository;

import com.application.quizgenbackend.item.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT t FROM Topic t " +
            "JOIN FETCH t.name n")
    List<Topic> findAll();

    /**
     * Retrieves the topic with the name from the data store
     *
     * @param name the name of the searched topic
     * @return the matching topic wrapped in an {@link Optional}
     */
    @Query("SELECT t FROM Topic t " +
            "JOIN FETCH t.name e " +
            "WHERE e.nominative = :name")
    Optional<Topic> findByName(String name);

    @Query("SELECT t FROM Topic t " +
            "JOIN FETCH t.name n " +
            "JOIN t.items i " +
            "JOIN i.properties p " +
            "WHERE p.propertyType.id = :propertyTypeId")
    List<Topic> findAllByPropertyTypeId(Long propertyTypeId);

}
