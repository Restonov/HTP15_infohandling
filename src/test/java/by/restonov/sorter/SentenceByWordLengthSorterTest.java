package by.restonov.sorter;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.sorter.BaseSorter;
import by.restonov.infohandling.sorter.impl.SentenceByLexemeSorter;
import by.restonov.infohandling.sorter.impl.SentenceByWordSorter;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceByWordLengthSorterTest extends Assert {
    BaseSorter sorter;
    TextComponent lexeme;
    TextComponent lexeme2;
    TextComponent sentence;
    TextComponent sentence2;
    TextComponent paragraph;

    @BeforeTest
    public void setUp() {
        sorter = new SentenceByWordSorter();
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme2 = new TextComposite(ComponentType.LEXEME);
        sentence = new TextComposite(ComponentType.SENTENCE);
        sentence2 = new TextComposite(ComponentType.SENTENCE);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('b'));
        lexeme.add(new Letter('c'));
        lexeme2.add(new Letter('a'));
        lexeme2.add(new Letter('b'));
        lexeme2.add(new Letter('c'));
        lexeme2.add(new Letter('d'));
        sentence.add(lexeme);
        sentence2.add(lexeme);
        sentence2.add(lexeme2);
        paragraph.add(sentence);
        paragraph.add(sentence2);
    }

    @AfterTest
    public void tierDown() {
        sorter = null;
        lexeme = null;
        lexeme2 = null;
        sentence = null;
        sentence2 = null;
        paragraph = null;
    }

    @Test
    public void sortTest() {
       String expected = " abc abc abcd";
       String actual = sorter.sort(paragraph);
       AssertJUnit.assertEquals(expected, actual);
    }
}
