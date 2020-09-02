package by.restonov.infohandling.entity.impl;

import by.restonov.infohandling.entity.IText;

public class TextCharacter implements IText {
    private String textCharacter;

    public TextCharacter(String textCharacter) {
        this.textCharacter = textCharacter;
    }

    @Override
    public void addElement(IText text) {

    }

    @Override
    public void removeElement(IText text) {

    }

    @Override
    public IText getElement(int index) {
        return this;
    }
}
