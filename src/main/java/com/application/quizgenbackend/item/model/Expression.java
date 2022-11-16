package com.application.quizgenbackend.item.model;

import com.application.quizgenbackend.common.grammar.GrammaticalGender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Expression {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nominative;
    private String genitive;
    private String accusative;

    @Enumerated(EnumType.STRING)
    private GrammaticalGender gender;

}
