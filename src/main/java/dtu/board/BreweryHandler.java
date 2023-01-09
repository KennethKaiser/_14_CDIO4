package dtu.board;

import dtu.players.Player;

public class BreweryHandler {

    /**
     * Method for buying Brewey, takes money, changes ownership and sets rent
     * @param player the player buying the property
     * @param property the property being bought
     */
    public static void buyBrewery(Player player, Brewery brewery){
        if(player.getMoney() > brewery.getPrice()) {
            player.setMoney(player.getMoney() - brewery.getPrice());
            brewery.setOwner(player);
            brewery.setOwned(true);
            if(familie9[0].getOwner == familie9[1].getOwner) {

            }
        }
        else{System.out.println("Du har ikke penge nok");}
    }

}
