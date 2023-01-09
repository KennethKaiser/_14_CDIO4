package dtu.board;

import dtu.players.Player;

public abstract class Field {
    //Hvad en field bør indeholde
    String type;
    int placement;
    int familie;
    String name;
    int price;
    int housePrice;
    int rentNormal;
    int rent1House;
    int rent2House;
    int rent3House;
    int rent4House;
    int rentHotel;
    int pledge;

    public Field(String type,int placement, int familie, String name, int price, int housePrice, int rentNormal, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int pledge) {
        this.type = type;
        this.placement = placement;
        this.familie = familie;
        this.name = name;
        this.price = price;
        this.housePrice = housePrice;
        this.rent1House = rent1House;
        this.rent2House = rent2House;
        this.rent3House = rent3House;
        this.rent4House = rent4House;
        this.rentHotel = rentHotel;
        this.pledge = pledge;
    }



    public abstract void action(Player player);


}
