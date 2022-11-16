package com.application.quizgenbackend.item.service;

import com.application.quizgenbackend.item.dto.PropertyTypeBaseDto;
import com.application.quizgenbackend.item.dto.TopicBaseDto;
import com.application.quizgenbackend.item.dto.TopicDetailedDto;
import com.application.quizgenbackend.item.dto.TopicDto;
import com.application.quizgenbackend.item.mapper.TopicMapper;
import com.application.quizgenbackend.item.model.Topic;
import com.application.quizgenbackend.item.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Cacheable("topics")
    public List<TopicDto> getTopics() {
        return topicRepository.findAll()
                              .stream()
                              .map(topicMapper::topicToDto)
                              .collect(Collectors.toList());
    }

    @Cacheable("detailedTopics")
    public Optional<TopicDetailedDto> getDetailedTopicByName(String name) {
        return getTopic(name).map(topicMapper::topicToDetailedDto);
    }

    private Optional<Topic> getTopic(String name) {
        return topicRepository.findByName(name);
    }

    @Cacheable("propertyTypeTopicCheck")
    public Boolean checkIfPropertyTypeBelongsToTopic(PropertyTypeBaseDto propertyType, TopicBaseDto topic) {
        return getAllTopicsByPropertyTypeId(propertyType.getId())
                .stream()
                .anyMatch(t -> t.getId()
                                .equals(topic.getId()));
    }

    private List<TopicDto> getAllTopicsByPropertyTypeId(Long propertyTypeId) {
        return topicRepository.findAllByPropertyTypeId(propertyTypeId)
                              .stream()
                              .map(topicMapper::topicToDto)
                              .collect(Collectors.toList());
    }

}
