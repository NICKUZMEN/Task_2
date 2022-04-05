package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

public class Word implements TextElement {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value + "";
    }
}
