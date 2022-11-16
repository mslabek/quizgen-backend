package com.application.quizgenbackend.quiz.model;

import com.application.quizgenbackend.item.dto.PropertyTypeDetailedDto;
import com.application.quizgenbackend.item.dto.TopicDetailedDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizConfig {

    private TopicDetailedDto topic;
    private PropertyTypeDetailedDto knownPropertyType;
    private PropertyTypeDetailedDto unknownPropertyType;
    private Integer questionCount;
    private Integer answerCount;

}
