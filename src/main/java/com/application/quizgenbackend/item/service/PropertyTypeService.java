package com.application.quizgenbackend.item.service;

import com.application.quizgenbackend.item.dto.PropertyTypeDetailedDto;
import com.application.quizgenbackend.item.dto.PropertyTypeDto;
import com.application.quizgenbackend.item.mapper.PropertyTypeMapper;
import com.application.quizgenbackend.item.model.PropertyType;
import com.application.quizgenbackend.item.repository.PropertyTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;
    private final PropertyTypeMapper mapper;

    @Cacheable("detailedPropertyByName")
    public Optional<PropertyTypeDetailedDto> getPropertyTypeDetailed(String name) {
        return getPropertyTypes(name).map(mapper::propertyTypeDetailedDto);
    }

    /**
     * Returns unique property types that are referenced by items of the topic.
     *
     * @param topic the topic which searched property types are associated with
     * @return list of matching property types
     */
    @Cacheable("propertyTypesByTopic")
    public List<PropertyTypeDto> getPropertyTypesByTopicId(Long topicId) {
        return getPropertyTypes(topicId).stream()
                                        .map(mapper::propertyTypeToDto)
                                        .collect(Collectors.toList());
    }

    @Cacheable("detailedPropertyTypesByTopic")
    public List<PropertyTypeDetailedDto> getPropertyTypesDetailedByTopicId(Long topicId) {
        return getPropertyTypes(topicId).stream()
                                        .map(mapper::propertyTypeDetailedDto)
                                        .collect(Collectors.toList());
    }

    private Optional<PropertyType> getPropertyTypes(String name) {
        return propertyTypeRepository.findByName(name);
    }

    private List<PropertyType> getPropertyTypes(Long topicId) {
        return propertyTypeRepository.findAllByTopic(topicId);
    }

}
