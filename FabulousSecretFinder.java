package numbergame;

import java.util.Iterator;
import java.util.LinkedList;

public class FabulousSecretFinder extends SecretFinder {
    private int guess;
    private LinkedList<Number> possibleValues;

    public FabulousSecretFinder(SecretKeeper secretKeeper) {
        super(secretKeeper);
        initializePossibleValues();
        }

    private void initializePossibleValues() {
        int numOfDigits = secretKeeper.getNumDigits();
        int min = (int) Math.pow(10, numOfDigits - 1);
        int max = (int) Math.pow(10, numOfDigits) - 1;

        possibleValues = new LinkedList<>();

        for (int i = min; i <= max; i++) {
            Number number = new Number(i);
            if (number.isValid(numOfDigits))
                possibleValues.add(number);
        }
    }

    protected Number makeAGuess() {
        guess = possibleValues.get(0).asInt();
        return possibleValues.get(0);
    }

    protected void process(Similarity guessToSecret) {
        Number guessAsNumber = new Number(guess);
        Iterator<Number> iterator = possibleValues.iterator();

        while (iterator.hasNext()) {
            Number number = iterator.next();
            Similarity itemToGuess = number.similarityWith(guessAsNumber);
            if (cantBeSecretNumber(guessToSecret, itemToGuess)) {
                iterator.remove();
            }
        }
    }

    private boolean cantBeSecretNumber(Similarity guessToSecret, Similarity itemToGuess) {
        return !itemToGuess.equals(guessToSecret);
    }

}
