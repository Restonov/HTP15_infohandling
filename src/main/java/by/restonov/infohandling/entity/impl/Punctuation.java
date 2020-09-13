package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;

import java.util.List;

public class Punctuation implements TextComponent {
    private char punctuation;
    private ComponentType componentType;

    public Punctuation(char punctuation) {
        this.punctuation = punctuation;
        this.componentType = ComponentType.PUNCTUATION;
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
        builder.append(punctuation);
        return builder.toString();
    }
}
