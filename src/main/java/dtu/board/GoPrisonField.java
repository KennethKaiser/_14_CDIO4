package dtu.board;

import dtu.controllers.PlayerViewController;
import dtu.players.Player;
import dtu.players.PlayerHandler;

public class GoPrisonField extends Field {




    @Override
    public String landedLabel() {
        return "Du ryger direkte i fængsel!";
    }

    @Override
    public String type() {
        return "jail";
    }


    public void moveToPrison(Player player){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.movePlayerChanceCard(player, 10);
        //Tror ikke spilleren modtager penge for at gå forbi start.
        //Så der er fjernet nogen penge heller, for at kompensere.
        player.setJail(true);
    }


}
