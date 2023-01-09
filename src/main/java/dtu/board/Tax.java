package dtu.board;

public class Tax {

    private int ID;
    private String name;
    private int amount;

    public Tax(int ID, String name, int amount) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
