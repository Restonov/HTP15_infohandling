package by.restonov.sorter;

import by.restonov.infohandling.comparator.TextComparator;
import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.sorter.BaseSorter;
import by.restonov.infohandling.sorter.impl.SentenceBySymbolOccurrence;
import by.restonov.infohandling.sorter.impl.SentenceByWordSorter;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SentenceBySymbolOccurrenceSorterTest extends Assert {
    BaseSorter sorter;
    TextComponent lexeme;
    TextComponent lexeme2;
    TextComponent lexeme3;
    TextComponent sentence;

    @BeforeTest
    public void setUp() {
        sorter = new SentenceBySymbolOccurrence();
        lexeme = new TextComposite(ComponentType.LEXEME);
        lexeme2 = new TextComposite(ComponentType.LEXEME);
        lexeme3 = new TextComposite(ComponentType.LEXEME);
        sentence = new TextComposite(ComponentType.SENTENCE);
        TextComparator.setSymbol('a');

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('c'));
        lexeme2.add(new Letter('b'));
        lexeme2.add(new Letter('b'));
        lexeme2.add(new Letter('b'));
        lexeme3.add(new Letter('a'));
        lexeme3.add(new Letter('r'));
        sentence.add(lexeme);
        sentence.add(lexeme2);
        sentence.add(lexeme3);
    }

    @AfterTest
    public void tierDown() {
        sorter = null;
        lexeme = null;
        lexeme2 = null;
        lexeme3 = null;
        sentence = null;
    }

    @Test
    public void sortTest() {
       String expected = "aac ar bbb";
       String actual = sorter.sort(sentence);
       AssertJUnit.assertEquals(expected, actual);
    }
}
