package dtu.board;

import dtu.players.Player;

public class FieldProperty extends Field{

    private Property property;
    private Boolean owned;
    private Player owner;


    public FieldProperty(Property property){
        this.property = property;
    }


    @Override
    public void action(Player player) {
        if(property.getOwned() == false){
            //En besked giver valget for at købe grunden
            //Hvis ja:
            property.setOwner(player);
            property.setOwned(true);
            //Hvis nej, intet
        }
    }
}
