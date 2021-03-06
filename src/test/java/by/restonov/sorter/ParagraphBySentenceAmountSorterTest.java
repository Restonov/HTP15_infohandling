package by.restonov.sorter;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.sorter.BaseSorter;
import by.restonov.infohandling.sorter.impl.ParagraphBySentenceAmountSorter;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphBySentenceAmountSorterTest extends Assert {
    BaseSorter sorter;
    TextComponent lexeme;
    TextComponent sentence;
    TextComponent paragraph;
    TextComponent paragraph2;
    TextComponent text;

    @BeforeTest
    public void setUp() {
        sorter = new ParagraphBySentenceAmountSorter();
        lexeme = new TextComposite(ComponentType.LEXEME);
        sentence = new TextComposite(ComponentType.SENTENCE);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);
        paragraph2 = new TextComposite(ComponentType.PARAGRAPH);
        text = new TextComposite(ComponentType.TEXT);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('b'));
        lexeme.add(new Letter('c'));
        sentence.add(lexeme);
        paragraph.add(sentence);
        paragraph2.add(sentence);
        paragraph2.add(sentence);
        text.add(paragraph);
        text.add(paragraph2);
    }

    @AfterTest
    public void tierDown() {
        sorter = null;
        lexeme = null;
        sentence = null;
        paragraph = null;
        paragraph2 = null;
        text = null;
    }

    @Test
    public void sortTest() {
       String expected = " abc \n abc  abc ";
       String actual = sorter.sort(text);
       AssertJUnit.assertEquals(expected, actual);
    }
}
