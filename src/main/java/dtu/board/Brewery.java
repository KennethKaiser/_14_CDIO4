package dtu.board;

public class Brewery {


    private int ID;
    private String name;
    private int family;
    private int price;
    private int rent1;
    private int rent2;

    public Brewery(int ID,String name, int family, int price, int rent1, int rent2) {
        this.ID = ID;
        this.name = name;
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

    public void setFamily(int family){this.family = family;}
}
