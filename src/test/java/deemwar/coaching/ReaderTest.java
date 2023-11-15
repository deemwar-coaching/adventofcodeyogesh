package deemwar.coaching;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    @Test
    void testReadFromClasspath() {

        Reader reader = new Reader();
        List<String> contents = reader.readFromClasspath("inputs.text");

        System.out.println(contents);
        assertTrue(contents.size()>0);

    }
    @Test
    void testReadFromClasspathAssets() {

        Reader reader = new Reader();
        List<String> contents = reader.readFromClasspath("assets/idea.txt");

        System.out.println(contents);
        assertTrue(contents.size()>0);

    }
}