package by.restonov.infohandling.util;

import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;

import java.util.ArrayList;
import java.util.List;

public class TextParameterCalculator {
    public static final String LETTER_REGEX = "[a-zA-Z]";

    public static int findLexemesLength(TextComponent sentence) {
        int length = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            int symbolAmount = lexeme.getComponents().size();
            length += symbolAmount;
        }
        return length;
    }

    public static int findParagraphSize(TextComponent paragraph) {
        List<TextComponent> sentences = paragraph.getComponents();
        return sentences.size();
    }

    public static int findWordsLength(TextComponent sentence) {
        int letterAmount = 0;
        List<TextComponent> lexemes = sentence.getComponents();
        for (TextComponent lexeme : lexemes) {
            List<TextComponent> symbols = lexeme.getComponents();
            for (TextComponent symbol : symbols) {
                if (String.valueOf(symbol).matches(LETTER_REGEX)) {
                    letterAmount++;
                }
            }
        }
        return letterAmount;
    }

    public static int findLetterOccurrence(TextComponent lexeme, char letter) {
        TextComponent givenSymbol = new Letter(letter);
        return (int) lexeme.getComponents().stream()
                .filter(s -> s.equals(givenSymbol)).count();
    }
}
