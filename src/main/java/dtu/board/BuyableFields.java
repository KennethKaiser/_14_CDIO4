package dtu.board;

import dtu.players.Player;

public abstract class BuyableFields extends Field {


    public BuyableFields() {

    }

    public abstract Boolean buy(Player player);

    public abstract void rent(Player player, int rent);



}
