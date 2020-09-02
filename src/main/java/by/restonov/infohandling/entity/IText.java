package by.restonov.infohandling.entity;

public interface IText {
    void addElement(IText text);
    void removeElement(IText text);
    IText getElement(int index);
}
