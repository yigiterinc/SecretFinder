package numbergame;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean inDebugMode;
    private static boolean inManualFinderMode;
    private static SecretKeeper secretKeeper;
    private static SecretFinder secretFinder;

    public static void main(String[] args) {
        determineDebugMode();
        setSecretNumber();
        determineFinderMode();
        if (inManualFinderMode) {
            readUserGuesses();
        } else {
            useFinder();
        }
    }

    private static void determineDebugMode() {
        System.out.print("Will you set the secret number manually (y/n)? ");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
            inDebugMode = true;
        } else if (userChoice.equalsIgnoreCase("n")) {
            inDebugMode = false;
        } else {
            System.out.println("Bad input!");
            determineDebugMode();
        }
    }

    private static void setSecretNumber() {
        try {
            int numDigits = readNumber("Enter the number of digits: ");

            if (inDebugMode) {
                int secret = readNumber("Enter the secret number: ");
                NaiveSecretKeeper naiveKeeper = new NaiveSecretKeeper(numDigits, new Number(secret));
                secretKeeper = naiveKeeper;
            } else {
                secretKeeper = new FabulousSecretKeeper(numDigits);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            setSecretNumber();
        }
    }

    private static int readNumber(String message) {
        try {
            System.out.print(message);
            int number = Integer.parseInt(scanner.nextLine());
            return number;
        } catch (Exception e) {
            System.out.println("Bad input!");
            return readNumber(message);
        }
    }

    private static void determineFinderMode() {
        System.out.print("Will you enter guesses manually (y/n)? ");
        String userChoice = scanner.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
            inManualFinderMode = true;
        } else if (userChoice.equalsIgnoreCase("n")) {
            inManualFinderMode = false;
        } else {
            System.out.println("Bad input!");
            determineFinderMode();
        }
    }

    private static void readUserGuesses() {
        Number userInput = new Number(readNumber("?> "));
        if (userInput.isValid(secretKeeper.getNumDigits())) {
            Similarity similarity = secretKeeper.getSimilarity(userInput);
            if (similarity.getPositive() == secretKeeper.getNumDigits()) {
                System.out.println("Dammit!");
                System.out.println("Num guesses: " + secretKeeper.getNumQueries());
                return;
            } else {
                System.out.println(similarity);
            }
        } else {
            System.out.println("Bad input!");
        }
        readUserGuesses();
    }

    private static void useFinder() {
        SecretFinder finder = new FabulousSecretFinder(secretKeeper);
        Number guess = finder.findSecretNumber();
        System.out.println("Found: " + guess);
        System.out.println("Num guesses: " + secretKeeper.getNumQueries());
    }
}
