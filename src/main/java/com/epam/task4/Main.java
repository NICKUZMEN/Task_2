package com.epam.task4;

import com.epam.task4.entity.Text;
import com.epam.task4.interfaces.TextElement;
import com.epam.task4.parser.ParserText;
import com.epam.task4.util.Writer;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Writer writer = new Writer();
        writer.Write();
    }
}
