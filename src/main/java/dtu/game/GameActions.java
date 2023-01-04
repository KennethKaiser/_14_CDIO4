package dtu.game;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.players.Player;

public class GameActions {

    private Board board = new Board();

    /**
     * Method for moving player based on how many times to move on board.
     * @param player
     * @param deltaMove
     */
    public void movePlayer(Player player, int deltaMove){

        int nextFieldPlacement = player.getPosition() + deltaMove;

        player.setPosition(nextFieldPlacement);

    }

    public static void buyProperty(Player player, Property property){
        player.setMoney(player.getMoney() - property.getPrice());
        property.setOwner(player);
        property.setOwned(true);
        property.setActiveRent(0);
    }

    public static void payRent(Player player, Property property){

        player.setMoney(player.getMoney() - property.getActiveRent());
        property.getOwner().setMoney(property.getOwner().getMoney() + property.getActiveRent());
    }
}
