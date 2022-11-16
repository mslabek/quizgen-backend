package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.ExpressionDto;
import com.application.quizgenbackend.item.model.Expression;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
abstract class ExpressionSimpleMapper {

    protected abstract ExpressionDto expressionToDto(Expression source);

}
