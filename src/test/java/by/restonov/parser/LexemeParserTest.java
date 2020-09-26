package by.restonov.parser;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;
import by.restonov.infohandling.parser.impl.LexemeParser;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LexemeParserTest extends Assert {
    BaseParser parser;
    TextComponent lexeme;

    @BeforeTest
    public void setUp() {
        parser = LexemeParser.getInstance();
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme.add(new Letter('T'));
        lexeme.add(new Letter('e'));
        lexeme.add(new Letter('s'));
        lexeme.add(new Letter('t'));
    }

    @AfterTest
    public void tierDown() {
        lexeme = null;
    }

    @Test
    public void lexemeParserTest() {
        String expected = lexeme.toString();
        String actual = parser.parse("Test").toString();
        assertEquals(expected, actual);
    }
}
