package edu.wofford.machiwoco;

import java.util.Random;

public class Dice {
    private Random random;

    public Dice(Random x) {
        random = x;
    }

    public int roll() {
        return random.nextInt(6) + 1;
    }
    
}
