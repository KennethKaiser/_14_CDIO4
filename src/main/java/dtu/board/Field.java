package dtu.board;

import dtu.players.Player;

public abstract class Field {

    protected Property property;


    public Field(){

    }



    public abstract void action(Player player);

    public abstract String landedLabel();

    public abstract String type();

    public Property getProperty() {
        return property;
    }
}
