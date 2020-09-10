package by.restonov.infohandling.sorter;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class LexemeSorter {

    public String sort(TextComponent text) {
        List<TextComponent> paragraphs = text.getComponents();
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent paragraph: paragraphs) {
            sentences.addAll(paragraph.getComponents());
        }
        sentences.sort(TextComparator.LEXEME_LENGTH);
        return sentences.toString();
    }
}
