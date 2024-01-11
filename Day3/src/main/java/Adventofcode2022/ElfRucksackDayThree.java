package Adventofcode2022;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ElfRucksackDayThree {
    public static void main(String args[]) {
        String filePath = "src/main/resources/sample text";
        String line;
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(lines);
        ElfRucksackDayThree sorterobj = new ElfRucksackDayThree();
        ArrayList<String> sortedLines = sorterobj.Compartments(lines);
        System.out.println(sortedLines);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), i + 1);// for lowercase letters using key as a to z with values 1 to 26
            map.put((char) ('A' + i), i + 27);//for uppercase letters as keys and values 27 to 52
        }

        ArrayList<Integer> values = sorterobj.mapValues(sortedLines, map);
        System.out.println(values);

        int totalSum = sorterobj.sumOfValues(values);
        System.out.println("The sum of all values in the final displayed array list: " + totalSum);
    }

    public ArrayList<String> Compartments(ArrayList<String> lines){
        ArrayList<String> sortedLines = new ArrayList<>();
        for (String line : lines) {
            int size = line.length();
            String firstHalf = line.substring(0, size/2);
            String secondHalf = line.substring(size/2);

            // Find common chars
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
}
