package com.application.quizgenbackend.quiz.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuizConfigDto {

    private String topicName;
    private String knownPropertyType;
    private String knownPropertyTypeFormat;
    private String unknownPropertyType;
    private String unknownPropertyTypeFormat;
    private Integer questionCount;
    private Integer answerCount;

}
