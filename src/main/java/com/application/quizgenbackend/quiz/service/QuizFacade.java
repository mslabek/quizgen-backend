package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.quiz.exception.BadAnswerRequestException;
import com.application.quizgenbackend.quiz.form.AnswerForm;
import com.application.quizgenbackend.quiz.form.QuizConfigRequest;
import com.application.quizgenbackend.quiz.model.Question;
import com.application.quizgenbackend.quiz.model.QuestionResult;
import com.application.quizgenbackend.quiz.model.Quiz;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizFacade {

    private final QuizConfigFactory quizConfigFactory;
    private final QuizFactory quizFactory;
    private final QuestionResultFactory questionResultFactory;
    private final QuizService quizService;

    public Quiz generateQuiz(QuizConfigRequest request) {
        QuizConfig config = quizConfigFactory.generateQuizConfig(request);
        return quizFactory.buildWithInitialState(config);
    }

    public void processAnswer(Quiz quiz, AnswerForm form) {
        validateQuizSolvability(quiz);
        validateAnswerPossibility(quiz, form);
        updateQuizResult(quiz, form);
        quizService.updateQuizState(quiz);
    }

    private void validateQuizSolvability(Quiz quiz) {
        if (quiz.getQuizState().getSolved()) {
            throw new BadAnswerRequestException("The quiz has already been solved.");
        }
    }

    private void validateAnswerPossibility(Quiz quiz, AnswerForm form) {
        Question currentQuestion = quizService.getCurrentQuestion(quiz);
        if (!currentQuestion.getAnswers().contains(form.getAnswer())) {
            throw new BadAnswerRequestException("The answer in invalid.");
        }
    }

    private void updateQuizResult(Quiz quiz, AnswerForm form) {
        Question currentQuestion = quizService.getCurrentQuestion(quiz);
        QuestionResult result = questionResultFactory.generateResult(currentQuestion.getCorrectAnswer(),
                form.getAnswer(), quiz.getQuizState().getPointsMultiplier());
        currentQuestion.setQuestionResult(result);
    }

}
