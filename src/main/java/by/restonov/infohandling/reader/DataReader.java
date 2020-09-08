package by.restonov.infohandling.reader;

import by.restonov.infohandling.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {

    public String readData(String dataPath) throws DataReaderException {

        Path path = null;
        Stream<String> lines = null;
        String data = null;

        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource(dataPath).toURI());
            lines = Files.lines(path);
            data = lines.collect(Collectors.joining("\n"));
            lines.close();
        } catch (URISyntaxException | IOException e) {
            throw new DataReaderException("File reading error", e);
        }
        return data;
    }
}

