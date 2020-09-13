package by.restonov.sorter;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.parser.BaseParser;
import by.restonov.infohandling.parser.impl.TextParser;
import by.restonov.infohandling.sorter.BaseSorter;
import by.restonov.infohandling.sorter.impl.ParagraphBySentenceAmountSorter;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ParagraphBySentenceAmountSorterTest extends Assert{
        BaseSorter sorter;
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
            sorter = new ParagraphBySentenceAmountSorter();
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
            paragraph = new TextComposite(ComponentType.PARAGRAPH);
            paragraph.add(sentence);
            text = new TextComposite(ComponentType.TEXT);
            text.add(paragraph);
        }

        @AfterTest
        public void tierDown() {
            sorter = null;
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
        public void sorterTest() {
            String expected = " Test ";
            String actual = sorter.sort(text);
            AssertJUnit.assertEquals(expected, actual);
        }
    }
