package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

import java.util.List;

public class Text implements TextElement {

    private List<TextElement> TextElementsBlocks;

    public Text(List<TextElement> textElementsBlocks) {
        TextElementsBlocks = textElementsBlocks;
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (TextElement it: TextElementsBlocks)
        {
            result.append(it.getValue());
        }
        return result.toString();
    }
}
