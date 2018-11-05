package numbergame;

class NaiveSecretKeeper extends SecretKeeper {
    private Number secretNumber;

    public NaiveSecretKeeper(int numDigits, Number secretNumber) {
        super(numDigits);
        if (secretNumber.isValid(numDigits))
            this.secretNumber = secretNumber;
        else
            throw new IllegalArgumentException("Secret number is invalid.");
    }

    @Override
    protected Similarity calculateSimilarity(Number number) {
        return secretNumber.similarityWith(number);
    }
}
