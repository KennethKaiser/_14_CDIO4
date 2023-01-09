package dtu.board;

import dtu.players.Player;

public class FieldProperty extends BuyableFields{

    protected Property property;
    //Har skrevet så disse to variable bruges mest i Property klassen
    private Boolean owned;
    private Player owner;

    private int activeRent;

    private int buildings;

    private boolean pledgeState;

    //PropertyHandler propertyHandler = new PropertyHandler();


    public FieldProperty(Property property){
        this.owned = false;
        this.property = property;
    }

    /**
     * Method for when the player lands on a property, getting the choice to buy it or must pay rent
     * @param player the player who landed on the field
     */
    @Override
    public void action(Player player) {
        if(owned == false){
            //En besked giver valget for at købe grunden
            //Hvis ja:
            //propertyHandler.buyProperty(player, property);
            //Hvis nej, intet
        }
        if(owned == true){
            //En besked fortæller summen af penge der gives og til hvem
            //propertyHandler.payRent(player, property);
        }
    }

    @Override
    public String landedLabel() {
        String s = "Du er landet på " + property.getName();

        return s;
    }



    @Override
    public String type() {
        return "buyablefield";
    }

    public Property getProperty() {
        return property;
    }

    public int getBuildings() {
        return buildings;
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

    public boolean isOwned(){
        return this.owned;
    }


    @Override
    public Boolean buy(Player player) {
        if(player.getMoney() >= this.property.getPrice()){
            player.setMoney(player.getMoney() - property.getPrice());
            this.owner = player;
            this.owned = true;
            this.activeRent = 0;
            this.pledgeState = false;
            player.getProperties().add(this);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void rent() {

    }
}
