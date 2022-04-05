package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

import java.util.List;

public class Sentence implements TextElement {

    List<TextElement> wordList;

    public Sentence(List<TextElement> wordList) {
        this.wordList = wordList;
    }

    @Override
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (TextElement it:wordList)
        {
        result.append(it.getValue());
        }
        return result.toString();
    }
}
