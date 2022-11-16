package com.application.quizgenbackend.quiz.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class QuizConfigRequest {

    @NotBlank(message = "Topic name is mandatory")
    private String topicName;

    @NotBlank(message = "Known property type name is mandatory")
    private String knownPropertyTypeName;

    @NotBlank(message = "Unknown property type name is mandatory")
    private String unknownPropertyTypeName;

    @NotNull(message = "Question count is mandatory")
    @Min(value = 5, message = "Question count cannot be lower than 5")
    private Integer questionCount;

    @Min(value = 2, message = "Answers count cannot be lower than 2")
    private Integer answerCount;

}
