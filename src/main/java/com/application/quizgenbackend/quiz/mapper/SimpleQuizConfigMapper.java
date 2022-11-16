package com.application.quizgenbackend.quiz.mapper;

import com.application.quizgenbackend.quiz.dto.QuizConfigDto;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface SimpleQuizConfigMapper {

    @Mapping(target = "topicName", source = "topic.name.nominative")
    @Mapping(target = "knownPropertyType", source = "knownPropertyType.name.nominative")
    @Mapping(target = "unknownPropertyType", source = "unknownPropertyType.name.nominative")
    @Mapping(target = "knownPropertyTypeFormat", source = "knownPropertyType.mediaType")
    @Mapping(target = "unknownPropertyTypeFormat", source = "unknownPropertyType.mediaType")
    QuizConfigDto quizConfigToDto(QuizConfig source);

}
