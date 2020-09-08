package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.AbstractParser;

public class TextParser implements AbstractParser {
    private static final String PARAGRAPH_DELIMITER = "\\n";
    private AbstractParser paragraphParser = new ParagraphParser();

    @Override
    public TextComponent parse(String text) {
        var textComponent = new TextComposite(ComponentType.TEXT);
        String[] paragraphs = text.split(PARAGRAPH_DELIMITER);
        for (String paragraph: paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
