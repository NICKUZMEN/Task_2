package com.epam.task4.interfaces;

import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {

    List<TextElement> parse(String text) throws FileNotFoundException;
}
