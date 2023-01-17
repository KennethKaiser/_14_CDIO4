package dtu.board;

import dtu.controllers.ControllerHandler;
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
        return "Du er ryger direkte i fængsel.";
    }

    @Override
    public String type() {
        return "jail";
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
                if(ControllerHandler.getInstance().getPlayerViewController() != null){
                    ControllerHandler.getInstance().getPlayerViewController().setInJailIcon(false, player.getId());
                }

            }else
                System.out.println("Du har ikke penge nok til at løslades");
        }
}



    public void cardOut(Player player){
        if(player.isJail() == true){
            if(player.isGetOutOfJailCard() == true){
                if(ControllerHandler.getInstance().getPlayerViewController() != null){
                    ControllerHandler.getInstance().getPlayerViewController().setGetOutOfJailFreeCard(false, player.getId());
                    ControllerHandler.getInstance().getPlayerViewController().setInJailIcon(false, player.getId());
                }
                player.setJail(false);
                player.setGetOutOfJailCard(false);
            }
            else
                System.out.println("Du har intet \"Get out of jail\" card");
        }
    }


}

