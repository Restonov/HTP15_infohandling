package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;

public class LexemeParser implements BaseParser {
    private static LexemeParser instance;
    public static final String LETTER_REGEX = "[a-zA-Z]";

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        if (instance == null) {
            instance = new LexemeParser();
        }
        return instance;
    }

    @Override
    public TextComponent parse(String lexeme) {
        var lexemeComponent = new TextComposite(ComponentType.LEXEME);
        char[] symbols = lexeme.toCharArray();
        TextComponent symbolComponent;
        for (char symbol : symbols) {
            if (String.valueOf(symbol).matches(LETTER_REGEX)) {
                symbolComponent = new Letter(symbol);
            } else {
                symbolComponent = new Punctuation(symbol);
            }
            lexemeComponent.add(symbolComponent);
        }
        return lexemeComponent;
    }
}