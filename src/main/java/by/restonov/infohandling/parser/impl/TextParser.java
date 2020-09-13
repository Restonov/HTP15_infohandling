package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextParser implements BaseParser {
    private static TextParser instance;
    private static final String PARAGRAPH_DELIMITER = "\\s{3}";
    private BaseParser paragraphParser = ParagraphParser.getInstance();

    private TextParser() {
    }

    public static TextParser getInstance() {
        if (instance == null) {
            instance = new TextParser();
        }
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        var textComponent = new TextComposite(ComponentType.TEXT);
        String[] paragraphs = text.strip().split(PARAGRAPH_DELIMITER);
        for (String paragraph: paragraphs) {
            TextComponent paragraphComponent = paragraphParser.parse(paragraph);
            textComponent.add(paragraphComponent);
        }
        return textComponent;
    }
}
