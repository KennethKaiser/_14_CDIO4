package dtu.players;

import dtu.board.Board;
import dtu.board.FieldProperty;
import dtu.chancecard.ChanceCardFunctionality;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerHandlerTest {

    @Test
    void getMoneyFromOtherPlayers() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 10000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");
        int testAmount = 500;

        playerHandler.getMoneyFromOtherPlayers(playerHandler.getPlayers()[0], testAmount);

        assertEquals(10000+(500*(playerHandler.getPlayers().length-1)), playerHandler.getPlayers()[0].getMoney(), "expecting 10000+500* amount of players. ");
        assertEquals(10000-(500*1), playerHandler.getPlayers()[1].getMoney());
        assertEquals(10000-(500*1), playerHandler.getPlayers()[2].getMoney());


    }

    @Test
    void incomeTax() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 10000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");


        playerHandler.incomeTax(playerHandler.getPlayers()[0], true);
        assertEquals(6000, playerHandler.getPlayers()[0].getMoney());
    }

    @Test
    void tenPercentTax() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 11250, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");
        playerHandler.incomeTax(playerHandler.getPlayers()[0], false);
        assertEquals(10100, playerHandler.getPlayers()[0].getMoney());
    }

    @Test
    void valueOfAllHousesOnPlayerProperties() {
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 50000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty6 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty6.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty11 = (FieldProperty) board.getCurrentBoard()[11];
        fieldProperty11.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty16 = (FieldProperty) board.getCurrentBoard()[16];
        fieldProperty16.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty21 = (FieldProperty) board.getCurrentBoard()[21];
        fieldProperty21.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty26 = (FieldProperty) board.getCurrentBoard()[26];
        fieldProperty26.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty31 = (FieldProperty) board.getCurrentBoard()[31];
        fieldProperty31.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty37 = (FieldProperty) board.getCurrentBoard()[37];
        fieldProperty37.buy(playerHandler.getPlayers()[0]);


        fieldProperty1.setBuildings(3);
        fieldProperty6.setBuildings(2);
        fieldProperty11.setBuildings(2);
        fieldProperty16.setBuildings(2);
        fieldProperty21.setBuildings(2);
        fieldProperty26.setBuildings(2);
        fieldProperty31.setBuildings(2);
        fieldProperty37.setBuildings(4);


        assertEquals(49000, playerHandler.valueOfAllHousesOnPlayerProperties(playerHandler.getPlayers()[0]));
    }

    @Test
    void getValueOfPlayersProperties() {
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 42000, "black");
        playerHandler .initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty6 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty6.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty11 = (FieldProperty) board.getCurrentBoard()[11];
        fieldProperty11.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty16 = (FieldProperty) board.getCurrentBoard()[16];
        fieldProperty16.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty21 = (FieldProperty) board.getCurrentBoard()[21];
        fieldProperty21.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty26 = (FieldProperty) board.getCurrentBoard()[26];
        fieldProperty26.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty31 = (FieldProperty) board.getCurrentBoard()[31];
        fieldProperty31.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty37 = (FieldProperty) board.getCurrentBoard()[37];
        fieldProperty37.buy(playerHandler.getPlayers()[0]);


        assertEquals(32200, playerHandler.getValueOfPlayersProperties(playerHandler.getPlayers()[0]));
        assertEquals(0, playerHandler.getValueOfPlayersProperties(playerHandler.getPlayers()[1]));
    }

    @Test
    void valueOfAllAssets() {
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 11250, "black");
        playerHandler .initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        FieldProperty fieldProperty34 = (FieldProperty) board.getCurrentBoard()[34];
        ((FieldProperty) board.getCurrentBoard()[34]).buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        ((FieldProperty) board.getCurrentBoard()[1]).buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(3);
        fieldProperty34.setBuildings(4);

        //We expect player 0 have: 11250 from getMoney minus 7600 from price of properties 34 and 1 bought above + 19000 from houses. + 7600 from properties.
        assertEquals(30250, playerHandler.valueOfAllAssets(playerHandler.getPlayers()[0]));
    }

    @Test
    void nearestFerryTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 10000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        playerHandler.getPlayers()[0].setPosition(38);
        playerHandler.nearestFerry(playerHandler.getPlayers()[0]);
        assertEquals(5, playerHandler.getPlayers()[0].getPosition());
        playerHandler.getPlayers()[0].setPosition(6);
        playerHandler.nearestFerry(playerHandler.getPlayers()[0]);
        assertEquals(15, playerHandler.getPlayers()[0].getPosition());
        playerHandler.getPlayers()[0].setPosition(16);
        playerHandler.nearestFerry(playerHandler.getPlayers()[0]);
        assertEquals(25, playerHandler.getPlayers()[0].getPosition());
        playerHandler.getPlayers()[0].setPosition(26);
        playerHandler.nearestFerry(playerHandler.getPlayers()[0]);
        assertEquals(35, playerHandler.getPlayers()[0].getPosition());
    }

    @Test
    void amountOfHouses(){
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 42000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty6 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty6.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty11 = (FieldProperty) board.getCurrentBoard()[11];
        fieldProperty11.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty16 = (FieldProperty) board.getCurrentBoard()[16];
        fieldProperty16.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty21 = (FieldProperty) board.getCurrentBoard()[21];
        fieldProperty21.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty26 = (FieldProperty) board.getCurrentBoard()[26];
        fieldProperty26.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty31 = (FieldProperty) board.getCurrentBoard()[31];
        fieldProperty31.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty37 = (FieldProperty) board.getCurrentBoard()[37];
        fieldProperty37.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(5);
        fieldProperty6.setBuildings(2);
        fieldProperty11.setBuildings(2);
        fieldProperty16.setBuildings(2);
        fieldProperty21.setBuildings(2);
        fieldProperty26.setBuildings(2);
        fieldProperty31.setBuildings(2);
        fieldProperty37.setBuildings(4);


        assertEquals(2+2+2+2+2+2+4, playerHandler.amountOfHouses(playerHandler.getPlayers()[0]));
    }

    @Test
    void playerStartMoneyTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 0, "red");

        playerHandler.playerStartMoney(playerHandler.getPlayers()[0]);
        assertEquals(30000, playerHandler.getPlayers()[0].getMoney());
        assertEquals(30000, playerHandler.getPlayers()[1].getMoney());
        assertEquals(30000, playerHandler.getPlayers()[2].getMoney());
    }

    @Test
    void currentPlayerTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 0, "red");

        playerHandler.setCurrentPlayer(playerHandler.getPlayers()[2]);
        assertEquals(playerHandler.getPlayers()[2], playerHandler.getCurrentPlayer());
        playerHandler.currentPlayer();
        assertEquals(playerHandler.getPlayers()[0], playerHandler.getCurrentPlayer());
    }

    @Test
    void amountOfHotels(){
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 42000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty6 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty6.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty11 = (FieldProperty) board.getCurrentBoard()[11];
        fieldProperty11.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty16 = (FieldProperty) board.getCurrentBoard()[16];
        fieldProperty16.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty21 = (FieldProperty) board.getCurrentBoard()[21];
        fieldProperty21.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty26 = (FieldProperty) board.getCurrentBoard()[26];
        fieldProperty26.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty31 = (FieldProperty) board.getCurrentBoard()[31];
        fieldProperty31.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty37 = (FieldProperty) board.getCurrentBoard()[37];
        fieldProperty37.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(5);
        fieldProperty6.setBuildings(2);
        fieldProperty11.setBuildings(2);
        fieldProperty16.setBuildings(2);
        fieldProperty21.setBuildings(2);
        fieldProperty26.setBuildings(2);
        fieldProperty31.setBuildings(2);
        fieldProperty37.setBuildings(4);

        assertEquals(1, playerHandler.amountOfHotels(playerHandler.getPlayers()[0]));
    }

    @Test
    void whoWonTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 42000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        playerHandler.getPlayers()[0].setMoney(-1);
        playerHandler.isPlayerBankrupt(playerHandler.getPlayers()[0]);
        playerHandler.getPlayers()[2].setMoney(-1);
        playerHandler.isPlayerBankrupt(playerHandler.getPlayers()[2]);
        playerHandler.changePlayerArray();
        System.out.println(playerHandler.getPlayers().length);

    }

    @Test
    void nonPledgeTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        assertEquals(400, playerHandler.nonPledgeTax(3100));
    }
}