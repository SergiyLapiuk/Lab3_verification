package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
        WordAnalyzer wordanalyzer = new WordAnalyzer();
        ProcessFile file = new ProcessFile();
        // Знаходимо результат та виводимо його
        ArrayList<String> res = wordanalyzer.getWordWithLargestSubstring(file.getWords());
            for (String word : res)
            {
                System.out.print(word + ";\n");
            }
    }
}