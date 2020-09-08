package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;
import by.restonov.infohandling.exception.WrongOperationException;

public class Symbol implements TextComponent {
    private char symbol;
    private ComponentType componentType;

    public Symbol(char symbol) {
        this.symbol = symbol;
        componentType = ComponentType.SYMBOL;
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
    public TextComponent getChild(TextComponent component) throws WrongOperationException {
        throw new WrongOperationException();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append(symbol);
        return sb.toString();
    }
}


