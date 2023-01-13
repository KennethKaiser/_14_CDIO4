package dtu.board;

import dtu.players.Player;
import dtu.players.PlayerHandler;

public class TaxField extends Field{

    private Tax tax;


    public TaxField(Tax tax) {
        this.tax = tax;
    }

    @Override
    public String landedLabel() {
        return "Du er landet på " + tax.getName()+".";
    }

    @Override
    public String type() {
        return "tax";
    }

    public Tax getTax() {
        return tax;
    }

    public void taxing(Player player, boolean choice){
        PlayerHandler playerHandler = new PlayerHandler();

        if(tax.getID() == 4){
            playerHandler.incomeTax(player, choice);
        }
        else if(tax.getID() == 38){
            playerHandler.changePlayerBalance(player, -2000);
        }

    }

}
