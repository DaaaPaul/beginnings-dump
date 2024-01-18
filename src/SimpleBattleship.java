import java.util.Random;
import java.util.Scanner;

public class SimpleBattleship {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numOfGuesses = 0;
            int[] ships = new int[3];
            int numOfHits = 0;
            int min = 0;
            int max = 4;
            String result = "miss";
            Random random = new Random();
            int startingCell = random.nextInt(max - min + 1) + min;
            ships[0] = startingCell;
            ships[1] = startingCell + 1;
            ships[2] = startingCell + 2;
            System.out.println("Welcome to Battleship - the simplified version. There are 7 tiles, and the hidden ship is 3 tiles long. The goal is to hit all 3 tiles of the hidden ship.");
            while(containsNonZeroElements(ships)){
                System.out.print("Enter a the number of the tile you want to destroy ");
                int userGuess = scanner.nextInt();
                if(userGuess == startingCell){
                    ships[0] = 0;
                    numOfGuesses++;
                    numOfHits++;
                    if(numOfHits == ships.length){
                        result = "kill";
                    } else {
                        result = "hit";
                    }
                }
                if(userGuess == startingCell + 1){
                    ships[1] = 0;
                    numOfGuesses++;
                    numOfHits++;
                    if(numOfHits == ships.length){
                        result = "kill";
                    } else {
                        result = "hit";
                    }
                }
                if(userGuess == startingCell + 2){
                    ships[2] = 0;
                    numOfGuesses++;
                    numOfHits++;
                    if(numOfHits == ships.length){
                        result = "kill";
                    } else {
                        result = "hit";
                    }
                }
                System.out.println(result);
                result = "miss";
            }
            System.out.println("You took " + numOfGuesses + " guesses! You won!");
        }
    }
    private static boolean containsNonZeroElements(int[] array) {
        for (int value : array) {
            if (value != 0) {
                return true;
            }
        }
        return false;
    }
}
