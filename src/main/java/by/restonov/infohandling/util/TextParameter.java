package by.restonov.infohandling.util;

import by.restonov.infohandling.entity.TextComponent;

import java.util.List;

public class TextParameter {

    public static int getLexemesLength(TextComponent paragraphComponent) {
        int length = 0;
        List<TextComponent> sentences = paragraphComponent.getComponents();
        for (TextComponent sentence : sentences) {
            int symbolAmount = sentence.getComponents().size();
            length += symbolAmount;
        }
        return length;
    }

    public static int getParagraphSize(TextComponent paragraphComponent) {
        List<TextComponent> paragraph = paragraphComponent.getComponents();
        return paragraph.size();
    }
}
