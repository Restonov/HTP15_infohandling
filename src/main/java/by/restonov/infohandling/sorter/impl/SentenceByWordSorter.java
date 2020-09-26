package by.restonov.infohandling.sorter.impl;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.sorter.BaseSorter;

import java.util.List;
import java.util.stream.Collectors;

public class SentenceByWordSorter implements BaseSorter {

    @Override
    public String sort(TextComponent paragraph) {
        List<TextComponent> sentences = paragraph.getComponents();
        sentences.sort(TextComparator.WORD_LENGTH);
        return sentences.stream().map(TextComponent::toString).collect(Collectors.joining(""));
    }
}
