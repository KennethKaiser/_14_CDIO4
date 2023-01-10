package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.Property;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PlayerIsBankruptTest {

    @Test
    void playerIsBankruptTest() {
        ArrayList<Field> properties = new ArrayList<>();
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();

        playerHandler.initializePlayers(2);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");

        properties.add(board.getCurrentBoard()[1]);
        playerHandler.getPlayers()[0].setProperties(properties);
        FieldProperty fieldProperty = (FieldProperty) playerHandler.getPlayers()[0].getProperties().get(0);
        fieldProperty.setOwner(playerHandler.getPlayers()[0]);
        //fieldProperty.setOwned(true);
        //fieldProperty.setActiveRent(500);
        //fieldProperty.setBuildings(1);

        playerHandler.playerIsBankrupt(playerHandler.getPlayers()[0]);
        assertEquals(false, playerHandler.getPlayers()[0].isBankrupt());
    }
}

