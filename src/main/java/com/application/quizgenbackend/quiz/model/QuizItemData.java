package com.application.quizgenbackend.quiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizItemData {

    public QuizItemData(String unknownPropertyContent, String knownPropertyContent) {
        this.unknownPropertyContent = unknownPropertyContent;
        this.knownPropertyContent = knownPropertyContent;
    }

    private final String unknownPropertyContent;
    private final String knownPropertyContent;
    private boolean used;

}
