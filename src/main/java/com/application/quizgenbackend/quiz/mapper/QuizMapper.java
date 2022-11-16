package com.application.quizgenbackend.quiz.mapper;

import com.application.quizgenbackend.quiz.dto.QuestionDto;
import com.application.quizgenbackend.quiz.dto.QuizDto;
import com.application.quizgenbackend.quiz.model.Question;
import com.application.quizgenbackend.quiz.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizMapper {

    private final SimpleQuizConfigMapper configMapper;
    private final SimpleQuizStateMapper stateMapper;
    private final SimpleQuestionMapper questionMapper;

    public QuizDto quizToDto(Quiz source) {
        QuizDto target = new QuizDto();
        target.setQuizConfig(configMapper.quizConfigToDto(source.getQuizConfig()));
        target.setQuizState(stateMapper.quizStateToDto(source.getQuizState()));
        target.setQuestions(mapQuestionsUpToCurrentIndex(source.getQuestions(), source.getQuizState()
                                                                                      .getCurrentQuestionIndex()));
        return target;
    }

    private List<QuestionDto> mapQuestionsUpToCurrentIndex(List<Question> questions, Integer currentIndex) {
        List<QuestionDto> target = new ArrayList<>();
        for (int i = 0; i <= currentIndex; i++) {
            target.add(questionMapper.questionToDto(questions.get(i)));
        }
        return target;
    }

}
