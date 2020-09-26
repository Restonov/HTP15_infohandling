package by.restonov.infohandling.comparator;

import by.restonov.infohandling.entity.TextComponent;

import java.util.Comparator;
import static by.restonov.infohandling.util.TextParameterCalculator.*;

public enum TextComparator implements Comparator<TextComponent> {
    SENTENCES_AMOUNT {
        @Override
        public int compare(TextComponent paragraph1, TextComponent paragraph2) {
            int paragraphSize1 = findParagraphSize(paragraph1);
            int paragraphSize2 = findParagraphSize(paragraph2);
            return Integer.compare(paragraphSize1, paragraphSize2);
        }
    },

    LEXEME_LENGTH {
        @Override
        public int compare(TextComponent sentence1, TextComponent sentence2) {
            int lexemesLength1 = findLexemesLength(sentence1);
            int lexemesLength2 = findLexemesLength(sentence2);
            if (lexemesLength1 > lexemesLength2) {
                return 1;
            } else if (lexemesLength1 < lexemesLength2) {
                return -1;
            } return 0;
        }
    },

    WORD_LENGTH {
        @Override
        public int compare(TextComponent sentence1, TextComponent sentence2) {
            int wordsLength1 = findWordsLength(sentence1);
            int wordsLength2 = findWordsLength(sentence2);
            return Integer.compare(wordsLength1, wordsLength2);
        }
    },

    SYMBOL_OCCURRENCE {
        @Override
        public int compare(TextComponent lexeme1, TextComponent lexeme2) {
            int lexemeOccurrence1 = findLetterOccurrence(lexeme1, symbol);
            int lexemeOccurrence2 = findLetterOccurrence(lexeme2, symbol);
            if (lexemeOccurrence1 > lexemeOccurrence2) {
                return -1;
            } else if (lexemeOccurrence1 < lexemeOccurrence2) {
                return 1;
            }
            return lexeme1.toString().compareToIgnoreCase(lexeme2.toString());
        }
    };

    private static char symbol;

    public static void setSymbol(char symbol) {
        TextComparator.symbol = symbol;
    }
}
