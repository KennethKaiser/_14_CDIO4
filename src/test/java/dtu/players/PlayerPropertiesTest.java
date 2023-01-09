package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerPropertiesTest {

    @Test
    void getProperties() {
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");

        ArrayList<Field> properties = new ArrayList<>();
        properties.add(board.getCurrentBoard()[1]);
        playerHandler.getPlayers()[0].setProperties(properties);
        FieldProperty fieldProperty = (FieldProperty) playerHandler.getPlayers()[0].getProperties().get(0);
        fieldProperty.setOwner(playerHandler.getPlayers()[0]);

        System.out.println(playerHandler.getPlayers()[0].getProperties().get(0).getProperty().getName());
    }

    @Test
    void setProperties() {
    }
}