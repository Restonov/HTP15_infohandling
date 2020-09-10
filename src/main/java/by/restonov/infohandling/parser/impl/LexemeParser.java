package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Symbol;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.AbstractParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeParser implements AbstractParser {

    @Override
    public TextComponent parse(String text) {
        var lexeme = new TextComposite(ComponentType.LEXEME);
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            TextComponent symbolComponent = new Symbol(symbol);
            lexeme.add(symbolComponent);
        }
        return lexeme;
    }
}