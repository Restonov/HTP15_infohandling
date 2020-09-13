package by.restonov.infohandling.evaluator;

import by.restonov.infohandling.exception.CustomProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextEvaluator {
    static Logger logger = LogManager.getLogger();
    private static int variableI = 5;
    private static int variableJ = 4;
    private static final String AT_LEAST_ONE_DIGIT = ".*\\d+.*";
    private static final String DELIMITER = " ";

    public String evaluate(String text){
        String context = Stream.of(text.split(DELIMITER))
                .map(TextEvaluator::replaceVariable)
                .map(s ->
                        {
                            String result = null;
                            try {
                                result = calculateExpression(s);
                            } catch (CustomProjectException e) {
                                e.printStackTrace();
                            }
                            return result;
                        }
                )
                .collect(Collectors.joining(DELIMITER));
        return context;
    }

    private static String replaceVariable(String unchecked) {
        String checked = unchecked;
        if (unchecked.contains("i--")) {
            checked = unchecked.replace("i--",String.valueOf(variableI));
            variableI--;
            logger.log(Level.INFO, "Variable i-- replaced successfully");
            checked = replaceVariable(checked);
        } else if (unchecked.contains("++i")){
            variableI++;
            checked = unchecked.replace("++i",String.valueOf(variableI));
            logger.log(Level.INFO, "Variable ++i replaced successfully");
        } else if (unchecked.contains("--j")) {
            variableJ--;
            checked = unchecked.replace("--j",String.valueOf(variableJ));
            logger.log(Level.INFO, "Variable --j replaced successfully");
        }
        return checked;
    }

    private static String calculateExpression(String text) throws CustomProjectException {
        Object result = text;
        if (text.matches(AT_LEAST_ONE_DIGIT)) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            try {
                result = engine.eval(text);
            } catch (ScriptException e) {
                logger.error("ScriptEngine error", e);
                throw new CustomProjectException("ScriptEngine error", e);
            }
        }
        return String.valueOf(result);
    }
}