package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.model.QuizState;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class QuizStateFactory {

    public QuizState generateInitialState() {
        QuizState state = new QuizState();
        state.setCurrentQuestionIndex(0);
        state.setQuestionsSolved(0);
        state.setPoints(0);
        state.setPointsMultiplier(BigDecimal.ONE);
        state.setCorrectAnswersCount(0);
        state.setSolved(false);
        return state;
    }

}
