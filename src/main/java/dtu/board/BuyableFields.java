package dtu.board;

import dtu.players.Player;

public abstract class BuyableFields extends Field {


    public BuyableFields(Property property) {
        super(property);
    }

    public abstract Boolean buy(Player player);

    public abstract void rent();



}
