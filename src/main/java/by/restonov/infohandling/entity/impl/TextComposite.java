package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components = new ArrayList<>();
    private ComponentType componentType;

    public TextComposite(ComponentType componentType) {
        this.componentType = componentType;
    }

    @Override
    public boolean add(TextComponent component) {
        return components.add(component);
    }

    @Override
    public boolean remove(TextComponent component) {
        return components.remove(component);
    }

    @Override
    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public String toString() {
            var builder = new StringBuilder();
            for (TextComponent component : components) {
                ComponentType type = component.getComponentType();
                if (type == ComponentType.LEXEME) {
                    builder.append(" ");
                }
                builder.append(component);
                if (type == ComponentType.SENTENCE) {
                    builder.append(" ");
                } else if (type == ComponentType.PARAGRAPH) {
                    builder.append("\n");
                }
            }
            return builder.toString();
        }
}

