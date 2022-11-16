package com.application.quizgenbackend.quiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResult {

    /**
     * Amount of points changed by the last answer.
     */
    private Boolean givenAnswerCorrect;
    private String correctAnswer;
    private Integer pointsChange;

}
