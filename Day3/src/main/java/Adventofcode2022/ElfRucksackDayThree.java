package Adventofcode2022;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ElfRucksackDayThree {
    public static void main(String args[]) {
        String filePath = "src/main/resources/smallinput";
        String line;
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader Openafile = new BufferedReader(new FileReader(filePath))) {
            while ((line = Openafile.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
        ElfRucksackDayThree sorterobj = new ElfRucksackDayThree();
        ArrayList<String> sortedLines = sorterobj.elfCompartments(lines);
        System.out.println(sortedLines);

        HashMap<Character, Integer> prioritymap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            prioritymap.put((char) ('a' + i), i + 1);
            prioritymap.put((char) ('A' + i), i + 27);
        }

        ArrayList<Integer> values = sorterobj.mapValues(sortedLines, prioritymap);
        System.out.println(values);

        int elfprioritiessum = sorterobj.sumOfValues(values);
        System.out.println("The sum of prorities on rucksack : " + elfprioritiessum);

        ArrayList<ArrayList<String>> groups = sorterobj.elfGroupSorting(lines);
        System.out.println(groups);

        ArrayList<ArrayList<Character>> elfGroups = sorterobj.findCommonelement(groups);
        System.out.println(elfGroups);

        ArrayList<Integer> groupValues = sorterobj.mapGroupValues(elfGroups, prioritymap);
        System.out.println("The key values of badges"+groupValues);

        int groupBadgePriority = sorterobj.calculateGroupBadgePriority(groupValues);
        System.out.println("Group Badge Priority of elves: " + groupBadgePriority);
    }

    public ArrayList<String> elfCompartments(ArrayList<String> lines){
        ArrayList<String> sortedLines = new ArrayList<>();
        for (String line : lines) {
            int size = line.length();
            String firstHalf = line.substring(0, size/2);
            String secondHalf = line.substring(size/2);
            ArrayList<Character> commonChars = new ArrayList<>();
            for (char c : firstHalf.toCharArray()) {
                if (secondHalf.indexOf(c) != -1 && !commonChars.contains(c)) {
                    commonChars.add(c);
                }
            }
            sortedLines.add(commonChars.toString());
        }
        return sortedLines;
    }

    public ArrayList<Integer> mapValues(ArrayList<String> sortedLines, HashMap<Character, Integer> map) {
        ArrayList<Integer> values = new ArrayList<>();
        for (String line : sortedLines) {
            int sum = 0;
            for (char c : line.toCharArray()) {
                if (map.containsKey(c)) {
                    sum += map.get(c);
                }
            }
            values.add(sum);
        }
        return values;
    }

    public int sumOfValues(ArrayList<Integer> values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public ArrayList<ArrayList<String>> elfGroupSorting(ArrayList<String> lines) {
        ArrayList<ArrayList<String>> elfGroups = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 3) {
            ArrayList<String> group = new ArrayList<>();
            for (int j = i; j < i + 3 && j < lines.size(); j++) {
                group.add(lines.get(j));
            }
            elfGroups.add(group);
        }
        return elfGroups;
    }

    public ArrayList<ArrayList<Character>> findCommonelement(ArrayList<ArrayList<String>> elfGroups) {
        ArrayList<ArrayList<Character>> commonCharsGroups = new ArrayList<>();
        for (ArrayList<String> group : elfGroups) {
            ArrayList<Character> commonChars = new ArrayList<>();
            for (char c : group.get(0).toCharArray()) {
                boolean isCommon = true;
                for (int i = 1; i < group.size(); i++) {
                    if (!group.get(i).contains(String.valueOf(c))) {
                        isCommon = false;
                        break;
                    }
                }
                if (isCommon && !commonChars.contains(c)) {
                    commonChars.add(c);
                }
            }
            commonCharsGroups.add(commonChars);
        }
        return commonCharsGroups;
    }

    public ArrayList<Integer> mapGroupValues(ArrayList<ArrayList<Character>> elfGroups, HashMap<Character, Integer> map) {
        ArrayList<Integer> groupValues = new ArrayList<>();
        for (ArrayList<Character> group : elfGroups) {
            int sum = 0;
            for (char c : group) {
                if (map.containsKey(c)) {
                    sum += map.get(c);
                }
            }
            groupValues.add(sum);
        }
        return groupValues;
    }

    public int calculateGroupBadgePriority(ArrayList<Integer> groupValues) {
        int groupBadgePriority = 0;
        for (int value : groupValues) {
            groupBadgePriority += value;
        }
        return groupBadgePriority;
    }
}