package com.application.quizgenbackend.quiz.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class AnswerForm {

    @NotBlank(message = "Answer is mandatory")
    private String answer;

}
