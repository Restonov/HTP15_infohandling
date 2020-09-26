package by.restonov.comparator;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
import by.restonov.infohandling.entity.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.*;

public class SentenceAmountTest extends Assert {
    TextComponent lexeme;
    TextComponent sentence;
    TextComponent equalParagraph1;
    TextComponent equalParagraph2;
    TextComponent notEqualParagraph;

    @BeforeClass
    public void setUp() {
        lexeme = new TextComposite(ComponentType.LEXEME);
        sentence = new TextComposite(ComponentType.SENTENCE);
        equalParagraph1 = new TextComposite(ComponentType.PARAGRAPH);
        equalParagraph2 = new TextComposite(ComponentType.PARAGRAPH);
        notEqualParagraph = new TextComposite(ComponentType.PARAGRAPH);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('b'));
        lexeme.add(new Punctuation(','));
        sentence.add(lexeme);
        equalParagraph1.add(sentence);
        equalParagraph2.add(sentence);
        notEqualParagraph.add(sentence);
        notEqualParagraph.add(sentence);
    }

    @AfterClass
    public void tierDown() {
        lexeme = null;
        sentence = null;
        equalParagraph1 = null;
        equalParagraph2 = null;
        notEqualParagraph = null;
    }

    @Test
    public void compareBySentenceAmountPositiveTest() {
        int actual = TextComparator.SENTENCES_AMOUNT.compare(equalParagraph1, equalParagraph2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareBySentenceAmountNegativeTest() {
        int actual = TextComparator.SENTENCES_AMOUNT.compare(equalParagraph1, notEqualParagraph);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
