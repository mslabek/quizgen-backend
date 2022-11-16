package com.application.quizgenbackend.quiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Data transfer object of {@link com.application.quizgenbackend.quiz.model.Quiz}.
 * <p>
 * Data from this dto is intended to be shown to the answering person.
 */
@Getter
@Setter
public class QuizDto {

    private QuizConfigDto quizConfig;
    private QuizStateDto quizState;
    private List<QuestionDto> questions;

}
