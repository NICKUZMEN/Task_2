package com.epam.task4.util;

import com.epam.task4.entity.Text;
import com.epam.task4.interfaces.TextElement;
import com.epam.task4.parser.ParserText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {

public void Write() throws FileNotFoundException{
    String path = "assemblyFile.txt";

    File file = new File(path);
    PrintWriter pw = new PrintWriter(file);

    StringBuilder text = new StringBuilder();

    ParserText parserText = new ParserText();
    List<TextElement> listTextElementsBlock = parserText.parse(String.valueOf(text));
    Text assemblyText = new Text(listTextElementsBlock);

    pw.println(assemblyText.getValue());
    pw.close();

}
}
