package by.restonov.reader;

import by.restonov.infohandling.exception.DataReaderException;
import by.restonov.infohandling.reader.DataReader;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataReaderTest extends Assert {
    DataReader dataReader;

    @BeforeTest
    public void setUp() {
        dataReader = new DataReader();
    }

    @AfterTest
    public void tierDown() {
        dataReader = null;
    }

    @Test
    public void readDataTest() {
        String expected = "Test string";
        String actual = null;
        try {
            actual = dataReader.read("data/sourceTextTest.txt");
        } catch (DataReaderException e) {
            e.printStackTrace();
        }
        AssertJUnit.assertEquals(expected, actual);
    }
}
