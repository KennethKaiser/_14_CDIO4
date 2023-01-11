package dtu.dice;

import dtu.players.PlayerHandler;

import java.util.Random;

public class RaffleCup {

    private final int NUMBER_OF_ROLLS = 2;
    private int[] ourRolls;
    private int sum;

    private boolean rolledDouble = false;
    private int numberOfDoubles = 0;
    private Die die = new Die();

    PlayerHandler playerHandler = new PlayerHandler();

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

    /**
     * Method for checking if the dice rolled are double.
     * @return
     */
    public boolean rolledDouble (){
        if(ourRolls[0] == ourRolls[1]){
            numberOfDoubles++;
            rolledDouble = true;
            return true;
        }
        else{
            numberOfDoubles = 0;
            rolledDouble = false;
            return false;
        }
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
