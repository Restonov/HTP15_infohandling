package by.restonov.evaluator;

import by.restonov.infohandling.evaluator.TextEvaluator;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

    public class TextEvaluatorTest extends Assert {
        TextEvaluator evaluator;
        String baseText;

        @BeforeTest
        public void setUp() {
            evaluator = new TextEvaluator();
            baseText = "5+3-6+(--j)";
        }

        @AfterTest
        public void tierDown() {
            evaluator = null;
            baseText = null;
        }

        @Test
        public void evaluateTest() {
            String expected = "5";
            String actual = evaluator.evaluate(baseText);
            AssertJUnit.assertEquals(expected, actual);
        }
    }
