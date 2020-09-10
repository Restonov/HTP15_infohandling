package by.restonov.infohandling.entity;

import java.util.List;

public interface TextComponent {
    boolean add(TextComponent component);
    boolean remove(TextComponent component);
    ComponentType getComponentType();
    List<TextComponent> getComponents();
    String toString();
}
