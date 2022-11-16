package com.application.quizgenbackend.quiz.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResultDto {

    /**
     * Amount of points changed by the last answer.
     */
    private Boolean givenAnswerCorrect;
    private String correctAnswer;
    private Integer pointsChange;

}
