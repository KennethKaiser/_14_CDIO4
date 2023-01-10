package dtu.board;

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
        player.setJail(true);
    }


}
