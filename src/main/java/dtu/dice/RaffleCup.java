package dtu.dice;

import java.util.Random;

public class RaffleCup {

    private final int NUMBER_OF_ROLLS = 2;
    private int[] ourRolls;
    private int sum;
    private Die die = new Die();

    /**
     * Method for rolling dice. Returns 2 random numbers in an int array.
     * @return
     */
    public int[] roll(){

        ourRolls = new int[NUMBER_OF_ROLLS];
        Random random = new Random();

        for(int i =0; i < ourRolls.length; i++){
            ourRolls[i] = random.nextInt(die.getMAXIMUM()-die.getMINIMUM()+1)+1;
        }
        turnSum(ourRolls);
        return ourRolls;
    }

    public void turnSum(int[] lastRoll){
        sum = lastRoll[0] + lastRoll[1];
    }


    public int[] getOurRolls() {
        return ourRolls;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
