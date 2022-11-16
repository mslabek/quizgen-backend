package com.application.quizgenbackend.quiz.exception;

import com.application.quizgenbackend.infrastructure.exception.ApiLevelException;

public class BadAnswerRequestException extends RuntimeException implements ApiLevelException {

    public BadAnswerRequestException(String s) {
        super(s);
    }

}
