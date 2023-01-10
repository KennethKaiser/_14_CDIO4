package dtu.board;

import dtu.players.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class FieldProperty extends BuyableFields{

    protected Property property;
    private Boolean owned;
    private Player owner;

    private int activeRent;

    private int buildings;


    private int familie;


    private ArrayList<Property> familieList1;
    int f1 = 0;
    private ArrayList<Property> familieList2;
    int f2 = 0;
    private ArrayList<Property> familieList3;
    int f3 = 0;
    private ArrayList<Property> familieList4;
    int f4 = 0;
    private ArrayList<Property> familieList5;
    int f5 = 0;
    private ArrayList<Property> familieList6;
    int f6 = 0;
    private ArrayList<Property> familieList7;
    int f7 = 0;
    private ArrayList<Property> familieList8;
    int f8 = 0;

    private boolean pledgeState;

    //PropertyHandler propertyHandler = new PropertyHandler();


    public FieldProperty(Property property){
        this.owned = false;
        this.property = property;
        this.familie = property.getFamilie();

        //Eksperiment med familie
        switch(property.getFamilie()){
            case 1:
                familieList1.add(property);
                break;
            case 2:
                familieList2.add(property);
                break;
            case 3:
                familieList3.add(property);
                break;
            case 4:
                familieList4.add(property);
                break;
            case 5:
                familieList5.add(property);
                break;
            case 6:
                familieList6.add(property);
                break;
            case 7:
                familieList7.add(property);
                break;
            case 8:
                familieList8.add(property);
                break;
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

    /*public void setActiveRent(int activeRent) {
        this.activeRent = activeRent;
    }*/

    public void setBuildings(int buildings) {
        this.buildings = buildings;
    }

    public boolean isOwned(){
        return this.owned;
    }

    private ArrayList getFamilie(int familieNr){
        ArrayList respond = new ArrayList(0);
        switch(familieNr) {
            case 1:
                respond = familieList1;
            break;
            case 2:
                respond = familieList2;
                break;
            case 3:
                respond = familieList3;
                break;
            case 4:
                respond = familieList4;
                break;
            case 5:
                respond = familieList5;
                break;
            case 6:
                respond = familieList6;
                break;
            case 7:
                respond = familieList7;
                break;
            case 8:
                respond = familieList8;
                break;
        }
        return respond;
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
    public void rent(Player player) {
        if(doubleRent(player) == true){
            player.setMoney(player.getMoney() - (activeRent * 2));
            owner.setMoney(owner.getMoney() + (activeRent * 2));
        }
        else {
            player.setMoney(player.getMoney() - activeRent);
            owner.setMoney(owner.getMoney() + activeRent);
        }
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

    private Boolean doubleRent(Player player) {
        Boolean respond = null;
        if (familie == 1 || familie == 8) {
            if (buildings == 0
                    && player.getProperties().contains(getFamilie(familie).get(0))
                    && player.getProperties().contains(getFamilie(familie).get(1))) {
                respond = true;
            } }else if (buildings == 0
                    && player.getProperties().contains(getFamilie(familie).get(0))
                && player.getProperties().contains(getFamilie(familie).get(1))
                && player.getProperties().contains(getFamilie(familie).get(2))) {
                respond = true;
            } else{
        respond = false;}
        return respond;
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

    public int getActiveRent() {
        return activeRent;
    }

    public int getFamilie(){return familie;}
}
