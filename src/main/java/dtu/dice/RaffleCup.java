package dtu.dice;

import java.util.Random;

public class RaffleCup {

    private final int NUMBER_OF_ROLLS = 2;
    private int[] ourRolls;
    private Die die = new Die();

    public int[] roll(){

        ourRolls = new int[NUMBER_OF_ROLLS];
        Random random = new Random();

        for(int i =0; i < ourRolls.length; i++){
            ourRolls[0] = random.nextInt(die.getMAXIMUM()-die.getMINIMUM()+1)+1;
        }
        return ourRolls;
    }

    public int[] getOurRolls() {
        return ourRolls;
    }
}
