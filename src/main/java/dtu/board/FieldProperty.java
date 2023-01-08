package dtu.board;

import dtu.players.Player;
import dtu.game.GameActions;

public class FieldProperty extends Field{

    private Property property;
    //Har skrevet så disse to variable bruges mest i Property klassen
    private Boolean owned;
    private Player owner;

    private int activeRent;

    private int buildings;


    public FieldProperty(Property property){
        this.property = property;
    }

    /**
     * Method for when the player lands on a property, getting the choice to buy it or must pay rent
     * @param player the player who landed on the field
     */
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


    public void setProperty(Property property) {
        this.property = property;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setActiveRent(int activeRent) {
        this.activeRent = activeRent;
    }

    public void setBuildings(int buildings) {
        this.buildings = buildings;
    }




}
