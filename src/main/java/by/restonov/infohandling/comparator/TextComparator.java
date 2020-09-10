package by.restonov.infohandling.comparator;

import by.restonov.infohandling.entity.TextComponent;

import java.util.Comparator;
import java.util.List;

public enum TextComparator implements Comparator<TextComponent> {
    LEXEME_LENGTH {
        @Override
        public int compare(TextComponent sentence1, TextComponent sentence2) {
            Integer result = Integer.compare(getLexemesLength(sentence1), getLexemesLength(sentence2));
            return result;
        }

        private int getLexemesLength(TextComponent sentence) {
            int length = 0;
            List<TextComponent> lexemes = sentence.getComponents();
            for (TextComponent lexeme : lexemes) {
                int symbolAmount = lexeme.getComponents().size();
                length += symbolAmount;
            }
            return length;
        }
    }
}
