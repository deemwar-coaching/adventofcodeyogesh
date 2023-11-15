package deemwar.coaching;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Reader {


    public List<String> readFromClasspath(String fileName)  {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        List<String> lines = new ArrayList<>();
        String line=null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            // Read lines from the file, add them to the list
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
    }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
