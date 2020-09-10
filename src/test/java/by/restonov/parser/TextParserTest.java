package by.restonov.parser;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Symbol;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.AbstractParser;
import by.restonov.infohandling.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextParserTest extends Assert {
    AbstractParser parser;
    TextComponent symbol1;
    TextComponent symbol2;
    TextComponent symbol3;
    TextComponent symbol4;
    TextComponent lexeme;
    TextComponent sentence;
    TextComponent paragraph;
    TextComponent text;

    @BeforeTest
    public void setUp() {
        parser = new TextParser();
        symbol1 = new Symbol('T');
        symbol2 = new Symbol('e');
        symbol3 = new Symbol('s');
        symbol4 = new Symbol('t');
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme.add(symbol1);
        lexeme.add(symbol2);
        lexeme.add(symbol3);
        lexeme.add(symbol4);
        sentence = new TextComposite(ComponentType.SENTENCE);
        sentence.add(lexeme);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        paragraph.add(sentence);
        text = new TextComposite(ComponentType.TEXT);
        text.add(paragraph);
    }

    @AfterTest
    public void tierDown() {
        parser = null;
        symbol1 = null;
        symbol2 = null;
        symbol3 = null;
        symbol4 = null;
        lexeme = null;
        sentence = null;
        paragraph = null;
        text = null;
    }

    @Test
    public void parseTextTest() {
        String expected = text.toString();
        String actual = parser.parse("Test").toString();
        AssertJUnit.assertEquals(expected, actual);
    }
}
