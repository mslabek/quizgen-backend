package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.item.dto.PropertyTypeDetailedDto;
import com.application.quizgenbackend.item.dto.TopicDetailedDto;
import com.application.quizgenbackend.item.service.PropertyTypeService;
import com.application.quizgenbackend.item.service.TopicService;
import com.application.quizgenbackend.quiz.form.QuizConfigRequest;
import com.application.quizgenbackend.quiz.mapper.MandatoryResourceNotFoundException;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class QuizConfigFactory {

    private final TopicService topicService;
    private final PropertyTypeService propertyTypeService;

    public QuizConfig generateQuizConfig(QuizConfigRequest request) {
        QuizConfig target = new QuizConfig();

        TopicDetailedDto topic = mapNameToTopic(request.getTopicName());
        target.setTopic(topic);

        PropertyTypeDetailedDto knownProperty = mapNameToPropertyType(request.getKnownPropertyTypeName());
        PropertyTypeDetailedDto unknownProperty = mapNameToPropertyType(request.getUnknownPropertyTypeName());
        Stream.of(knownProperty, unknownProperty)
              .forEach(propertyType -> {
                  if (!topicService.checkIfPropertyTypeBelongsToTopic(knownProperty, topic)) {
                      throw new MandatoryResourceNotFoundException("Property Type of given name found but it is not associated " +
                              "with given topic");
                  }
              });
        target.setKnownPropertyType(knownProperty);
        target.setUnknownPropertyType(unknownProperty);
        target.setQuestionCount(request.getQuestionCount());
        target.setAnswerCount(request.getAnswerCount());
        return target;
    }

    private TopicDetailedDto mapNameToTopic(String topicName) {
        return topicService.getDetailedTopicByName(topicName)
                           .orElseThrow(() -> {
                               throw new MandatoryResourceNotFoundException("Requested Topic not found");
                           });
    }

    private PropertyTypeDetailedDto mapNameToPropertyType(String propertyTypeName) {
        return propertyTypeService.getPropertyTypeDetailed(propertyTypeName)
                                  .orElseThrow(() -> {
                                      throw new MandatoryResourceNotFoundException("Requested Property Type not found");
                                  });
    }

}
