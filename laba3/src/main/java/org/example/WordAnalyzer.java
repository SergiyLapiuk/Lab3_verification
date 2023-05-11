package org.example;

import java.util.ArrayList;

public class WordAnalyzer {
    // Функція, що повертає слова з
    // найдовшим підланцюжком приголосних літер
    public static ArrayList<String> getWordWithLargestSubstring(ArrayList<String> words)
    {
        ArrayList<String> arrayListResult = new ArrayList<>();
        int chain_length = 0;
        int chain_lenght_max = 0;

        for (String word : words)
        {
            chain_length = longestConsonant(word);

            if(chain_length == chain_lenght_max && !arrayListResult.contains(word)) {
                arrayListResult.add(word);
            }
            if(chain_length > chain_lenght_max && !arrayListResult.contains(word)) {
                arrayListResult.clear();
                arrayListResult.add(word);
            }
            chain_lenght_max = Math.max(chain_lenght_max, chain_length);
        }
        return  arrayListResult;
    }

    //перевіряєио чи є літреа приголосною
    public static boolean isConsonant(char c)
    {
        return !(c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u' || c == 'y');
    }

    // Знаходимо довжину найдовшого підланцюжка
    // приголосних літер
    public static int longestConsonant(String str)
    {
        int count = 0, res = 0;
        char[] s = str.toCharArray();

        for (int i = 0; i < s.length; i++)
        {
            //  Якщо s [i] приголосна літера збільшуємо лічильник на 1
            if (isConsonant(s[i]))
                count++;
            else
            {
                count = 0;
            }
            // порівнюємо з попереднім результатом та обираємо більший
            res = Math.max(res, count);
        }
        return res;
    }
}
