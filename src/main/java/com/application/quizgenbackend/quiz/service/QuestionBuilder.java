package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.model.Question;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class QuestionBuilder {

    private String questionPhrase;
    private String knownProperty;
    private Set<String> answers = new HashSet<>();
    private String correctAnswer;

    public QuestionBuilder withQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
        return this;
    }

    public QuestionBuilder withKnownProperty(String knownProperty) {
        this.knownProperty = knownProperty;
        return this;
    }

    public QuestionBuilder withAnswers(Set<String> answers) {
        this.answers = answers;
        return this;
    }

    public QuestionBuilder withCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public Question build() {
        if (questionPhrase == null || answers == null || correctAnswer == null || knownProperty == null) {
            throw new IllegalStateException("QuestionPhrase, answers and correctAnswer cannot be null");
        }
        return new Question(this);
    }

}
