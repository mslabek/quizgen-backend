package com.application.quizgenbackend.item.service;

import com.application.quizgenbackend.item.dto.PropertyDto;
import com.application.quizgenbackend.item.mapper.PropertyMapper;
import com.application.quizgenbackend.item.model.Property;
import com.application.quizgenbackend.item.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;
    private final PropertyMapper mapper;

    /**
     * Returns property belonging to the item and having the property type.
     *
     * @param itemId         the item possessing the searched property
     * @param propertyTypeId the property type of the searched property
     * @return the matching property
     */
    @Cacheable("properties")
    public PropertyDto getProperty(Long propertyTypeId, Long itemId) {
        return mapper.propertyToDto(getPropertyFromRepository(propertyTypeId, itemId));
    }

    @Cacheable("propertiesContentByTopic")
    public List<PropertyDto> getPropertiesByTopic(Long propertyTypeId, Long topicId) {
        return getPropertiesFromRepository(propertyTypeId, topicId)
                .stream()
                .map(mapper::propertyToDto)
                .collect(Collectors.toList());
    }

    @Cacheable("propertyByOtherPropertyAndType")
    public PropertyDto getOtherPropertyContent(Long propertyTypeId, Long propertyId) {
        return mapper.propertyToDto(getOtherPropertyFromRepository(propertyTypeId, propertyId));
    }

    public String getPropertyContent(Long propertyTypeId, Long itemId) {
        return getPropertyFromRepository(propertyTypeId, itemId).getContent();
    }

    private List<Property> getPropertiesFromRepository(Long propertyTypeId, Long topicId) {
        return propertyRepository.findAllByPropertyTypeAndTopic(propertyTypeId, topicId);
    }

    private Property getPropertyFromRepository(Long propertyTypeId, Long itemId) {
        return propertyRepository.findByPropertyTypeAndItem(propertyTypeId, itemId)
                                 .orElseThrow(NoSuchElementException::new);
    }

    private Property getOtherPropertyFromRepository(Long propertyTypeId, Long propertyId) {
        return propertyRepository.findByPropertyTypeAndOtherProperty(propertyTypeId, propertyId)
                                 .orElseThrow(NoSuchElementException::new);
    }

}
