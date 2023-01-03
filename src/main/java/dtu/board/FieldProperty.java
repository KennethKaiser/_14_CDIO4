package dtu.board;

import dtu.players.Player;

public class FieldProperty extends BuyableFields{

    private Property property;
    private Boolean owned;
    private Player owner;


    public FieldProperty(Property property){
        this.property = property;
    }


    @Override
    public void action() {

    }

    @Override
    public void buy() {

    }
}
