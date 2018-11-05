package numbergame;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FabulousSecretFinderTest {
    @Test(timeout = 5000)
    public void testFindSecretNumber1() {
        NaiveSecretKeeper keeper = new NaiveSecretKeeper(4, new Number(9083));
        SecretFinder finder = new FabulousSecretFinder(keeper);

        assertEquals(9083, finder.findSecretNumber().asInt());
    }

    @Test(timeout = 5000)
    public void testFindSecretNumber2() {
        NaiveSecretKeeper keeper = new NaiveSecretKeeper(5, new Number(42061));
        SecretFinder finder = new FabulousSecretFinder(keeper);

        assertEquals(42061, finder.findSecretNumber().asInt());
    }

    @Test(timeout = 5000, expected = Exception.class)
    public void testFindSecretNumber3() {
        BadSecretKeeper keeper = new BadSecretKeeper(4);
        SecretFinder finder = new FabulousSecretFinder(keeper);

        finder.findSecretNumber();
    }

    @Test(timeout = 5000) // Instructor's solution does not pass this test
    public void testNumGuessesAtMost4() {
        testNumGuesses(4, 1639, 4);
    }

    private void testNumGuesses(int numDigits, int secretNumber, int maxNumGuesses) {
        NaiveSecretKeeper keeper = new NaiveSecretKeeper(numDigits, new Number(secretNumber));
        SecretFinder finder = new FabulousSecretFinder(keeper);

        assertEquals(secretNumber, finder.findSecretNumber().asInt());

        int numQueries = keeper.getNumQueries();
        assertTrue("Num queries: " + numQueries, numQueries <= maxNumGuesses);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost5() {
        testNumGuesses(4, 3905, 5);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost6() {
        testNumGuesses(4, 7832, 6);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost7() {
        testNumGuesses(4, 7832, 7);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost8() {
        testNumGuesses(4, 7032, 8);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost9() {
        testNumGuesses(4, 7032, 9);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost10() {
        testNumGuesses(4, 7032, 10);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost11() {
        testNumGuesses(4, 7032, 11);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost12() {
        testNumGuesses(4, 7032, 12);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost13() {
        testNumGuesses(4, 7032, 13);
    }

    @Test(timeout = 5000)
    public void testNumGuessesAtMost14() {
        testNumGuesses(4, 7032, 14);
    }
}

class BadSecretKeeper extends SecretKeeper {
    public BadSecretKeeper(int numDigits) {
        super(numDigits);
    }

    @Override
    protected Similarity calculateSimilarity(Number number) {
        return new Similarity(0, getNumDigits() - 1);
    }
}
