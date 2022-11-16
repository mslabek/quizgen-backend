package com.application.quizgenbackend.quiz.model;

import com.application.quizgenbackend.quiz.service.QuestionBuilder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * Domain object representing a question.
 */
@Getter
@ToString
public class Question {

    private final String questionPhrase;
    private final String knownProperty;
    private final Set<String> answers;
    private final String correctAnswer;
    private QuestionResult result;

    public Question(QuestionBuilder builder) {
        questionPhrase = builder.getQuestionPhrase();
        answers = builder.getAnswers();
        correctAnswer = builder.getCorrectAnswer();
        knownProperty = builder.getKnownProperty();
    }

    public void setQuestionResult(QuestionResult result) {
        this.result = result;
    }

}
