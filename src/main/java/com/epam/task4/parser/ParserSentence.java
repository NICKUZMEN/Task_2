package com.epam.task4.parser;

import com.epam.task4.entity.Word;
import com.epam.task4.interfaces.Parser;
import com.epam.task4.interfaces.TextElement;

import java.util.ArrayList;
import java.util.List;

public class ParserSentence implements Parser {

    @Override
    public List<TextElement> parse(String sentence) {
        List<TextElement> listWordObj;

        String[] tempWord = sentence.split("");
        listWordObj = new ArrayList<>();
        for (String word: tempWord) {
            listWordObj.add(new Word(word));
        }
        return listWordObj;
    }
}
