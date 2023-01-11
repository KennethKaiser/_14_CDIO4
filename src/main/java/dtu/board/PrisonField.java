package dtu.board;

import dtu.dice.RaffleCup;
import dtu.players.Player;
import dtu.players.PlayerHandler;

public class PrisonField extends Field {

    private Dummy dummy;
    private int die1, die2;
    private final int BAIL = 1000;

    public PrisonField(Dummy dummy) {
        this.dummy = dummy;
    }

    @Override
    public String landedLabel() {
        return "Du er landet på " + dummy.getName() + ".";
    }

    @Override
    public String type() {
        return "jailvisit";
    }

    public Dummy getDummy() {
        return dummy;
    }

    //Ways to get out of jail
    //Bail
    //Double
    //Card

public void bailOut(Player player){
        if(player.isJail() == true){
            if(player.getMoney() >= BAIL) {
                player.setMoney(player.getMoney() - BAIL);
                player.setJail(false);
            }else
                System.out.println("Du har ikke penge nok til at løslades");
        }
}

    public void doubleOut(Player player) {
        if (player.isJail() == true) {
        if(player.getJailTurns() < 3){
            PlayerHandler playerHandler = new PlayerHandler();
            RaffleCup getOut = new RaffleCup();
            getOut.roll();
            die1 = Integer.valueOf(getOut.getOurRolls()[0]);
            die2 = Integer.valueOf(getOut.getOurRolls()[1]);
            if (die1 == die2) {
                player.setJail(false);
                player.setJailTurns(0);
                //Denne flytter spilleren deres slag, men en bedre måde eksisterer måske
                playerHandler.movePlayer(player,(die1 + die2));
            }
            else{
                System.out.println("Du slog ikke to ens og må forblive i fængsel");
                player.setJailTurns(player.getJailTurns() + 1);
                //Next players turn
            }}
        else
        System.out.println("Du kan ikke slå terning fler gange, betal eller brug et kort");
        }
    }

    public void cardOut(Player player){
        if(player.isJail() == true){
            if(player.isGetOutOfJailCard() == true){
                player.setJail(false);
                player.setGetOutOfJailCard(false);
            }
            else
                System.out.println("Du har intet \"Get out of jail\" card");
        }
    }


}

