package com.application.quizgenbackend.item.mapper;

import com.application.quizgenbackend.item.dto.TopicBaseDto;
import com.application.quizgenbackend.item.dto.TopicDetailedDto;
import com.application.quizgenbackend.item.dto.TopicDto;
import com.application.quizgenbackend.item.model.Topic;
import com.application.quizgenbackend.item.service.ItemService;
import com.application.quizgenbackend.item.service.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TopicMapper {

    private final PropertyTypeService propertyTypeService;
    private final TopicSimpleMapper topicSimpleMapper;
    private final ItemService itemService;

    /**
     * Maps a topic entity to topic dto.
     *
     * @param source the topic to be mapped
     * @return the mapped topic dto
     */
    public TopicDto topicToDto(Topic source) {
        TopicDto dto = topicSimpleMapper.simpleTopicToDto(source);
        fillItemCount(dto);
        fillPropertyTypeDtos(dto);
        return dto;
    }

    public TopicDetailedDto topicToDetailedDto(Topic source) {
        TopicDetailedDto dto = topicSimpleMapper.simpleTopicToDetailedDto(source);
        fillItemCount(dto);
        fillPropertyTypeDtos(dto);
        return dto;
    }

    private void fillItemCount(TopicBaseDto dto) {
        dto.setItemCount(itemService.countItemsByTopic(dto.getId()));
    }

    private void fillPropertyTypeDtos(TopicDetailedDto dto) {
        dto.setPropertyTypes(propertyTypeService.getPropertyTypesDetailedByTopicId(dto.getId()));
    }

    private void fillPropertyTypeDtos(TopicDto dto) {
        dto.setPropertyTypes(propertyTypeService.getPropertyTypesByTopicId(dto.getId()));
    }

}
