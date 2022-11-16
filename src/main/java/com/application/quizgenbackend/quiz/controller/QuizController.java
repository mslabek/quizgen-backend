package com.application.quizgenbackend.quiz.controller;

import com.application.quizgenbackend.quiz.dto.QuizDto;
import com.application.quizgenbackend.quiz.form.AnswerForm;
import com.application.quizgenbackend.quiz.form.QuizConfigRequest;
import com.application.quizgenbackend.quiz.mapper.QuizMapper;
import com.application.quizgenbackend.quiz.model.Quiz;
import com.application.quizgenbackend.quiz.service.QuizFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class QuizController {

    private final QuizFacade quizFacade;
    private final QuizMapper quizMapper;

    @PostMapping("/quiz/new")
    public QuizDto getQuiz(HttpSession httpSession, @Valid @RequestBody QuizConfigRequest request) {
        Quiz quiz = quizFacade.generateQuiz(request);
        httpSession.setAttribute("quiz", quiz);
        return quizMapper.quizToDto(quiz);
    }

    @PostMapping("/quiz/answer")
    public QuizDto postAnswer(HttpSession httpSession, @Valid @RequestBody AnswerForm answerFormDto) {
        Quiz quiz = (Quiz) httpSession.getAttribute("quiz");
        quizFacade.processAnswer(quiz, answerFormDto);
        return quizMapper.quizToDto(quiz);
    }

}
