package com.epam.task4.parser;

import com.epam.task4.entity.CodeElement;
import com.epam.task4.interfaces.Parser;
import com.epam.task4.interfaces.TextElement;

import java.util.ArrayList;
import java.util.List;

public class ParserCode implements Parser {
    @Override
    public List<TextElement> parse(String codeBlock)  {
        List<TextElement> listCodeElement = new ArrayList<>();

        String[] tempCode = codeBlock.split("");
        for (String codeElement: tempCode) {
            listCodeElement.add(new CodeElement(codeElement));
        }
        return listCodeElement;
    }
}
