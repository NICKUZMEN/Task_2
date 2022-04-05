package com.epam.task4.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public Scanner Read() throws FileNotFoundException {

        String path = "text.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);


        return scanner;
    }
}
