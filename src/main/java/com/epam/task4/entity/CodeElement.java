package com.epam.task4.entity;

import com.epam.task4.interfaces.TextElement;

public class CodeElement implements TextElement {

    private String value;

    public CodeElement(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value + "";
    }
}
