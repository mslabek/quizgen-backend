package com.application.quizgenbackend.item.dto;

import com.application.quizgenbackend.common.grammar.GrammaticalGender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionDto {

    private String nominative;
    private String genitive;
    private String accusative;
    private GrammaticalGender gender;

}
