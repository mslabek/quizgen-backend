package com.application.quizgenbackend.common.grammar;

public enum PolishPronoun {

    INTERROGATIVE {
        private static final String INTERROGATIVE_GENITIVE_MASCULINE = "jaki";
        private static final String INTERROGATIVE_GENITIVE_FEMININE = "jaka";

        public String getPronoun(GrammaticalGender gender, Declension declension) {
            switch (declension) {
                case GENITIVE:
                    return getPronounGenitive(gender);
                default:
                    throw new UnsupportedOperationException("Pronoun for this declension has not been configured.");
            }
        }

        private String getPronounGenitive(GrammaticalGender gender) {
            switch (gender) {
                case MASCULINE:
                    return INTERROGATIVE_GENITIVE_MASCULINE;
                case FEMININE:
                    return INTERROGATIVE_GENITIVE_FEMININE;
                default:
                    throw new UnsupportedOperationException("Pronoun for this gender has not been configured.");
            }
        }
    },

    RELATIVE {
        private static final String RELATIVE_GENITIVE_MASCULINE = "którego";
        private static final String RELATIVE_GENITIVE_FEMININE = "której";

        public String getPronoun(GrammaticalGender gender, Declension declension) {
            switch (declension) {
                case GENITIVE:
                    return getPronounGenitive(gender);
                default:
                    throw new UnsupportedOperationException("Pronoun for this declension has not been configured.");
            }
        }

        private String getPronounGenitive(GrammaticalGender gender) {
            switch (gender) {
                case MASCULINE:
                    return RELATIVE_GENITIVE_MASCULINE;
                case FEMININE:
                    return RELATIVE_GENITIVE_FEMININE;
                default:
                    throw new UnsupportedOperationException("Pronoun for this gender has not been configured.");
            }
        }
    };

    public abstract String getPronoun(GrammaticalGender gender, Declension declension);

}
