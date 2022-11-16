package com.application.quizgenbackend.quiz.mapper;

import com.application.quizgenbackend.quiz.dto.QuestionDto;
import com.application.quizgenbackend.quiz.model.Question;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = SimpleQuestionResultMapper.class)
public interface SimpleQuestionMapper {

    QuestionDto questionToDto(Question question);

}
