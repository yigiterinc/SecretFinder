package numbergame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberTest {
    @Test(timeout = 1000)
    public void testAsInt1() {
        Number number = new Number(1234);
        assertEquals(1234, number.asInt());
    }

    @Test(timeout = 1000)
    public void testAsInt2() {
        Number number = new Number(809317);
        assertEquals(809317, number.asInt());
    }

    @Test(timeout = 1000)
    public void testIsValidNumber1() {
        Number number = new Number(1234);
        assertTrue(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber2() {
        Number number = new Number(8403);
        assertTrue(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber3() {
        Number number = new Number(0234);
        assertFalse(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber4() {
        Number number = new Number(12345);
        assertFalse(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber5() {
        Number number = new Number(4894);
        assertFalse(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber6() {
        Number number = new Number(4090);
        assertFalse(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testIsValidNumber7() {
        Number number = new Number(0);
        assertFalse(number.isValid(4));
    }

    @Test(timeout = 1000)
    public void testSimilarity1() {
        testSimilarity(4, 7803, 7803, 4, 0);
    }

    private void testSimilarity(int numDigits, int secretNumber, int guess, int positiveSimilarity, int negativeSimilarity) {
        Number number = new Number(secretNumber);
        Similarity similarity = number.similarityWith(new Number(guess));

        assertEquals(new Similarity(positiveSimilarity, negativeSimilarity), similarity);
    }

    @Test(timeout = 1000)
    public void testSimilarity2() {
        testSimilarity(4, 7803, 7083, 2, 2);
    }

    @Test(timeout = 1000)
    public void testSimilarity3() {
        testSimilarity(4, 7803, 3780, 0, 4);
    }

    @Test(timeout = 1000)
    public void testSimilarity4() {
        testSimilarity(4, 7803, 1294, 0, 0);
    }

    @Test(timeout = 1000)
    public void testSimilarity5() {
        testSimilarity(4, 7803, 5823, 2, 0);
    }

    @Test(timeout = 1000)
    public void testSimilarity6() {
        testSimilarity(4, 7803, 5238, 0, 2);
    }

}
