package dtu.board;

import dtu.players.Player;

public class FerryField extends BuyableFields{


    private Ferry ferry;

    public FerryField(Ferry ferry){
        this.ferry = ferry;
    }


    @Override
    public Boolean buy(Player player) {
        return null;
    }

    @Override
    public void rent() {

    }


    @Override
    public String landedLabel() {
        return null;
    }

    @Override
    public String type() {
        return "ferry";
    }


    public Ferry getFerry() {
        return ferry;
    }
}
