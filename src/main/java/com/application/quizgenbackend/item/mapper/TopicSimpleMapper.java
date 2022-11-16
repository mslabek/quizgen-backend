package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.TopicDetailedDto;
import com.application.quizgenbackend.item.dto.TopicDto;
import com.application.quizgenbackend.item.model.Topic;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {PropertyTypeSimpleMapper.class, ExpressionSimpleMapper.class})
public abstract class TopicSimpleMapper {

    @Mapping(target = "name", source = "name.nominative")
    @Mapping(target = "propertyTypes", ignore = true)
    @Mapping(target = "itemCount", ignore = true)
    protected abstract TopicDto simpleTopicToDto(Topic topic);

    @Mapping(target = "propertyTypes", ignore = true)
    @Mapping(target = "itemCount", ignore = true)
    protected abstract TopicDetailedDto simpleTopicToDetailedDto(Topic topic);

}
