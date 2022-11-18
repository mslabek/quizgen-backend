package com.application.quizgenbackend.item.controller;

import com.application.quizgenbackend.item.dto.TopicDto;
import com.application.quizgenbackend.item.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    /**
     * Retrieves all topics stored in the database. The returned dto contains details about property types that belong
     * to the topic.
     * <p>
     * This endpoint can be used to further navigate the api. It contains all information needed for
     * constructing api requests for generating quizzes.
     *
     * @return the list of dtos representing all Topic entities
     */
    @GetMapping("/topics")
    @Operation(summary = "Retrieves all topics")
    @ApiResponse(responseCode = "200", description = "Topics retrieved successfully")
    @ApiResponse(responseCode = "5xx", description = "Unexpected error", content = @Content)
    public List<TopicDto> getTopics() {
        return topicService.getTopics();
    }

}
