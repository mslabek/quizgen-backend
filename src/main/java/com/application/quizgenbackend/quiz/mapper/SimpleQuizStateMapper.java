package com.application.quizgenbackend.quiz.mapper;

import com.application.quizgenbackend.quiz.dto.QuizStateDto;
import com.application.quizgenbackend.quiz.model.QuizState;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SimpleQuizStateMapper {

    QuizStateDto quizStateToDto(QuizState source);

}
