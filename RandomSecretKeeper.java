package numbergame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSecretKeeper extends SecretKeeper {
    private Number secretNumber;

    public RandomSecretKeeper(int numDigits) {
        super(numDigits);
        setSecretNumber();
    }

    public Number getSecretNumber() {
        return secretNumber;
    }

    // Sets a random secret number that has `numDigits` digits.
    private void setSecretNumber() {
        int min = (int) Math.pow(10, getNumDigits() - 1);
        int max = (int) Math.pow(10, getNumDigits()) - 1;

        this.secretNumber = generateRandomNumber(min, max);
    }

    public Number generateRandomNumber(int min, int max) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt((max - min) + 1) + min;
        Number randomNumber = new Number(randomInt);

        if (randomNumber.isValid(getNumDigits()))
            return randomNumber;

        return generateRandomNumber(min, max);
    }

    @Override
    public Similarity calculateSimilarity(Number number) {
        return secretNumber.similarityWith(number);
    }
}
