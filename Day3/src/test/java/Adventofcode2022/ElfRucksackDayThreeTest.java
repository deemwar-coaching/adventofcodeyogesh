package Adventofcode2022;
//rules
//elf ruck sack filled with random elements
//rucksack arraylist n/2 compare to find commmon elements
//a to z keys 1 to 26
//A to z keys 27 to 52
//upper case and lowercase are different elements
//values are considered as priorities, sum is the total priority
//find total priority
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElfRucksackDayThreeTest {
    private ElfRucksackDayThree sorterobj;

    @BeforeEach
    void setUp() {
        sorterobj = new ElfRucksackDayThree();
    }

@Test
void  add_values(){

        int x=1+2+27+28+29;
        System.out.println(x);
    }
    @Test
    void test_HashMap() {
        ArrayList<String> sortedLines = new ArrayList<>();
        sortedLines.add("[a, b, A, B, C]");
        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('a', 1);
        priorityMap.put('b', 2);
        priorityMap.put('A', 27);
        priorityMap.put('B', 28);
        priorityMap.put('C', 29);

        ArrayList<Integer> values = sorterobj.mapValues(sortedLines, priorityMap);

        assertEquals("[87]", values.toString());
    }

    @Test
    void test_Sum_of_priorities() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(5);
        values.add(10);
        values.add(15);

        int sum = sorterobj.sumOfValues(values);

        assertEquals(30, sum);
    }

    @Test
    void test_ElfGroupSorting() {
        ArrayList<String> inputLines = new ArrayList<>();
        inputLines.add("abc");
        inputLines.add("def");
        inputLines.add("ghi");
        inputLines.add("jal");
        inputLines.add("ABB");
        inputLines.add("Def");

        ArrayList<ArrayList<String>> groups = sorterobj.elfGroupSorting(inputLines);

        assertEquals(2, groups.size());

        assertEquals("[[abc, def, ghi], [jal, ABB, Def]]", groups.toString());
    }


    @Test
    public void test_Common_elements() {
        String firstString = "abc";
        String secondString = "ECDa";
        String thirdString = "ABa";

        ArrayList<Character> expected = new ArrayList<>(Arrays.asList('a'));
        ArrayList<Character> commonChars = new ArrayList<>();
        for (char c : firstString.toCharArray()) {
            if (secondString.indexOf(c) != -1 && thirdString.indexOf(c) != -1 && !commonChars.contains(c)) {
                commonChars.add(c);
            }
        }
        assertEquals(expected, commonChars, "the common element in sublist is[a]");
    }

    @Test
    void test_MapGroupValues() {
        ArrayList<ArrayList<Character>> elfGroups = new ArrayList<>();
        ArrayList<Character> group1 = new ArrayList<>();
        group1.add('a');
        group1.add('b');
        ArrayList<Character> group2 = new ArrayList<>();
        group2.add('c');
        group2.add('d');
        elfGroups.add(group1);
        elfGroups.add(group2);

        HashMap<Character, Integer> priorityMap = new HashMap<>();
        priorityMap.put('a', 1);
        priorityMap.put('b', 2);
        priorityMap.put('c', 3);
        priorityMap.put('d', 4);

        ArrayList<Integer> groupValues = sorterobj.mapGroupValues(elfGroups, priorityMap);

        assertEquals("[3, 7]", groupValues.toString());
    }

    @Test
    void test_sumfor_GroupBadgePriority() {
        ArrayList<Integer> groupValues = new ArrayList<>();
        groupValues.add(3);
        groupValues.add(7);

        int groupBadgePriority = sorterobj.calculateGroupBadgePriority(groupValues);

        assertEquals(10, groupBadgePriority);
        System.out.println(groupBadgePriority);
    }
}
