package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

import java.util.List;

public class Code implements TextElement {

    private List<TextElement> listCodeElement;

    public Code(List<TextElement> listCodeElement) {
        this.listCodeElement = listCodeElement;
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for ( TextElement it: listCodeElement){

        result.append(it.getValue());
        }
        return result + "\n";
    }

}
