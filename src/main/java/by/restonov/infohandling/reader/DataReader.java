package by.restonov.infohandling.reader;

import by.restonov.infohandling.exception.DataReaderException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReader {
    public static final String PARAGRAPH_DELIMITER = "\n";
    static Logger logger = LogManager.getLogger(DataReader.class);

    public String read(final String dataPath) throws DataReaderException {

        Path path = null;
        Stream<String> lines = null;
        String data = null;

        try {
            path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(dataPath)).toURI());
            lines = Files.lines(path);
            data = lines.collect(Collectors.joining(PARAGRAPH_DELIMITER));
            lines.close();
        } catch (URISyntaxException | IOException e) {
            logger.error("File reading error", e);
            throw new DataReaderException("File reading error", e);
        } finally {
            assert lines != null;
            lines.close();
        }
        return data;
    }
}
