package com.application.quizgenbackend.item.repository;

import com.application.quizgenbackend.item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Returns all items belonging to the topic.
     *
     * @param topic the topic related to the searched items
     * @return list of items
     */
    List<Item> findAllByTopicId(Long topicId);

    /**
     * Returns the number of items in the data store belonging to the topic.
     *
     * @param topic the topic related to the searched items
     * @return the number of matching items
     */
    @Query("SELECT COUNT(i) FROM Item i " +
            "WHERE i.topic.id = :topicId")
    int countByTopic(@Param("topicId") Long topicId);

}
