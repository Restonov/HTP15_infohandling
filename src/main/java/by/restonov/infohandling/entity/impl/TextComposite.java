package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.ComponentType;
import by.restonov.infohandling.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private static final int PARAGRAPH_INDEX = 1;
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
    public TextComponent getChild(TextComponent component) {
        switch (component.getComponentType()) {
            case TEXT: return components.get(PARAGRAPH_INDEX);
        }
        return null;
    }

    @Override
    public String toString() {
            StringBuilder sb = new StringBuilder();
            for (TextComponent component : components) {
                switch (component.getComponentType()) {
                    case TEXT:
                    case WORD:
                    case LEXEME:
                        sb.append(component.toString()).append(" ");
                        break;
                    case PARAGRAPH:
                        sb.append(component.toString()).append("\n");
                        break;
                    case SYMBOL:
                    case SENTENCE:
                        sb.append(component.toString());
                        break;
                    default: sb.append(" ");
                }
            }
            return sb.toString();
        }
}

