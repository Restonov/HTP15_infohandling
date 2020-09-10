package by.restonov.interpreter;

import by.restonov.infohandling.interpreter.BaseInterpreter;
import by.restonov.infohandling.interpreter.impl.TextInterpreter;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextInterpreterTest extends Assert {
    BaseInterpreter interpreter;
    String baseText;

    @BeforeTest
    public void setUp() {
        interpreter = new TextInterpreter();
        baseText = "5+3-6+(--j)";
    }

    @AfterTest
    public void tierDown() {
        interpreter = null;
        baseText = null;
    }

    @Test
    public void interpretTest() {
        String expected = "5";
        String actual = interpreter.interpret(baseText);
        AssertJUnit.assertEquals(expected, actual);
    }
}
