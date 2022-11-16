package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.common.util.SubsetSelectorService;
import com.application.quizgenbackend.item.dto.PropertyDto;
import com.application.quizgenbackend.item.service.PropertyService;
import com.application.quizgenbackend.quiz.model.Question;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import com.application.quizgenbackend.quiz.model.QuizItemData;
import com.application.quizgenbackend.quiz.model.QuizTopicData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final PropertyService propertyService;
    private final SubsetSelectorService subsetSelectorService;
    private final QuestionPhraseFactory questionPhraseFactory;

    private QuizTopicData buildTopicData(QuizConfig config) {
        List<PropertyDto> possibleAnswers = propertyService.getPropertiesByTopic(config.getUnknownPropertyType()
                                                                                       .getId(), config.getTopic()
                                                                                                       .getId());
        List<QuizItemData> quizItemData = possibleAnswers.stream()
                                                         .map(a -> buildItemData(a, config.getKnownPropertyType()
                                                                                          .getId()))
                                                         .collect(Collectors.toList());
        List<String> flatUnknownProperties = possibleAnswers.stream()
                                                            .map(PropertyDto::getContent)
                                                            .collect(Collectors.toList());
        return new QuizTopicData(quizItemData, flatUnknownProperties);
    }

    private QuizItemData buildItemData(PropertyDto answerProperty, Long propertyTypeId) {
        String knownProperty = propertyService.getOtherPropertyContent(propertyTypeId, answerProperty.getId())
                                              .getContent();
        return new QuizItemData(answerProperty.getContent(), knownProperty);
    }

    public List<Question> generateQuestions(QuizConfig config) {
        QuizTopicData topicData = buildTopicData(config);
        return subsetSelectorService.selectRandomSubset(topicData.getQuizItems(), config.getQuestionCount())
                                    .stream()
                                    .map(item -> generateQuestion(item, topicData.getFlatUnknownProperties(), config))
                                    .collect(Collectors.toList());
    }

    public Question generateQuestion(QuizItemData itemData, List<String> unknownProperties, QuizConfig config) {
        String questionPhrase = questionPhraseFactory.generatePhrase(config, itemData.getKnownPropertyContent());
        Set<String> answers = subsetSelectorService.selectRandomSubset(unknownProperties, itemData.getUnknownPropertyContent(), config.getAnswerCount());
        return new QuestionBuilder().withQuestionPhrase(questionPhrase)
                                    .withKnownProperty(itemData.getKnownPropertyContent())
                                    .withCorrectAnswer(itemData.getUnknownPropertyContent())
                                    .withAnswers(answers)
                                    .build();
    }

}
