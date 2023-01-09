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

    /*public void setActiveRent(int activeRent) {
        this.activeRent = activeRent;
    }*/

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

    //Maybe needs changes
    public void setActiveRent(int rentNumber){

        switch (rentNumber){
            case 0:
                activeRent = property.getRentNormal();
                buildings = 0;
                break;
            case 1:
                activeRent = property.getRent1House();
                buildings = 1;
                break;
            case 2:
                activeRent = property.getRent2House();
                buildings = 2;
                break;
            case 3:
                activeRent = property.getRent3House();
                buildings = 3;
                break;
            case 4:
                activeRent = property.getRent4House();
                buildings = 4;
                break;
            case 5:
                activeRent = property.getRentHotel();
                buildings = 5;
                break;
        }
    }


    public boolean isPledgeState() {
        return pledgeState;
    }
}
