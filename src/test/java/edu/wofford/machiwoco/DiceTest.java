package edu.wofford.machiwoco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Random;
import org.junit.*;

public class DiceTest {
    private class FakeRandom extends Random {
        private int[] nums = {4, 1, 3, 5, 2, 6};
        private int index = 0;
    
        @Override
        public int nextInt(int bound) {
            int n = nums[index] - 1;
            index = (index + 1) % nums.length;
            return n;
        }
    
    }

    @Test 
    public void testRoll() {
        Dice d = new Dice(new FakeRandom());
        int r = d.roll();
        assertEquals(r, 4);
    }
}
