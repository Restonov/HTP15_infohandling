package by.restonov.infohandling.parser.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.AbstractParser;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

public class SentenceParser implements AbstractParser {
    private static final String LEXEME_DELIMITER = " ";
    private AbstractParser lexemeParcer = new LexemeParser();

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
