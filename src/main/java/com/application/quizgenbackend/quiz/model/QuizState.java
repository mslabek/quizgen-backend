package com.application.quizgenbackend.quiz.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Domain object representing current state of the {@link Quiz}.
 */
@Getter
@Setter
public class QuizState {

    private Integer currentQuestionIndex;
    private Integer questionsSolved;
    private Integer correctAnswersCount;
    private Integer points;
    private Boolean solved;
    private BigDecimal pointsMultiplier;

}
