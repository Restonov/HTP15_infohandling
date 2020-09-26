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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punctuation that = (Punctuation) o;

        if (punctuation != that.punctuation) return false;
        return componentType == that.componentType;
    }

    @Override
    public int hashCode() {
        int result = punctuation;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }
}
