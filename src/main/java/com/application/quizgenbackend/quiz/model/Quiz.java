package com.application.quizgenbackend.quiz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Domain object representing a quiz
 */
@Getter
@Setter
public class Quiz {

    private QuizConfig quizConfig;
    private QuizState quizState;
    private List<Question> questions;

}
