package com.application.quizgenbackend.quiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class QuizStateDto {

    private Integer currentQuestionIndex;
    private Integer questionsSolved;
    private Integer correctAnswersCount;
    private Integer points;
    private Boolean solved;
    private BigDecimal pointsMultiplier;

}
