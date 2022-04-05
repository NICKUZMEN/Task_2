package com.epam.task4.parser;

import com.epam.task4.entity.Paragraph;
import com.epam.task4.entity.Sentence;
import com.epam.task4.interfaces.Parser;
import com.epam.task4.interfaces.TextElement;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements Parser {
    private static final String REG_PARAGRAPH = ".+(\\.|:)$";
    private static final String REG_SENTENCE = ".+(:)$";
    private static final String REG_NUMBER = "^[1].+";
    private static final String REG_CODE = "^\\}.*";

    Parser parseSentence = new ParserSentence();

    @Override
    public List<TextElement> parse(String paragraph) throws FileNotFoundException {

        List<String> listSentence = new ArrayList<>();

        List<TextElement> listSentencesObj = new ArrayList<>();

        if (paragraph.matches(REG_NUMBER) || paragraph.matches(REG_PARAGRAPH)) {
            listSentence.add(paragraph);
        } else {
            String temp;
            String[] tempArr = paragraph.split("((\\.\\s))");
            for (int i = 0; i < tempArr.length; i++) {
                if (i == tempArr.length - 1) {
                    temp = tempArr[i];
                } else {
                    temp = tempArr[i] + "\n";
                }
                listSentence.add(temp);
            }
        }

        for (String sentence : listSentence) {

            List<TextElement> listWordObj = parseSentence.parse(sentence);

            listSentencesObj.add(new Sentence(listWordObj));
        }
        return listSentencesObj;
    }

}
