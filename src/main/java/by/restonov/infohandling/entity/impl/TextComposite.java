package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.IText;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements IText {
    private List<IText> text = new ArrayList<>();

    @Override
    public void addElement(IText text) {
        this.text.add(text);
    }

    @Override
    public void removeElement(IText text) {
        this.text.remove(text);
    }

    @Override
    public IText getElement(int index) {
        return text.get(index);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TextComposite{");
        sb.append("text=").append(text);
        sb.append('}');
        return sb.toString();
    }
}
