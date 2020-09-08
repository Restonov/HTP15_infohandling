package by.restonov.infohandling.entity;

import by.restonov.infohandling.exception.WrongOperationException;

public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    ComponentType getComponentType();
    TextComponent getChild(TextComponent component) throws WrongOperationException;
    String toString();
}
