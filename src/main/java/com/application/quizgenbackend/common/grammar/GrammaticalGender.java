package com.application.quizgenbackend.common.grammar;


public enum GrammaticalGender {
    MASCULINE, FEMININE;

    public String getPronoun(Declension declension, PolishPronoun pronoun) {
        return pronoun.getPronoun(this, declension);
    }
}
