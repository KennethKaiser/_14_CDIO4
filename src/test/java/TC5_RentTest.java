import dtu._14_cdio4.BoardController1;
import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.board.PropertyList;
import dtu.board.PropertyHandler;
import dtu.board.Board;
import dtu.controllers.BoardController;
import dtu.controllers.ControllerHandler;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TC5_RentTest {

    @Test
    void testPayRent() {
        //Variable
        int RENT = 50;
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        //Expected
        int lost = START_MONEY - RENT;
        int gained = (START_MONEY - PRICE) + RENT;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRentNormal());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    @Test
    void testPay2XRent() {
        //Variable
        int RENT = 50;
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        //Expected
        int lost = START_MONEY - (RENT * 2);
        int gained = (START_MONEY - (PRICE * 2)) + (RENT * 2);

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[3];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty2.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRentNormal());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    @Test
    void testPayRent1House() {
        //Variable
        int RENT = 250;
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        //Expected
        int lost = START_MONEY - RENT;
        int gained = (START_MONEY - PRICE) + RENT;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(1);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRent1House());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

}