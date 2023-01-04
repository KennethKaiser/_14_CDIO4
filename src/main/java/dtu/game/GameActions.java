package dtu.game;

import dtu.board.Board;
import dtu.players.Player;

public class GameActions {

    private Board board = new Board();

    /**
     * Method for moving player based on how many times to move on board.
     * @param player
     * @param deltaMove
     */
    public static void movePlayer(Player player, int deltaMove){

        int nextFieldPlacement = player.getPosition() + deltaMove;

        player.setPosition(nextFieldPlacement);

    }
}
