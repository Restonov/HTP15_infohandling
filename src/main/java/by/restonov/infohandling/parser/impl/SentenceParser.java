package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;

public class SentenceParser implements BaseParser {
    private static SentenceParser instance;
    private static final String LEXEME_DELIMITER = "\\s";
    private BaseParser lexemeParcer = LexemeParser.getInstance();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        if (instance == null) {
            instance = new SentenceParser();
        }
        return instance;
    }

    @Override
    public TextComponent parse(String text) {
        var sentence = new TextComposite(ComponentType.SENTENCE);
        String[] lexemes = text.split(LEXEME_DELIMITER);
        for (String lexeme : lexemes) {
            TextComponent lexemeComponent = lexemeParcer.parse(lexeme);
            sentence.add(lexemeComponent);
        }
        return sentence;
    }
}
