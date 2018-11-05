package numbergame;

import java.util.*;

public class FabulousSecretKeeper extends SecretKeeper {
    private Number guess;
    private LinkedList<Number> possibleSecretNumbers;

    public FabulousSecretKeeper(int numDigits) {
        super(numDigits);
        initializePossibleSecretNumbers();
    }

    private void initializePossibleSecretNumbers() {
        int numOfDigits = getNumDigits();
        int min = (int) Math.pow(10, numOfDigits - 1);
        int max = (int) Math.pow(10, numOfDigits) - 1;
        possibleSecretNumbers = new LinkedList<>();

        for (int i = min; i <= max; i++) {
            Number number = new Number(i);
            if (number.isValid(numOfDigits))
                possibleSecretNumbers.add(number);
        }
    }

    @Override
    protected Similarity calculateSimilarity(Number number) {
        this.guess = number;
        return getBestSimilarity();
    }

    //returns the similarity that causes minimum conflict, we are maximizing the # of possibleSecretNumbers
    private Similarity getBestSimilarity() {
        LinkedList<Similarity> possibleSimilarityValues = new LinkedList<>();
        LinkedList<Integer> possibleConflictsForSimilarity = new LinkedList<>();

        initializePossibleSimilarityValues(possibleSimilarityValues, possibleConflictsForSimilarity);
        Similarity bestSimilarity = findBestSimilarity(possibleSimilarityValues, possibleConflictsForSimilarity);
        process(bestSimilarity);

        return bestSimilarity;
    }

    private void initializePossibleSimilarityValues(LinkedList<Similarity> possibleSimilarityValues,LinkedList<Integer> possibleConflicts) {
        Similarity uniqueSimilarityValue;
        Iterator iterator = possibleSecretNumbers.iterator();

        while(iterator.hasNext()) {
            Number number = (Number) iterator.next();
            uniqueSimilarityValue = guess.similarityWith(number);
            if (!possibleSimilarityValues.contains(uniqueSimilarityValue)) {
                possibleSimilarityValues.add(uniqueSimilarityValue);
                calculateNumberOfConflicts(possibleConflicts, uniqueSimilarityValue);
            }
        }
    }

    //returns the value of the minimum conflicting similarity in possibleSimilarities
    private Similarity findBestSimilarity(LinkedList<Similarity> possibleSimilarityValues, LinkedList<Integer> possibleConflictsForSimilarity) {
        if (possibleSecretNumbers.size() == 1)
            return new Similarity(getNumDigits(),0);
        else
            return possibleSimilarityValues.get(findMinimum(possibleConflictsForSimilarity));
    }

    private int findMinimum(LinkedList<Integer> list) throws ArrayIndexOutOfBoundsException {
        if(list.size() > 0) {
            int minimum = list.get(0);
            int minimumIndex = 0;

            for(int i = 1; i < list.size(); i++) {
                if(list.get(i) < minimum)
                    minimum = list.get(i);
                minimumIndex = i;
            }
            return minimumIndex;
        }
        else
            throw new ArrayIndexOutOfBoundsException("Array size = 0?");
    }

    protected void process(Similarity guessToSecret) {
        Iterator<Number> iterator = possibleSecretNumbers.iterator();

        while (iterator.hasNext()) {
            Number number = iterator.next();
            Similarity itemToGuess = number.similarityWith(guess);
            if (!guessToSecret.equals(itemToGuess)) {
                iterator.remove();
            }
        }
    }

    private void calculateNumberOfConflicts(LinkedList<Integer> possibleConflictsForSimilarity, Similarity similarity) {
        Iterator iterator = possibleSecretNumbers.iterator();
        int numberOfConflicts = 0;

        while (iterator.hasNext()) {
            Number number1 = (Number) iterator.next();
            Similarity number1ToGuess = number1.similarityWith(guess);
            if (createsConflict(number1ToGuess, similarity))
                numberOfConflicts++;
        }
        possibleConflictsForSimilarity.add(numberOfConflicts);
    }

    private boolean createsConflict(Similarity guessToSecret,Similarity guessToListItem) {
        return !guessToSecret.equals(guessToListItem);
    }

}

