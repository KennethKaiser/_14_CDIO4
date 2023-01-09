package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.chancecard.ChanceCardFunctionality;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerPropertiesTest {



    @Test
    void getProperties() {
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        ChanceCardFunctionality chanceCardFunctionality = new ChanceCardFunctionality();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");

        ArrayList<Field> properties = new ArrayList<>();
        properties.add(board.getCurrentBoard()[1]);
        properties.add(board.getCurrentBoard()[3]);
        playerHandler.getPlayers()[0].setProperties(properties);
        FieldProperty fieldProperty = (FieldProperty) playerHandler.getPlayers()[0].getProperties().get(0);
        fieldProperty.setOwner(playerHandler.getPlayers()[0]);

        //This is a stub of a method in Java
        int valueOfProperties = 0;
        if (playerHandler.getPlayers() != null) {
            for (int i = 0; i < playerHandler.getPlayers()[0].getProperties().size(); i++) {
                valueOfProperties += playerHandler.getPlayers()[0].getProperties().get(i).getProperty().getPrice();
            }
        }

        assertEquals(1, playerHandler.getPlayers()[0].getProperties().get(0).getProperty().getID(), "Expecting player to own Rødovrevej, which has ID = 1");
        System.out.println("Expecting: 1" + " Received: " + playerHandler.getPlayers()[0].getProperties().get(0).getProperty().getID());
        assertEquals(3, playerHandler.getPlayers()[0].getProperties().get(1).getProperty().getID());
        System.out.println("Expecting: 3" + " Received: " + playerHandler.getPlayers()[0].getProperties().get(1).getProperty().getID());
        System.out.println(playerHandler.getPlayers()[0].getProperties().size());
        System.out.println("Prisen på Rødovrevej er: " + playerHandler.getPlayers()[0].getProperties().get(0).getProperty().getPrice());

        System.out.println(valueOfProperties);
    }

    @Test
    void setProperties() {
    }
}