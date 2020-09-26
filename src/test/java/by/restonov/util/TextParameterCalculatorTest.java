package by.restonov.util;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.entity.impl.Letter;
import by.restonov.infohandling.entity.impl.Punctuation;
import by.restonov.infohandling.entity.impl.TextComposite;
import by.restonov.infohandling.util.TextParameterCalculator;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextParameterCalculatorTest extends Assert {
    TextParameterCalculator calculator;
    TextComponent lexeme;
    TextComponent sentence;
    TextComponent paragraph;

    @BeforeClass
    public void setUp() {
        calculator = new TextParameterCalculator();
        lexeme = new TextComposite(ComponentType.LEXEME);
        sentence = new TextComposite(ComponentType.SENTENCE);
        paragraph = new TextComposite(ComponentType.PARAGRAPH);

        lexeme.add(new Letter('a'));
        lexeme.add(new Letter('y'));
        lexeme.add(new Punctuation(';'));
        sentence.add(lexeme);
        paragraph.add(sentence);
    }

    @AfterClass
    public void tierDown() {
        calculator = null;
        lexeme = null;
        sentence = null;
        paragraph = null;
    }

    @Test
    public void findLexemesLengthTest() {
        int expected = 3;
        int actual = TextParameterCalculator.findLexemesLength(sentence);
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void findParagraphSizeTest() {
        int expected = 1;
        int actual = TextParameterCalculator.findParagraphSize(paragraph);
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void findWordsLengthTest() {
        int expected = 2;
        int actual = TextParameterCalculator.findWordsLength(sentence);
        AssertJUnit.assertEquals(expected, actual);
    }

    @Test
    public void findSymbolOccurrenceTest() {
        int expected = 1;
        int actual = TextParameterCalculator.findLetterOccurrence(lexeme, 'a');
        AssertJUnit.assertEquals(expected, actual);
    }
}
