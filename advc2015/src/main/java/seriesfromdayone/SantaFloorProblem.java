package seriesfromdayone;
//hey we are gonna perform a commit operatio
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class SantaFloorProblem {
    public static String filePath;
    public static List<Integer> integerList;
    public static int floor;

    public static void getFilePathFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the file path:");
        filePath = scanner.nextLine();
    }

    public static List<String> readFileAsArrayList() {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void convertToIntegerList(List<String> fileContent) {
        integerList = new ArrayList<>();
        for (String line : fileContent) {
            for (char curlbraces : line.toCharArray()) {
                if (curlbraces == '(') {
                    integerList.add(1);
                } else if (curlbraces == ')') {
                    integerList.add(-1);
                }
            }
        }

    }

    public static void countParentheses() {
        List<String> fileContent = readFileAsArrayList();
        convertToIntegerList(fileContent);

        int floorup = 0;
        int floordown = 0;

        for (int value : integerList) {
            if (value == 1) {
                floorup++;
            } else if (value == -1) {
                floordown++;
            }
        }

        int noofloors = floorup - floordown;
        System.out.println("Number of '(' characters: " + floorup);
        System.out.println("Number of ')' characters: " + floordown);
        System.out.println("Number of floors traveled by Santa is " + noofloors);
    }
    public static void parkingfloor() {
        List<String> fileContent = readFileAsArrayList();
        convertToIntegerList(fileContent);

        int floor = 0;
        int position = 0;

        for (int value : integerList) {
            floor += value;
            position++;
            if (floor == -1) {
                break;
            }
        }

        if (floor == -1) {
            System.out.println("position of the first -1 floor is "+ position);
        } else {
            System.out.println("There is  -1 in the list");
        }
    }


    public static void main(String []c) {
        getFilePathFromUser();
        List<String> fileContent = readFileAsArrayList();
        System.out.println(fileContent);
        countParentheses();
        parkingfloor();
    }

}
