package org.example;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    int noOfDice;
    int min = 1;
    int max =6;


    public Integer rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        while(diceUsed < noOfDice){
            totalSum += ThreadLocalRandom.current().nextInt(min, max+1);
            diceUsed++;
        }
        return totalSum;
    }
}
