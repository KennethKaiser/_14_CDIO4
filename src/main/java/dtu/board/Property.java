package dtu.board;

import dtu.players.Player;

public class Property {

   private int ID;//ID er hvilket felt på boardet de står ved Rødovrevej starter som 0.
    private String name;
    private int price;
    private int housePrice;
    private int rentNormal, rent1House, rent2House, rent3House, rent4House, rentHotel;
    private int pledge;
    private int familie;


    public Property(int ID, int familie, String name, int price, int housePrice, int rentNormal, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int pledge) {
        this.ID = ID;
        this.familie = familie;
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


    public int getPrice() {
        return price;
    }

    public int setPrice(){
        return price;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int newPrice){housePrice = newPrice;}

    public int getFamilie(){
        return familie;
    }

    public void setFamilie(int newFamilie){
        familie = newFamilie;
    }

    public int getID(){
        return ID;
    }

    public void setID(int newID){
        ID = newID;
    }


    public int getPledge(){
        return pledge;
    }

    public void setPledge(int newPledge){
        pledge = newPledge;}

    public String getName() {
        return name;
    }

    public int getRentNormal() {
        return rentNormal;
    }

    public int getRent1House() {
        return rent1House;
    }

    public int getRent2House() {
        return rent2House;
    }

    public int getRent3House() {
        return rent3House;
    }

    public int getRent4House() {
        return rent4House;
    }

    public int getRentHotel() {
        return rentHotel;
    }
}
