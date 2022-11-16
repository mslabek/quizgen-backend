package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.ItemDto;
import com.application.quizgenbackend.item.model.Item;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = PropertySimpleMapper.class)
abstract class ItemSimpleMapper {

    protected abstract ItemDto itemToDto(Item source);

}
