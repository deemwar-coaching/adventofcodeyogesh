package deemwar.coaching;



import org.junit.jupiter.api.Test;

import java.io.IOException;

import static deemwar.coaching.ElfRockPaperScissors.calculateScore;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElfRockPaperScissorsTest {





    @Test
    void when_smallinput_file_has_been_given_expect_15_as_answer() throws IOException {
        // give a filepath to provide inputs
        int score = calculateScore("/Users/muthuishere/muthu/gitworkspace/deemwar-coaching/adventofcodeyogesh/src/test/resources/smallinput.txt");

        // Add assertion method along with max score expected
        assertEquals(15, score);
    }


}