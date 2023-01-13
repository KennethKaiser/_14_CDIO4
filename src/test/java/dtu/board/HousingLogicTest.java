package dtu.board;

import dtu.controllers.BoardController;
import dtu.players.PlayerHandler;
import dtu.board.HousingLogic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Skal muligvis ændres hvis Parkering giver penge sum
class HousingLogicTest {


    //VIGTIG BESKED!:
    //Alle HousingLogic CheckForHasAllOfFamily giver nullPointException. Toby har lavet den og ved måske hvordan det fikses

    @Test
    void testCheckForHasAllOfFamily() {
        //Variable
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        HousingLogic housingLogic = new HousingLogic();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);

       //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.checkForHasAllOfFamily(fieldProperty1,0),
                "Expect player to have all family as: "+ false +". Player is: "+ housingLogic.checkForHasAllOfFamily(fieldProperty1,0));


        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[3];
        fieldProperty2.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren har alle
        assertEquals(true, housingLogic.checkForHasAllOfFamily(fieldProperty2,0),
                "Expect player to have all family as: "+ true +". Player is: "+ housingLogic.checkForHasAllOfFamily(fieldProperty1,0));

    }

    @Test
    void testCheckForHasAllOfFamily2() {
        //CheckForHasAllOfFamily giver nullPointException
        //Variable
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        HousingLogic housingLogic = new HousingLogic();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.checkForHasAllOfFamily(fieldProperty1,0),
                "Expect player to have all family as: "+ false +". Player is: "+ housingLogic.checkForHasAllOfFamily(fieldProperty1,0));


        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[8];
        fieldProperty2.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty3 = (FieldProperty) board.getCurrentBoard()[9];
        fieldProperty3.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren har alle
        assertEquals(true, housingLogic.checkForHasAllOfFamily(fieldProperty2,0),
                "Expect player to have all family as: "+ true +". Player is: "+ housingLogic.checkForHasAllOfFamily(fieldProperty1,0));

    }

    @Test
    void testCanBuild() {
        //CheckForHasAllOfFamily giver nullPointException
        //Variable
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        HousingLogic housingLogic = new HousingLogic();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.canBuild(fieldProperty1,0),
                "Expect player to have buildpermit as: "+ false +". Player is: "+ housingLogic.canBuild(fieldProperty1,0));


        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[8];
        fieldProperty2.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty3 = (FieldProperty) board.getCurrentBoard()[9];
        fieldProperty3.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren har alle
        assertEquals(true, housingLogic.canBuild(fieldProperty2,0),
                "Expect player to have buildpermit as: "+ true +". Player is: "+ housingLogic.canBuild(fieldProperty1,0));

        fieldProperty1.setBuildings(1);

        //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.canBuild(fieldProperty1,0),
                "Expect player to have buildpermit as: "+ false +". Player is: "+ housingLogic.canBuild(fieldProperty1,0));

    }

    @Test
    void testCanRemove() {
        //CheckForHasAllOfFamily giver nullPointException
        //Variable
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        HousingLogic housingLogic = new HousingLogic();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[6];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[8];
        fieldProperty2.buy(playerHandler.getPlayers()[0]);
        FieldProperty fieldProperty3 = (FieldProperty) board.getCurrentBoard()[9];
        fieldProperty3.buy(playerHandler.getPlayers()[0]);

        fieldProperty1.setBuildings(1);

        //Tester at spilleren har alle
        assertEquals(true, housingLogic.canRemove(fieldProperty1,0),
                "Expect player to have removePermit as: "+ true +". Player is: "+ housingLogic.canRemove(fieldProperty1,0));

        fieldProperty2.setBuildings(2);
        fieldProperty3.setBuildings(2);

        //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.canBuild(fieldProperty1,0),
                "Expect player to have removePermit as: "+ false +". Player is: "+ housingLogic.canRemove(fieldProperty1,0));

    }

    @Test
    void testCanAfford() {
        //CheckForHasAllOfFamily giver nullPointException
        //Variable
        final int START_MONEY = 1300;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        HousingLogic housingLogic = new HousingLogic();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[6];
        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[8];
        FieldProperty fieldProperty3 = (FieldProperty) board.getCurrentBoard()[9];

        //Tester at spilleren har råd
        assertEquals(true, housingLogic.canAfford(fieldProperty1,0),
                "Expect player to have afford as: "+ true +". Player has: "+ housingLogic.canAfford(fieldProperty1,0));

        fieldProperty2.buy(playerHandler.getPlayers()[0]);

        //Tester at spilleren ikke har alle
        assertEquals(false, housingLogic.canAfford(fieldProperty2,0),
                "Expect player to have afford as: "+ false +". Player has: "+ housingLogic.canAfford(fieldProperty1,0));

    }


}