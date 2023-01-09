package dtu.board;

public class Brewery {

    private String name;
    private int price;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int placement;
    private int family;
    private String type;

    public Brewery(String name, int placement, String type, int family, int price, int rent1, int rent2) {
        this.name = name;
        this.placement = placement;
        this.type = type;
        this.family = family;
        this.price = price;
        this.rent1 = rent1;
        this.rent2 = rent2;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getRent1() {
        return rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public int getPlacement(){return placement;}

    public String getType(){return type;}

    public int getFamily(){return family;}

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {this.price = price;}

    public void setRent1(int rent1) {
        this.rent1 = rent1;
    }

    public void setRent2(int rent2) { this.rent2 = rent2;}

    public void setPlacement(int placement){this.placement = placement;}

    public void setType(String type){this.type = type;}

    public void setFamily(int family){this.family = family;}
}
