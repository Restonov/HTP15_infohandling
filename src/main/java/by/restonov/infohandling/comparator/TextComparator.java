package by.restonov.infohandling.comparator;

import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.util.TextParameter;

import java.util.Comparator;

public enum TextComparator implements Comparator<TextComponent> {
    SENTENCES_AMOUNT {
        @Override
        public int compare(TextComponent paragraph1, TextComponent paragraph2) {
            int paragraphSize1 = TextParameter.getParagraphSize(paragraph1);
            int paragraphSize2 = TextParameter.getParagraphSize(paragraph2);
            return Integer.compare(paragraphSize1, paragraphSize2);
        }
    },

    LEXEME_LENGTH {
        @Override
        public int compare(TextComponent sentence1, TextComponent sentence2) {
            int lexemesLength1 = TextParameter.getLexemesLength(sentence1);
            int lexemesLength2 = TextParameter.getLexemesLength(sentence2);
            return Integer.compare(lexemesLength1, lexemesLength2);
        }


    }
}
