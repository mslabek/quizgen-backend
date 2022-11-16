package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.model.Question;
import com.application.quizgenbackend.quiz.model.QuestionResult;
import com.application.quizgenbackend.quiz.model.Quiz;
import com.application.quizgenbackend.quiz.model.QuizState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class QuizService {

    public Question getCurrentQuestion(Quiz quiz) {
        Integer currentIndex = quiz.getQuizState()
                                   .getCurrentQuestionIndex();
        return quiz.getQuestions()
                   .get(currentIndex);
    }

    public void updateQuizState(Quiz quiz) {
        QuizState state = quiz.getQuizState();
        QuestionResult result = getCurrentQuestion(quiz).getResult();
        updatePoints(state, result.getPointsChange());
        incrementQuestionsSolved(state);
        if (result.getGivenAnswerCorrect()) {
            incrementCorrectAnswerCount(quiz.getQuizState());
        }
        updateMultiplier(state, result.getGivenAnswerCorrect());

        if (state.getCurrentQuestionIndex() == quiz.getQuizConfig().getQuestionCount() - 1) {
            markQuizAsSolved(state);
        } else {
            incrementCurrentIndex(quiz.getQuizState());
        }
    }

    private void updateMultiplier(QuizState state, boolean lastAnswerCorrect) {
        if (lastAnswerCorrect) {
            state.setPointsMultiplier(state.getPointsMultiplier().add(BigDecimal.valueOf(0.1)));
        } else {
            state.setPointsMultiplier(BigDecimal.ONE);
        }
    }

    private void markQuizAsSolved(QuizState state) {
        state.setSolved(true);
    }

    private void incrementQuestionsSolved(QuizState state) {
        state.setQuestionsSolved(state.getQuestionsSolved() + 1);
    }

    private void incrementCorrectAnswerCount(QuizState state) {
        state.setCorrectAnswersCount(state.getCorrectAnswersCount() + 1);
    }

    private void incrementCurrentIndex(QuizState state) {
        state.setCurrentQuestionIndex(state.getCurrentQuestionIndex() + 1);
    }

    private void updatePoints(QuizState state, Integer pointsChange) {
        state.setPoints(state.getPoints() + pointsChange);
    }
}
