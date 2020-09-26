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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Letter letter1 = (Letter) o;

        if (letter != letter1.letter) return false;
        return componentType == letter1.componentType;
    }

    @Override
    public int hashCode() {
        int result = letter;
        result = 31 * result + (componentType != null ? componentType.hashCode() : 0);
        return result;
    }
}


