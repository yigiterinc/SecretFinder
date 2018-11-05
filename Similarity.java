package numbergame;

public class Similarity {
    private int positive;
    private int negative;

    public Similarity(int positive, int negative) {
        this.positive = positive;
        this.negative = negative;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Similarity) {
            Similarity that = (Similarity)other;
            return this.positive == that.positive &&
                    this.negative == that.negative;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = positive;
        result = 31 * result + negative;
        return result;
    }

    public String toString() {
        return positive + " + " + negative + " -";
    }

    public int getPositive() {
        return positive;
    }

    public int getNegative() {
        return negative;
    }
}