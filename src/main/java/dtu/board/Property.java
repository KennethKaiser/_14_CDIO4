package dtu.board;

import dtu.players.Player;

public class Property {

    private String name;
    private int price;
    private int housePrice;
    private int rentNormal, rent1House, rent2House, rent3House, rent4House, rentHotel;
    private int pledge;

    private int buildings;

    int ActiveRent;

    //Ejerskab
    private Boolean owned;
    private Player owner;

    public Property(String name, int price, int housePrice, int rentNormal, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int pledge) {
        this.name = name;
        this.price = price;
        this.housePrice = housePrice;
        this.rentNormal = rentNormal;
        this.rent1House = rent1House;
        this.rent2House = rent2House;
        this.rent3House = rent3House;
        this.rent4House = rent4House;
        this.rentHotel = rentHotel;
        this.pledge = pledge;
    }

    //Change the rent after the amount of buildings
    public void setActiveRent(int rentNumber){

        switch (rentNumber){
            case 0:
                ActiveRent = rentNormal;
                setBuidlings(0);
            break;
            case 1:
                ActiveRent = rent1House;
                setBuidlings(1);
            break;
            case 2:
                ActiveRent = rent2House;
                setBuidlings(2);
            break;
            case 3:
                ActiveRent = rent3House;
                setBuidlings(3);
            break;
            case 4:
                ActiveRent = rent4House;
                setBuidlings(4);
            break;
            case 5:
                ActiveRent = rentHotel;
                setBuidlings(5);
            break;
        }
    }

    public int getPrice() {
        return price;
    }

    public int setPrice(){
        return price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean ownership) {
        owned = ownership;
    }

    public int getActiveRent(){
        return ActiveRent;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int newPrice){housePrice = newPrice;}

    public void setBuidlings(int amount){buildings = amount;}

    public int getBuildings(){
        return buildings;}
}
