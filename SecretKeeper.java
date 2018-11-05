package numbergame;


public abstract class SecretKeeper {
    private int numDigits;
    private int numQueries;

    public SecretKeeper(int numDigits) {
        if (numDigits <= 0)
            throw new IllegalArgumentException("Num digits should be positive.");
        this.numDigits = numDigits;
        this.numQueries = 0;
    }

    public final int getNumDigits() {
        return numDigits;
    }

    public final Similarity getSimilarity(int number) {
        numQueries++;
        return calculateSimilarity(new Number(number));
    }

    public final Similarity getSimilarity(Number number) {
        return getSimilarity(number.asInt());
    }

    public final int getNumQueries() {
        return numQueries;
    }

    // Returns the similarity of `number` to this keeper's secret number.
    protected abstract Similarity calculateSimilarity(Number number);
}