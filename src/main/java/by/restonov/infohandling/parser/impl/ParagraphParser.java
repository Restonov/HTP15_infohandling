package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.AbstractParser;

public class ParagraphParser implements AbstractParser {
    private static final String SENTENCE_DELIMITER = "[.?!]\\\\s?]";
    private AbstractParser sentenceParcer = new SentenceParser();

    @Override
    public TextComponent parse(String text) {
        var paragraphComponent = new TextComposite(ComponentType.PARAGRAPH);
        String[] sentences = text.split(SENTENCE_DELIMITER);
        for (String sentence: sentences) {
            TextComponent sentenceComponent = sentenceParcer.parse(sentence);
            paragraphComponent.add(sentenceComponent);
        }
        return paragraphComponent;
    }
}
