package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;

import java.util.List;

public class Letter implements TextComponent {
    private char letter;
    private ComponentType componentType;

    public Letter(char letter) {
        this.letter = letter;
        this.componentType = ComponentType.LETTER;
    }

    @Override
    public boolean add(TextComponent text) {
        return false;
    }

    @Override
    public boolean remove(TextComponent text) {
        return false;
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append(letter);
        return builder.toString();
    }
}


