package dtu.board;

import dtu.controllers.ControllerHandler;
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
        player.setPosition(10);
        //Tror ikke spilleren modtager penge for at gå forbi start.
        //Så der er ikke fjernet nogen penge heller, for at kompensere.
        player.setJail(true);
        ControllerHandler.getInstance().getBoardController().movePLayerOnGUI(player.getId(), 10);
        ControllerHandler.getInstance().getPlayerViewController().setInJailIcon(true, player.getId());
    }


}
