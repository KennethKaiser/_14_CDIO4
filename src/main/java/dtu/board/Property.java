package dtu.board;

public class Property {

    private String name;
    private int price;
    private int housePrice;
    private int rentNormal, rent1House, rent2House, rent3House, rent4House, rentHotel;
    private int pledge;

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
}
