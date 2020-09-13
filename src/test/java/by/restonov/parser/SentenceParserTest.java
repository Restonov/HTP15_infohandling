package by.restonov.parser;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;
import by.restonov.infohandling.parser.impl.TextParser;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceParserTest extends Assert {
    BaseParser parser;
    TextComponent symbol1;
    TextComponent symbol2;
    TextComponent symbol3;
    TextComponent symbol4;
    TextComponent lexeme;
    TextComponent sentence;

    @BeforeTest
    public void setUp() {
        parser = TextParser.getInstance();
        symbol1 = new Letter('T');
        symbol2 = new Letter('e');
        symbol3 = new Letter('s');
        symbol4 = new Letter('t');
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme.add(symbol1);
        lexeme.add(symbol2);
        lexeme.add(symbol3);
        lexeme.add(symbol4);
        sentence = new TextComposite(ComponentType.SENTENCE);
        sentence.add(lexeme);
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
    }

    @Test
    public void parseTextTest() {
        String expected = sentence.toString();
        String actual = parser.parse("Test").toString();
        AssertJUnit.assertEquals(expected, actual);
    }
}
