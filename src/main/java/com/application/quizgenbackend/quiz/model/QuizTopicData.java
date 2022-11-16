package com.application.quizgenbackend.quiz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizTopicData {

    private List<QuizItemData> quizItems;
    private List<String> flatUnknownProperties;

}
