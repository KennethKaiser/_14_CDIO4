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
        Board board = new Board();
        Player player = new Player(0, "test0", 4000, "black");
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");

        FieldProperty fieldProperty34 = (FieldProperty) board.getCurrentBoard()[34];
        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty34.buy(playerHandler.getPlayers()[0]);
        fieldProperty34.setBuildings(4);
        fieldProperty1.setBuildings(3);

        fieldProperty34.getProperty().getFamilie();

        System.out.println("antal bygninger på 34: " + fieldProperty34.getBuildings());
        System.out.println("familie for felt 34: " + fieldProperty34.getProperty().getFamilie());

        int familie1 = 0;
        int familie1HousePrice = ((FieldProperty) board.getCurrentBoard()[1]).getProperty().getHousePrice();
        int familie2 = 0;
        int familie2HousePrice = ((FieldProperty) board.getCurrentBoard()[6]).getProperty().getHousePrice();;
        int familie3 = 0;
        int familie3HousePrice = ((FieldProperty) board.getCurrentBoard()[11]).getProperty().getHousePrice();;
        int familie4 = 0;
        int familie4HousePrice = ((FieldProperty) board.getCurrentBoard()[16]).getProperty().getHousePrice();;
        int familie5 = 0;
        int familie5HousePrice = ((FieldProperty) board.getCurrentBoard()[21]).getProperty().getHousePrice();;
        int familie6 = 0;
        int familie6HousePrice = ((FieldProperty) board.getCurrentBoard()[26]).getProperty().getHousePrice();;
        int familie7 = 0;
        int familie7HousePrice = ((FieldProperty) board.getCurrentBoard()[31]).getProperty().getHousePrice();;
        int familie8 = 0;
        int familie8HousePrice = ((FieldProperty) board.getCurrentBoard()[37]).getProperty().getHousePrice();;
        ArrayList<Field> playerProperties = playerHandler.getPlayers()[player.getId()].getProperties();
        if (playerHandler.getPlayers() != null) {
            for (int i = 0; i < playerProperties.size(); i++) {
                int getBuildings = ((FieldProperty) playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getBuildings();
                int getFamily = ((FieldProperty)playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getProperty().getFamilie();
                if (getFamily == 1){
                    familie1 += getBuildings * familie1HousePrice;
                }
                else if (getFamily == 2){
                    familie2 += getBuildings * familie2HousePrice;
                }
                else if (getFamily == 3){
                    familie3 += getBuildings * familie3HousePrice;
                }
                else if (getFamily == 4){
                    familie4 += getBuildings * familie4HousePrice;
                }
                else if (getFamily == 5){
                    familie5 += getBuildings * familie5HousePrice;
                }
                else if (getFamily == 6){
                    familie6 += getBuildings * familie6HousePrice;
                }
                else if (getFamily == 7){
                    familie7 += getBuildings * familie7HousePrice;
                }
                else if (getFamily == 8){
                    familie8 += getBuildings * familie8HousePrice;
                }
            }
        }
    }

        @Test
        void setProperties () {

        }
    }
