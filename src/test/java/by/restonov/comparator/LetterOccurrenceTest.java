package by.restonov.comparator;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
import by.restonov.infohandling.entity.impl.TextComposite;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LetterOccurrenceTest extends Assert {
    TextComponent lexeme;
    TextComponent notEqualsLexeme;

    @BeforeClass
    public void setUp() {
        lexeme = new TextComposite(ComponentType.LEXEME);
        notEqualsLexeme = new TextComposite(ComponentType.LEXEME);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('b'));
        lexeme.add(new Punctuation(','));
        notEqualsLexeme.add(new Letter('x'));
        TextComparator.setSymbol('a');
    }

    @AfterClass
    public void tierDown() {
        lexeme = null;
        notEqualsLexeme = null;
    }

    @Test
    public void compareByLetterOccurrencePositiveTest() {
        int actual = TextComparator.SYMBOL_OCCURRENCE.compare(lexeme, lexeme);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareByLetterOccurrenceNegativeTest() {
        int actual = TextComparator.SYMBOL_OCCURRENCE.compare(lexeme, notEqualsLexeme);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
