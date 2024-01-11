package Adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ElfRucksackDayThreeTest {
    @Test
    public void Compartments_test() {
        ElfRucksackDayThree elfRucksackDayThree = new ElfRucksackDayThree();
        ArrayList<String> lines = new ArrayList<>(Arrays.asList("abcdeedcba", "fghijjihgf"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("[a, b, c, d, e]", "[f, g, h, i, j]"));
        Assertions.assertEquals(expected, elfRucksackDayThree.Compartments(lines));
    }

    @Test
    public void testMapValues_test() {
        ElfRucksackDayThree elfRucksackDayThree = new ElfRucksackDayThree();
        ArrayList<String> sortedLines = new ArrayList<>(Arrays.asList("[a, b, c, d, e]", "[f, g, h, i, j]"));
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), i + 1);
            map.put((char) ('A' + i), i + 27);
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(15, 40));
        Assertions.assertEquals(expected, elfRucksackDayThree.mapValues(sortedLines, map));
    }

    @Test
    public void testSumOfValues_test() {
        ElfRucksackDayThree elfRucksackDayThree = new ElfRucksackDayThree();
        ArrayList<Integer> values = new ArrayList<>(Arrays.asList(15, 40));
        int expected = 55;
        Assertions.assertEquals(expected, elfRucksackDayThree.sumOfValues(values));
    }
}
