package dtu.board;

public class Jackpot extends Field{


    private String name;
    private int amount;



    @Override
    public String landedLabel() {
        return "Du er landet på " + name + " .";
    }

    @Override
    public String type() {
        return "parking";
    }

    public void jackPotWin(){

        amount = 0;

    }


}
