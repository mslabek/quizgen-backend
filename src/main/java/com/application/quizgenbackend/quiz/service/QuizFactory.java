package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.model.Quiz;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizFactory {

    private final QuizStateFactory quizStateFactory;
    private final QuestionService questionService;

    Quiz buildWithInitialState(QuizConfig config) {
        Quiz quiz = new Quiz();
        quiz.setQuizConfig(config);
        quiz.setQuizState(quizStateFactory.generateInitialState());
        quiz.setQuestions(questionService.generateQuestions(config));
        return quiz;
    }

}
