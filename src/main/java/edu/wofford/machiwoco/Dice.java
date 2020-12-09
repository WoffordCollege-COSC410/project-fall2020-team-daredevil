package edu.wofford.machiwoco;

import java.util.Random;

/**
 * @author Jacob Vannoy, Kristinn Sigurjonsson, Jaylen Muhammad, Evan Suggs
 */

public class Dice {
    private Random random;

    /**
     * Constructs a new instance of Dice
     * @param x
     */
    public Dice(Random x) {
        random = x;
    }

    /**
     * Rolls the dice
     * @return random number 1-6
     */
    public int roll() {
        return random.nextInt(6) + 1;
    }
    
}
