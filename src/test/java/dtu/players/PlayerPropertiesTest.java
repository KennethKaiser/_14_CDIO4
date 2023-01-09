package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.PropertyHandler;
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
                valueOfProperties += valueOfProperties;
            }
        }
        FieldProperty testitest = (FieldProperty) ((FieldProperty) playerHandler.getPlayers()[0].getProperties().get(0));
        FieldProperty testitest1 = (FieldProperty) ((FieldProperty) playerHandler.getPlayers()[0].getProperties().get(1));

                assertEquals(1, testitest.getProperty().getID(), "Expecting player to own Rødovrevej, which has ID = 1");
        System.out.println("Expecting: 1" + " Received: " + testitest.getProperty().getID());
        assertEquals(3, testitest1.getProperty().getID());
        System.out.println("Expecting: 3" + " Received: " + testitest1.getProperty().getID());
        System.out.println(playerHandler.getPlayers()[0].getProperties().size());
        System.out.println("Prisen på Rødovrevej er: " + testitest.getProperty().getPrice());

        System.out.println(valueOfProperties);
    }

    @Test
    void houseValue() {
        PlayerHandler playerHandler = new PlayerHandler();
        ChanceCardFunctionality chanceCardFunctionality = new ChanceCardFunctionality();
        Player player = new Player(0, "test0", 4000, "black");
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");
        Board board = new Board();
        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[34];
        //FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty.buy(playerHandler.getPlayers()[0]);
        //fieldProperty1.buy(playerHandler.getPlayers()[0]);

        System.out.println(fieldProperty.getProperty().getName());


        int valueOfBuildings = 0;
        int familie1 = 0;
        int familie1HousePrice = 1000;
        int familie2 = 0;
        int familie2HusPris = 1000;
        int familie3 = 0;
        int familie3HusPris = 2000;
        int familie7 = 0;
        int familie7HousePrice = 4000;
        ArrayList<Field> playerProperties = playerHandler.getPlayers()[player.getId()].getProperties();
        if (playerHandler.getPlayers() != null) {
            for (int i = 0; i < playerProperties.size(); i++) {
                if (( == 7) {
                    familie7 = ((FieldProperty) playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getBuildings() * familie7HousePrice;

                }
                else if ((playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getProperty().getFamilie() == 1) {
                    familie1 = ((FieldProperty) playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getBuildings() * familie1HousePrice;
                }
            }
            System.out.println(familie7);
            System.out.println(familie1);
            }

        }

    @Test
    void setProperties() {
    }
}