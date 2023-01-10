package dtu.board;

import dtu.players.Player;

public class FieldProperty extends BuyableFields{

    protected Property property;
    //Har skrevet så disse to variable bruges mest i Property klassen
    private Boolean owned;
    private Player owner;
    private int buildings;


    private int familie;

    private boolean pledgeState;

    //PropertyHandler propertyHandler = new PropertyHandler();


    public FieldProperty(Property property){
        this.owned = false;
        this.property = property;
        this.familie = property.getFamilie();
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
            this.buildings = 0;
            this.pledgeState = false;
            player.getProperties().add(this);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void rent(Player player, int rent) {
        player.setMoney(player.getMoney() - rent);
        owner.setMoney(owner.getMoney() + rent);
    }

    //Maybe needs changes
    public int findActiveRent(){

        int temp = buildings;
        int activeRent = 0;

        HousingLogic housingLogic = new HousingLogic();

        if(housingLogic.checkForHasAllOfFamily(this, owner.getId())&&buildings==0){
            temp =10;
        }


        switch (temp){
            case 0:
                activeRent = property.getRentNormal();
                return activeRent;
            case 1:
                activeRent = property.getRent1House();
                return activeRent;
            case 2:
                activeRent = property.getRent2House();
                return activeRent;
            case 3:
                activeRent = property.getRent3House();
                return activeRent;
            case 4:
                activeRent = property.getRent4House();
                return activeRent;
            case 5:
                activeRent = property.getRentHotel();
                return activeRent;
            case 10:
                activeRent = 2*property.getRentNormal();
                return activeRent;
        }
        return activeRent;
    }


    public boolean isPledgeState() {
        return pledgeState;
    }

    public Boolean getOwned() {
        return owned;
    }

    public Player getOwner() {
        return owner;
    }

    public int getFamilie() {
        return familie;
    }

    public void setFamilie(int familie) {
        this.familie = familie;
    }

    public void setPledgeState(boolean pledgeState) {
        this.pledgeState = pledgeState;
    }


}
