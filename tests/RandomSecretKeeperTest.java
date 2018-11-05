package numbergame;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RandomSecretKeeperTest {
    @Test(timeout = 2000)
    public void testRandomSecretNumber1() {
        for (int i = 0; i < 5; i++) {
            RandomSecretKeeper secretKeeper = new RandomSecretKeeper(4);
            Number number = secretKeeper.getSecretNumber();

            assertTrue(number.isValid(4));
        }
    }

    @Test(timeout = 2000)
    public void testRandomSecretNumber2() {
        for (int i = 0; i < 5; i++) {
            RandomSecretKeeper secretKeeper = new RandomSecretKeeper(5);
            Number number = secretKeeper.getSecretNumber();

            assertTrue(number.isValid(5));
        }
    }
}
