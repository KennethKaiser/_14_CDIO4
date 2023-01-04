package dtu.board;

import dtu.players.Player;
import dtu.game.GameActions;

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
            GameActions.buyProperty(player, property);
            //Hvis nej, intet
        }
        if(property.getOwned() == true){
            //En besked fortæller summen af penge der gives og til hvem
            GameActions.payRent(player, property);
        }
    }
}
