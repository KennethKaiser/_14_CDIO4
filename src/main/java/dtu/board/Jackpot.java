package dtu.board;

public class Jackpot extends Field{


    private String name;
    private int amount;



    @Override
    public String landedLabel() {
        return "Du er landet på " + name + ".";
    }

    @Override
    public String type() {
        return "parking";
    }


    public void addToJackpot(int fine){
        amount += fine;
    }

    public void jackpotWin(){

        amount = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
