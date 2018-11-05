package numbergame;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FabulousSecretKeeperTest {
    @Test(timeout = 5000)
    public void testNumGuessesAtLeast3() {
        testMinNumGuesses(4, 3);
    }

    private void testMinNumGuesses(int numDigits, int minNumGuesses) {
        FabulousSecretKeeper keeper = new FabulousSecretKeeper(numDigits);
        SecretFinder finder = new FabulousSecretFinder(keeper);

        finder.findSecretNumber();
        int numQueries = keeper.getNumQueries();
        assertTrue("Num queries: " + numQueries, numQueries >= minNumGuesses);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast4() {
        testMinNumGuesses(4, 4);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast5() {
        testMinNumGuesses(4, 5);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast6() {
        testMinNumGuesses(4, 6);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast7() {
        testMinNumGuesses(4, 7);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast8() {
        testMinNumGuesses(4, 8);
    }

    @Test(timeout = 15000)   // Instructor's solution does not pass this test and beyond
    public void testNumGuessesAtLeast9() {
        testMinNumGuesses(4, 9);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast10() {
        testMinNumGuesses(4, 10);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast11() {
        testMinNumGuesses(4, 11);
    }

    @Test(timeout = 15000)
    public void testNumGuessesAtLeast12() {
        testMinNumGuesses(4, 12);
    }
}
