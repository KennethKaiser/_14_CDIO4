package dtu.board;

public class Ferry {

    private int ID;
    private String name;

    private int familie;
    private int price;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;

    public Ferry(int ID, String name, int familie, int price, int rent1, int rent2, int rent3, int rent4) {
        this.ID = ID;
        this.name = name;
        this.familie = familie;
        this.price = price;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
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

    public int getRent3() {
        return rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public int getID() {
        return ID;
    }
}
