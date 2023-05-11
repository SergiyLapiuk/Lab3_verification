package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProcessFile {

    public ArrayList<String> getWords() {
        try {
            //Відкриття файлу
            Scanner scanner = new Scanner(System.in);
            String path = "C:\\Users\\acer\\Desktop\\laba3\\laba3\\input.txt";
            java.io.File myFile = new java.io.File(path);
            Scanner Reader = new Scanner(myFile);

            //Колекція для зберігання слів із вхідного файлу
            ArrayList<String> words = new ArrayList<>();

            while (Reader.hasNextLine()) {
                String line = Reader.nextLine();

                //Розбиваємо рядок на слова. Роздільником є будь-який
                //символ, окрім букв та цифр
                String[] wordsInLine = line.split("[^a-zA-Z0-9]");//"[^[a-zA-Z]]"
                // Зменшуємо довжину надто великих слів
                this.cutWord(wordsInLine);
                words.addAll(Arrays.asList(wordsInLine));
            }
            Reader.close();
            return words;
            } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
    public  String[] cutWord(String[] words)
    {
        for (int i = 0; i < words.length; ++i)
        {
            if(words[i].length() > 30) words[i] = words[i].substring(0, 30);

        }
        return words;
    }
}
