package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.model.QuestionResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class QuestionResultFactory {

    private static final Integer CORRECT_ANSWER_BASE_POINTS = 100;
    private static final Integer INCORRECT_ANSWER_BASE_POINTS = 0;

    public QuestionResult generateResult(String correctAnswer, String answer, BigDecimal multiplier) {
        QuestionResult result = new QuestionResult();
        boolean correct = checkAnswer(correctAnswer, answer);
        result.setGivenAnswerCorrect(correct);
        result.setCorrectAnswer(correctAnswer);
        if (correct) {
            result.setPointsChange(calculatePoints(CORRECT_ANSWER_BASE_POINTS, multiplier));
        } else {
            result.setPointsChange(INCORRECT_ANSWER_BASE_POINTS);
        }
        return result;
    }

    private int calculatePoints(int basePoints, BigDecimal multiplier) {
        return (int) (basePoints * multiplier.doubleValue());
    }

    private boolean checkAnswer(String correctAnswer, String answer) {
        return correctAnswer.equals(answer);
    }

}
