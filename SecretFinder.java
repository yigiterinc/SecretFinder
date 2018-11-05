package numbergame;

/**
 * !!! YOU ARE NOT ALLOWED TO CHANGE THIS FILE !!!
 */
public abstract class SecretFinder {
    protected SecretKeeper secretKeeper;

    public SecretFinder(SecretKeeper secretKeeper) {
        this.secretKeeper = secretKeeper;
    }

    public final Number findSecretNumber() {
        while (true) {
            Number guess = makeAGuess();
            Similarity similarity = secretKeeper.getSimilarity(guess);
            if (isFullSimilarity(similarity)) {
                return guess;
            }
            process(similarity);
        }
    }

    private boolean isFullSimilarity(Similarity similarity) {
        return similarity.getPositive() == secretKeeper.getNumDigits();
    }

    // Returns the next guess.
    protected abstract Number makeAGuess();

    // Process the similarity of the most recent guess to the secret number
    protected abstract void process(Similarity similarity);
}
