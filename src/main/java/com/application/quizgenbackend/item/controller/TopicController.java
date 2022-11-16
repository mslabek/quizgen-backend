package com.application.quizgenbackend.item.controller;

import com.application.quizgenbackend.item.dto.TopicDto;
import com.application.quizgenbackend.item.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    /**
     * Returns all topics stored in the database in the enriched dto form. TopicDto contains information about all
     * property types that belong to the topic, their media type and the amount of distinct properties they refer to.
     * <p>
     * This controller method can be used to further navigate the api. It contains all information needed for
     * constructing api requests for generating quizzes.
     *
     * @return list of TopicDtos
     */
    @GetMapping("/topics")
    public List<TopicDto> getTopics() {
        return topicService.getTopics();
    }

}
