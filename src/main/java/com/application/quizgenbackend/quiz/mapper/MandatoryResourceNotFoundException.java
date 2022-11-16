package com.application.quizgenbackend.quiz.mapper;

public class MandatoryResourceNotFoundException extends IllegalArgumentException {

    public MandatoryResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
