package com.application.quizgenbackend.quiz.service;

import com.application.quizgenbackend.common.grammar.Declension;
import com.application.quizgenbackend.common.grammar.PolishPronoun;
import com.application.quizgenbackend.quiz.model.QuizConfig;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.uncapitalize;

@Service
@RequiredArgsConstructor
public class QuestionPhraseFactory {

    private static final String QUESTION_TEMPLATE = "${unknownPropertyTypePronounInterrogativeGenitive} jest ${unknownPropertyTypeNameNominative} ${knownPropertyResolvedTemplate}?";

    public String generatePhrase(QuizConfig config, String knownPropertyContent) {
        String template = joinTemplates(config.getKnownPropertyType()
                                              .getQuestionEndingTemplate());
        return StringSubstitutor.replace(template, extractTemplateValues(config, knownPropertyContent));
    }

    private String joinTemplates(String subTemplate) {
        Map<String, String> valuesMap = Map.of("knownPropertyResolvedTemplate", subTemplate);
        return StringSubstitutor.replace(QuestionPhraseFactory.QUESTION_TEMPLATE, valuesMap);
    }

    private Map<String, String> extractTemplateValues(QuizConfig config, String knownPropertyContent) {
        Map<String, String> templateValues = new HashMap<>();
        templateValues.put("topicNameGenitive", uncapitalize(config.getTopic()
                                                                   .getName()
                                                                   .getGenitive()));
        templateValues.put("topicPronounRelativeGenitive", config.getTopic()
                                                                 .getName()
                                                                 .getGender()
                                                                 .getPronoun(Declension.GENITIVE, PolishPronoun.RELATIVE));
        templateValues.put("unknownPropertyTypePronounInterrogativeGenitive", capitalize(config.getUnknownPropertyType()
                                                                                               .getName()
                                                                                               .getGender()
                                                                                               .getPronoun(Declension.GENITIVE, PolishPronoun.INTERROGATIVE)));
        templateValues.put("unknownPropertyTypeNameNominative", uncapitalize(config.getUnknownPropertyType()
                                                                                   .getName()
                                                                                   .getNominative()));
        templateValues.put("knownPropertyName", knownPropertyContent);
        return templateValues;
    }

}
