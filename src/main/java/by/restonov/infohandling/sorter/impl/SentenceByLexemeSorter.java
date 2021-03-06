package by.restonov.infohandling.sorter.impl;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.sorter.BaseSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SentenceByLexemeSorter implements BaseSorter {

    public String sort(TextComponent paragraph) {
        List<TextComponent> sentences = paragraph.getComponents();
        sentences.sort(TextComparator.LEXEME_LENGTH);
        return sentences.stream().map(TextComponent::toString).collect(Collectors.joining(""));
    }
}
