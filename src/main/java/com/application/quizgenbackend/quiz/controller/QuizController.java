package com.application.quizgenbackend.quiz.controller;

import com.application.quizgenbackend.quiz.dto.QuizDto;
import com.application.quizgenbackend.quiz.form.AnswerForm;
import com.application.quizgenbackend.quiz.form.QuizConfigRequest;
import com.application.quizgenbackend.quiz.mapper.QuizMapper;
import com.application.quizgenbackend.quiz.model.Question;
import com.application.quizgenbackend.quiz.model.QuestionResult;
import com.application.quizgenbackend.quiz.model.Quiz;
import com.application.quizgenbackend.quiz.model.QuizState;
import com.application.quizgenbackend.quiz.service.QuizFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    /**
     * Creates a new {@link Quiz} and bind it to {@link HttpSession session}.
     *
     * @param httpSession the session the quiz is to be bound to
     * @param request     the object specifying data of the quiz
     * @return the dto representing the generated {@code quiz}
     */
    @PostMapping("/quiz/new")
    @Operation(summary = "Creates a new quiz")
    @ApiResponse(responseCode = "200", description = "Quiz created successfully")
    @ApiResponse(responseCode = "400", description = "Request validation error", content = @Content)
    @ApiResponse(responseCode = "5xx", description = "Unexpected error", content = @Content)
    public QuizDto createQuiz(HttpSession httpSession, @Valid @RequestBody QuizConfigRequest request) {
        Quiz quiz = quizFacade.generateQuiz(request);
        httpSession.setAttribute("quiz", quiz);
        return quizMapper.quizToDto(quiz);
    }

    /**
     * Resolves the answer against the current {@link Quiz} bound to {@link HttpSession session}. The answer is checked
     * in context of the current {@link Question}. The {@link QuestionResult} of the answer is sent back as a part of
     * the returned {@code quiz} dto nested in the corresponding {@code question}.
     * <p>
     * Every time the answer is received, the {@code quiz dto} updates its state to contain next question. This is
     * represented in the {@link QuizState} object. If the answer refers to the last question of the {@code quiz}, the
     * result of the last question is added and the {@code quiz} is marked as solved. From that point, if the controller
     * receives more answers, it throws an exception.
     *
     * @param httpSession the session the quiz is bound to
     * @param request     the object containing the answer to the current question
     * @return the dto representing the updated {@code quiz} containing the {@code question result}.
     */
    @PostMapping("/quiz/answer")
    @Operation(summary = "Sends answer to the current question of the current quiz", description = "Resolves the " + "answer against the current Quiz bound to session. The answer is checked in context of the current question. The QuestionResult of the answer is sent back as a part of the returned quiz dto nested in the corresponding question." + "<p>" + "Every time the answer is received, the quiz dto updates its state to contain next question. This is represented in the QuizState object. If the answer refers to the last question of the quiz, the result of the last question is added and the  quiz is marked as solved. From that point, if the controller receives more answers, it throws an exception.")
    @ApiResponse(responseCode = "200", description = "Answer processed successfully")
    @ApiResponse(responseCode = "400", description = "Request validation error or quiz already completed", content = @Content)
    @ApiResponse(responseCode = "5xx", description = "Unexpected error", content = @Content)
    public QuizDto postAnswer(HttpSession httpSession, @Valid @RequestBody AnswerForm request) {
        Quiz quiz = (Quiz) httpSession.getAttribute("quiz");
        quizFacade.processAnswer(quiz, request);
        return quizMapper.quizToDto(quiz);
    }

}
