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





}
