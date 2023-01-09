package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerPropertiesTest {

    @Test
    void getProperties() {
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        Player player = new Player(0, "test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");
        ArrayList<Field> properties = new ArrayList<>();
        properties.add(board.getCurrentBoard()[1]);
        player.setProperties(properties);

        System.out.println(player.getProperties());
    }

    @Test
    void setProperties() {
    }
}