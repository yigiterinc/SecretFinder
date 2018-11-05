package numbergame;

import java.util.Arrays;

public class Number {
    private int[] digits;
    private static final int NUMBER_OF_POSSIBLE_DIGITS = 10;

    public Number(int number) {
        String numberToString = Integer.toString(number);
        digits = new int[numberToString.length()];

        for (int i = 0; i < numberToString.length(); i++) {
            digits[i] = numberToString.charAt(i) - '0';
        }
    }

    public boolean isValid(int numDigits) {
        return hasUniqueDigits() && this.countDigits() == numDigits;
    }

    public boolean hasUniqueDigits() {
        int[] testArray = Arrays.copyOf(this.digits,digits.length);
        Arrays.sort(testArray);
        int digitCount = this.countDigits();

        for (int i = 0; i < digitCount-1 ; i++) {
            if (testArray[i] == testArray[i + 1])
                return false;
        }

        return true;
    }

    public int countDigits() {
        return this.digits.length;
    }

    public Similarity similarityWith(Number guess) {
        int positive = 0, negative = 0;
        int[] digitIndexes = createDigitIndexesArray(this);

        for (int i = 0; i < this.digits.length ; i++) {
            int currentDigit1 = this.digits[i];
            int currentDigit2 = guess.digits[i];

            if (currentDigit1 == currentDigit2)
                positive++;
            else if (digitIndexes[currentDigit2] != -1)
                negative++;
        }

        return new Similarity(positive, negative);
    }

    private int[] createDigitIndexesArray(Number number) { //creates an array which holds the index of digit N in number, at N'th index.
        int[] digitIndexes = new int[NUMBER_OF_POSSIBLE_DIGITS];

        initDigitIndexesArray(digitIndexes);
        findDigitLocations(number, digitIndexes);

        return digitIndexes;
    }

    private void initDigitIndexesArray(int[] digitIndexes) {
        for (int i = 0; i < NUMBER_OF_POSSIBLE_DIGITS; i++)
            digitIndexes[i] = -1; // -1 means, "number" does not contain i
    }

    private void findDigitLocations(Number number, int[] digitIndexes) {
        for (int i = 0; i < digits.length; i++) {
            int digit = number.digits[i];
            digitIndexes[digit] = i;
        }
    }

    public int asInt() {
        int number = 0 ;
        for (int i = 0; i < this.countDigits(); i++) {
            number += this.digits[this.countDigits() - i - 1] * (Math.pow(10,i));
        }

        return number;
    }

    public String toString() {
        return String.valueOf(asInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        return this.asInt() == number.asInt();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.asInt());
    }

    public int[] getDigits() {
        return digits;
    }
}

