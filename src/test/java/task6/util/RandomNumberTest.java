package task6.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static task6.util.RandomNumber.r;

public class RandomNumberTest {
    @Test
    public void numberInRange() throws Exception {
        int randomInt = r(1,5);
        assertTrue("Number out range",randomInt > 0 && randomInt < 5);
    }

}