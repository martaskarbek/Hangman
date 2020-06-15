import java.util.Random;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Hangman
{
    final String[] Capitals = { "Warszawa", "Rzym", "Krakow" };

        final Random Capital = new Random();
        final int random = Capital.nextInt(Capitals.length);
        final String randomCapital = Capitals[random];
        final int CapitalLen = randomCapital.length();
        final char DashedCapital[] = new char[CapitalLen];
        final char dash = '-';
        int lives = 7;
        int guessedValue = 0;
        final ArrayList<String> WrongAnswears = new ArrayList<>();
        final ArrayList<String> GoodAnswears = new ArrayList<>();
        public String Hangman =  "   +---+" +"\n" + "   |  |" + "\n" + "   O  |" + "\n" + "  /|\\ |" + "\n" + "  / \\ |" + "\n" + "      |" + "\n" + "=========";
        public void RestartGame() {
            System.out.println("Your new capital to guess =>\n");
            final Hangman HangmanGame = new Hangman();
            HangmanGame.newGame();
            HangmanGame.Game();
        }

        public void HangmanPrinting() {
            if (lives == 6) {
                System.out.println("\n\n\n\n\n\n=========");
            }
            if (lives == 5) {
                System.out.println("\n" +"\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "=========");
            }
            if (lives == 4) {
                System.out.println("   +---+" +"\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "=========");   
            }
            if (lives == 3){
                System.out.println("   +---+" +"\n" + "   |  |" + "\n" + "   O  |" + "\n" + "      |" + "\n" + "      |" + "\n" + "      |" + "\n" + "=========");
            }
            if (lives == 2) {
                System.out.println("   +---+" +"\n" + "   |  |" + "\n" + "   O  |" + "\n" + "  /|\\ |" + "\n" + "      |" + "\n" + "      |" + "\n" + "=========");
            }
            if (lives == 1) {
                System.out.println("   +---+" +"\n" + "   |  |" + "\n" + "   O  |" + "\n" + "  /|\\ |" + "\n" + "  /   |" + "\n" + "      |" + "\n" + "=========");
            }
        }

        public void DoRestart() {
            try (Scanner reset = new Scanner(System.in)) {
                System.out.println("\nDo you want to play again? Y/N ");
                final String userChoice = reset.next();
                if (userChoice.equalsIgnoreCase("y")){
                    RestartGame();
                }
                if (userChoice.equalsIgnoreCase("n")) {
                    System.out.println("Thank you for game and see you soon!");
                    System.exit(0);
                }}
        }

        public void WrongAnswear() {
            System.out.println("\nNeed to keep guessing");
            System.out.println("\n" + WrongAnswears);
            if (lives < 0){
                lives += 1;
            }
            HangmanPrinting();
            System.out.println("\nYou have => " + lives + " left.");
            System.out.println(DashedCapital);
        }

        public void Game() {
        try (Scanner input = new Scanner(System.in)) {
            for (int i = 0; i < randomCapital.length(); i++) {
                DashedCapital[i] = dash;
            }
            System.out.println(DashedCapital);
            while (lives > 0 || guessedValue != randomCapital.length()) {
                System.out.println("\nEnter your guess: ");
                final String userGuess = input.next();
                final char CapitalLetters[] = randomCapital.toLowerCase().toCharArray();
                final int GuessLen = userGuess.length();
                final char[] Guess = userGuess.toLowerCase().toCharArray();
                if (randomCapital.toLowerCase().contains(userGuess.toLowerCase())) {
                    for (int j = 0; j < GuessLen; j++) {
                        final Character GuessedLetter = Guess[j];
                        for (int i = 0; i < randomCapital.length(); i++) {
                            if (CapitalLetters[i] == GuessedLetter && !GoodAnswears.contains(GuessedLetter.toString())) {
                                DashedCapital[i] = CapitalLetters[i];
                                guessedValue += 1;
                                }}
                            GoodAnswears.add(GuessedLetter.toString());        
                    }
                    HangmanPrinting();
                    System.out.println(WrongAnswears);
                    System.out.println("\nYou have => " + lives + " left.\n");
                    System.out.println(DashedCapital);
                    }
                    if (!randomCapital.toLowerCase().contains(userGuess.toLowerCase())) {
                        if (!WrongAnswears.contains(userGuess)){
                            if (userGuess.length() == 1) {
                                lives -= 1;
                                WrongAnswears.add(userGuess);
                                }
                            if (userGuess.length() > 1) {
                                lives -= 2;
                                WrongAnswears.add(userGuess);
                                }}
                        WrongAnswear();
                    }
                    if (lives <= 0) {
                        System.out.println("\nYou loose, correct answear was => " + randomCapital + ".");
                        System.out.print(Hangman);
                        DoRestart();
                    }
                    if (guessedValue == randomCapital.length()) {
                        System.out.println("\n" + randomCapital);
                        System.out.println("\nYou won!");
                        DoRestart();
                    }
            }
        }    
    }

    public void newGame() {
        lives = 7;
        guessedValue = 0;
        WrongAnswears.clear();
        GoodAnswears.clear();
        }
    public static void main(final String[] args) {
        System.out.println("Welcome to Hangman Game");
        final Hangman HangmanGame = new Hangman();
        HangmanGame.newGame();
        HangmanGame.Game();
    }
}