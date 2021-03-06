package by.restonov.parser;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
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
    TextComponent lexeme;
    TextComponent sentence;

    @BeforeTest
    public void setUp() {
        parser = TextParser.getInstance();
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme.add(new Letter('T'));
        lexeme.add(new Letter('e'));
        lexeme.add(new Letter('s'));
        lexeme.add(new Letter('t'));
        lexeme.add(new Punctuation(' '));
        sentence = new TextComposite(ComponentType.SENTENCE);
        sentence.add(lexeme);
    }

    @AfterTest
    public void tierDown() {
        parser = null;
        lexeme = null;
        sentence = null;
    }

    @Test
    public void parseTextTest() {
        String expected = sentence.toString().concat("\n");
        String actual = parser.parse("Test").toString();
        assertEquals(expected, actual);
    }
}
