package by.restonov.infohandling.parser;

import by.restonov.infohandling.entity.TextComponent;

public interface AbstractParser {
    TextComponent parse(String text);
}
