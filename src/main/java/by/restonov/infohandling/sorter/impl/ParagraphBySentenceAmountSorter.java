package by.restonov.infohandling.sorter.impl;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.sorter.BaseSorter;

import java.util.List;
import java.util.stream.Collectors;

public class ParagraphBySentenceAmountSorter implements BaseSorter {

    @Override
    public String sort(TextComponent text) {
        List<TextComponent> paragraphs = text.getComponents();
        paragraphs.sort(TextComparator.SENTENCES_AMOUNT);
        return paragraphs.stream().map(TextComponent::toString).collect(Collectors.joining("\n"));
    }
}
