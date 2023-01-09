package dtu.board;

import dtu.players.Player;

public class FieldProperty extends BuyableFields{

    protected Property property;
    //Har skrevet så disse to variable bruges mest i Property klassen
    private Boolean owned;
    private Player owner;

    private int activeRent;

    private int buildings;


    public FieldProperty(Property property){
        super(property);
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
            PropertyHandler.buyProperty(player, property);
            //Hvis nej, intet
        }
        if(property.getOwned() == true){
            //En besked fortæller summen af penge der gives og til hvem
            PropertyHandler.payRent(player, property);
        }
    }

    public Property getProperty() {
        return property;
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


    @Override
    public void buy() {

    }

    @Override
    public void rent() {

    }
}
