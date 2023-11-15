package deemwar.coaching;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ElfRockPaperScissors {

    static final int rock = 1;
    static final int paper = 2;
    static final int scissors = 3;

    static final int loss = 0;
    static final int draw = 3;
    static final int win = 6;

    private static Map<String, Integer> shapes;
    public static void init(){
        shapes = new HashMap<>();
        shapes.put("A", rock);
        shapes.put("B", paper);
        shapes.put("C", scissors);
        shapes.put("X", rock);
        shapes.put("Y", paper);
        shapes.put("Z", scissors);
    }


    public static int calculateScore(String filePath) throws IOException {
        init();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int player1Score = 0;

            String line;
            while ((line = br.readLine()) != null) {
                String[] match = line.trim().split(" ");
                //conditioons implemented with strategy and score expected

                if (match.length != 2) continue;
                //shape referring rock,paper,scissor.
                String player1Symbol = match[0];
                String player2Symbol = match[1];

                Integer player1SymbolWeight = shapes.get(player1Symbol);
                Integer player2SymbolWeight = shapes.get(player2Symbol);


                /*
                        player 1 wins , he will get 6
                        player 1 loses , he will get 0
                        player 1 draw , he will get 3

                 */

                int result = calculateWinningScoreForPlayer1(player1SymbolWeight, player2SymbolWeight);

                player1Score += result;

                player1Score += player2SymbolWeight;
//pred score conditions
//                if (match[1].equals("X")) {
//                    predictedscore += loss;
//
//                    if (shapes.get(match[0]) == rock) {
//                        predictedscore += scissors;
//                    }
//                    if (shapes.get(match[0]) == paper) {
//                        predictedscore += rock;
//                    }
//                    if (shapes.get(match[0]) == scissors) {
//                        predictedscore += paper;
//                    }
//                }
//                if (match[1].equals("Y")) {
//                    predictedscore += draw;
//                    predictedscore += shapes.get(match[0]);
//                }
//                if (match[1].equals("Z")) {
//                    predictedscore += win;
//
//                    if (shapes.get(match[0]) == rock) {
//                        predictedscore += paper;
//                    }
//                    if (shapes.get(match[0]) == paper) {
//                        predictedscore += scissors;
//                    }
//                    if (shapes.get(match[0]) == scissors) {
//                        predictedscore += rock;
//                    }
//                }
            }
// print score we get and the maximum score we can get by the strategy guide

            System.out.println("Actual score we are getting :"+player1Score);
            return player1Score;
        }
    }

    private static int calculateWinningScoreForPlayer1(Integer player1SymbolWeight, Integer player2SymbolWeight) {
        int result =0;

        if (player1SymbolWeight == player2SymbolWeight) {
            result += draw;
        } else if (
                player1SymbolWeight == rock &&
                        player2SymbolWeight == paper
        ) {
            result += win;
        } else if (
                player1SymbolWeight == paper &&
                        player2SymbolWeight == scissors
        ) {
            result += win;
        } else if (
                player1SymbolWeight == scissors &&
                        player2SymbolWeight == rock
        ) {
            result += win;
        } else {
            result += loss;
        }
        return result;
    }
}
