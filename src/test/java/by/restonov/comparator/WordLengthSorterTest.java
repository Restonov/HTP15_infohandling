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

public class WordLengthSorterTest extends Assert {
    TextComponent lexeme;
    TextComponent lexeme2;
    TextComponent equalSentence1;
    TextComponent equalSentence2;
    TextComponent notEqualSentence;

    @BeforeClass
    public void setUp() {
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme2 = new TextComposite(ComponentType.LEXEME);
        equalSentence1 = new TextComposite(ComponentType.SENTENCE);
        equalSentence2 = new TextComposite(ComponentType.SENTENCE);
        notEqualSentence = new TextComposite(ComponentType.SENTENCE);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('b'));
        lexeme.add(new Punctuation(','));
        lexeme2.add(new Letter('x'));
        equalSentence1.add(lexeme);
        equalSentence2.add(lexeme);
        notEqualSentence.add(lexeme2);
    }


    @AfterClass
    public void tierDown() {
        lexeme = null;
        equalSentence1 = null;
        equalSentence2 = null;
        notEqualSentence = null;
    }

    @Test
    public void compareByWordLengthPositiveTest() {
        int actual = TextComparator.WORD_LENGTH.compare(equalSentence1, equalSentence2);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void compareByWordLengthNegativeTest() {
        int actual = TextComparator.WORD_LENGTH.compare(equalSentence1, notEqualSentence);
        int expected = 0;
        assertNotEquals(actual, expected);
    }
}
