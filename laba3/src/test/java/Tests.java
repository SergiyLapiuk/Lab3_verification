
import org.example.ProcessFile;
import org.example.WordAnalyzer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import java.util.ArrayList;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class Tests {

    @Mock
    ProcessFile mockFileService;

    @InjectMocks
    WordAnalyzer injectedWorld;

    @Spy
    WordAnalyzer wordAnalyzer = new WordAnalyzer();

    @BeforeMethod
    public void setUp() {
        words = new ArrayList<>();
        words.add("cat");
        words.add("dog");
        words.add("fish");
        words.add("elephant");
        words.add("lion");
        words.add("tiger");
    }

    @Test(groups = {"longestSubstring"})
    public void testGetWordWithLargestSubstring() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("fish");
        expected.add("elephant");
        assertEquals(expected, Main.getWordWithLargestSubstring(words));
    }

    @Test(groups = {"cutting"})
    public void testCutWord() {
        String[] words = new String[]{"apple", "banana", "kiwi", "pineapple"};
        String[] expected = new String[]{"apple", "banana", "kiwi", "pineapple"};
        Main.cutWord(words);
        String[] actual = new String[]{"apple", "banana", "kiwi", "pineapple"};
        assertArrayEquals(expected, actual);
    }

    @Test(groups = {"cutting"})
    public void UsingCutWord() {
        String[] words = new String[]{"dipalmitoylphosphatidylcholineaceton"};
        Main.cutWord(words);
        assertEquals(words[0].length(), 30);
    }

    @Test(groups = {"cutting"})
    public void testCutWordLongWordsArray() {
        String[] words = new String[]{"dipalmitoylphosphatidylcholineaceton",
                "Anotherdipalmitoylphosphatidylcholine"};
        String[] expected = new String[]{"dipalmitoylphosphatidylcholine", "Anotherdipalmitoylphosphatidyl"};
        Main.cutWord(words);
        assertArrayEquals(expected, words);
    }



    @Test(groups = {"longestSubstring"})
    public void testGetWordWithLargestSubstringAssertTrue() {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "pear", "grapefruit"));
        ArrayList<String> result = Main.getWordWithLargestSubstring(words);
        Assert.assertTrue(result.contains("apple"));
    }
    @AfterMethod
    public void tearDown() {
        System.out.println("...");
        words = null;
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("...");
    }

    @AfterSuite
    public void tearDownAll() {
        System.out.println("All tests completed.");
    }

}