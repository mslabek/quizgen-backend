package com.application.quizgenbackend.quiz.mapper;

import com.application.quizgenbackend.quiz.dto.QuestionResultDto;
import com.application.quizgenbackend.quiz.model.QuestionResult;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SimpleQuestionResultMapper {

    QuestionResultDto questionResultToDto(QuestionResult source);

}
