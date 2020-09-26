package by.restonov.infohandling.sorter.impl;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.sorter.BaseSorter;

import java.util.List;
import java.util.stream.Collectors;

public class SentenceBySymbolOccurrence implements BaseSorter {

    public String sort(TextComponent sentence) {
        List<TextComponent> lexemes = sentence.getComponents();
        lexemes.sort(TextComparator.SYMBOL_OCCURRENCE);
        return lexemes.stream().map(TextComponent::toString).collect(Collectors.joining(" "));
    }
}
