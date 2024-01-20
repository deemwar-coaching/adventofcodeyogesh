package seriesfromdayone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SantaFloorProblemTest {

    private static  String filepath = "src/test/resources/testInput.txt";
    

    @BeforeEach
    void setup() throws IOException {

        List<String> lines = List.of("(", "()", ")", "(()))");
        Path testFilePath = Paths.get(filepath);


        Files.createDirectories(testFilePath.getParent());

        Files.write(testFilePath, lines);
        SantaFloorProblem.filePath = filepath.toString();
    }



    @Test
    public void testCountParentheses() {
        // Sample input
        List<String> fileContent = Arrays.asList("(","(",")",")","(");

        int openParenthesesCount = Collections.frequency(fileContent, "(");
        int closeParenthesesCount = Collections.frequency(fileContent, ")");

        System.out.println("( parantheses is moving a floor : " + openParenthesesCount);
        System.out.println("getting down a floor for (: " + closeParenthesesCount);


        assertEquals(3, openParenthesesCount);
        assertEquals(2, closeParenthesesCount);
    }

    @Test
    void testReadFileAsArrayList() {
        List<String> lines = SantaFloorProblem.readFileAsArrayList();
        assertEquals(4, lines.size());
        assertEquals("(", lines.get(0));
        assertEquals("()", lines.get(1));
        assertEquals(")", lines.get(2));

    }
    @Test
    public void testParkingFloor() {

        SantaFloorProblem.integerList = Arrays.asList(1, -1, -1, 1, -1, -1, -1, -1, 1, 1);


        SantaFloorProblem.parkingfloor();


        assertEquals(9, SantaFloorProblem.floor,9);

    }



}



