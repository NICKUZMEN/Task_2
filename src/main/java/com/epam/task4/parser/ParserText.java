package com.epam.task4.parser;

import com.epam.task4.entity.Code;
import com.epam.task4.entity.Paragraph;
import com.epam.task4.interfaces.Parser;
import com.epam.task4.interfaces.TextElement;
import com.epam.task4.util.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParserText implements Parser {

    Parser parserParagraph = new ParagraphParser();
    Parser parserCode = new ParserCode();

    private static final String REG_PARAGRAPH = ".+(\\.|:)$";
    private static final String REG_SENTENCE = ".+(:)$";
    private static final String REG_NUMBER = "^[1].+";
    private static final String REG_CODE = "^\\}.*";

    @Override
    public List<TextElement> parse(String text) throws FileNotFoundException {

        Reader reader = new Reader();
        Scanner sc = reader.Read();

        List<String> listTextBlock = new ArrayList<>();
        String temp;

        StringBuilder tempResult = new StringBuilder();

        while (sc.hasNextLine()) {

            temp = sc.nextLine();
            if (temp.matches(REG_NUMBER)) {
                listTextBlock.add(temp);
                continue;
            }

            if (temp.matches(REG_PARAGRAPH) || temp.matches(REG_CODE)) {
                tempResult = new StringBuilder(tempResult + temp);

                listTextBlock.add(String.valueOf(tempResult));
                tempResult = new StringBuilder();
                continue;
            }

            if (tempResult.equals("")) {
                tempResult = new StringBuilder(temp + "\n");
            } else {
                tempResult = new StringBuilder(tempResult + temp + "\n");
            }
        }

//        for (String s : listTextBlock) {
//            System.out.println(s);
//            System.out.println("+++++++++++++++++++++");
//        }

        List<TextElement> listTextElementObj = new ArrayList<>();

        for (String textBlock : listTextBlock) {
            if (textBlock.substring(0, 10).matches("^(void|\\nclass)(\\}.*)")) {

                List<TextElement> listCodeElementObj = parserCode.parse(textBlock);

                listCodeElementObj.add(new Code(listCodeElementObj));

            } else {

                List<TextElement> listSentencesObj = parserParagraph.parse(textBlock);

                listTextElementObj.add(new Paragraph(listSentencesObj));
            }
        }
        sc.close();
        return listTextElementObj;
    }
}
