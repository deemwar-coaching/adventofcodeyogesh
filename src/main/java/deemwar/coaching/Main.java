package deemwar.coaching;

import java.io.IOException;

import static deemwar.coaching.ElfRockPaperScissors.calculateScore;

public class Main {
    public static void main(String[] args) throws IOException {
        int score = calculateScore("/Users/muthuishere/muthu/gitworkspace/deemwar-coaching/adventofcodeyogesh/src/test/resources/inputs.text");
        System.out.println(score);


    }
}