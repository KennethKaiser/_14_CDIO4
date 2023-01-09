package dtu.board;

import dtu.dice.RaffleCup;
import dtu.players.Player;

import static dtu.board.Board.familie9;

public class BreweryHandler {

    /**
     * Method for buying Brewey, takes money, changes ownership and sets rent
     * @param player the player buying the property
     * @param brewery the brewery being bought
     */
    public static void buyBrewery(Player player, Brewery brewery){
        if(player.getMoney() > brewery.getPrice()) {
            player.setMoney(player.getMoney() - brewery.getPrice());
            brewery.setOwner(player);
            brewery.setOwned(true);
        }
        else{System.out.println("Du har ikke penge nok");}
    }

    public static void payRent(Player player, Brewery brewery) {

        if(familie9[0].getOwner() == familie9[1].getOwner()) {
            RaffleCup rentRoll = new RaffleCup;
            rentRoll.roll();
            player.setMoney(player.getMoney() - (brewery.getRent2())* RaffleCup.);
        }
            else{
                player.setMoney(player.getMoney() - property.getActiveRent());
                property.getOwner().setMoney(property.getOwner().getMoney() + property.getActiveRent());
            }
        }}

}
