package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

import java.util.List;

public class Paragraph implements TextElement {

     List<TextElement> listSentence;

    public Paragraph(List<TextElement> listSentence) {
        this.listSentence = listSentence;
    }

    public List<TextElement> getListSentence() {
        return listSentence;
    }

    public void setListSentence(List<TextElement> listSentence) {
        this.listSentence = listSentence;
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (TextElement it: listSentence) {
            result.append(it.getValue());
        }
        return result.toString();
    }
}
