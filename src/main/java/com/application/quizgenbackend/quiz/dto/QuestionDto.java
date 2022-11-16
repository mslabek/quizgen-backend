package com.application.quizgenbackend.quiz.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Data transfer object of {@link com.application.quizgenbackend.quiz.model.Question}.
 * <p>
 * Data from this dto is intended to be shown to the answering person, thus it cannot contain information about the
 * correct answer.
 */
@Getter
@Setter
public class QuestionDto {

    private String questionPhrase;
    private String knownProperty;
    private Set<String> answers;
    private QuestionResultDto result;

}
