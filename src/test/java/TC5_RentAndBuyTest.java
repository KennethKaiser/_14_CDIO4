import dtu.board.FieldProperty;
import dtu.board.Board;
import dtu.controllers.BoardController;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TC5_RentAndBuyTest {

    @Test
    void testBuyProperty() {
        //Variable
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        //Expected
        int newMoney = START_MONEY - PRICE;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);


        //Tester at spilleren mistede penge og er ejer
        assertEquals(newMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + newMoney + ". player1 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty1.getOwner(),"expect Rødovrevej to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej ejes af: " + fieldProperty1.getOwner());
    }

    @Test
    void testBuyPropertyNoCash() {
        //Variable
        final int START_MONEY = 1000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);


        //Tester at spilleren ikke mistede penge og ikke er ejer
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + START_MONEY + ". player1 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(null,fieldProperty1.getOwner(),"expect Rødovrevej to be owned by: " + null + ". Rødovrevej ejes af: " + fieldProperty1.getOwner());
    }

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

    @Test
    void testPayRent2House() {
        //Variable
        int RENT = 750;
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
        fieldProperty1.setBuildings(2);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRent2House());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    @Test
    void testPayRent3House() {
        //Variable
        int RENT = 2250;
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
        fieldProperty1.setBuildings(3);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRent3House());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    @Test
    void testPayRent4House() {
        //Variable
        int RENT = 4000;
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
        fieldProperty1.setBuildings(4);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRent4House());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    @Test
    void testPayRentHotel() {
        //Variable
        int RENT = 6000;
        final int START_MONEY = 4100;
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
        fieldProperty1.setBuildings(5);
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRentHotel());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(gained,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + gained + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(lost,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + lost + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

    //Pledge er ikke færdig og således er pledgeRent testen heller ikke
    @Test
    void testPayRentPledge() {
        //Variable
        int RENT = 250;
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        //Expected
        int afterbuy = (START_MONEY - PRICE) + (PRICE / 2);

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        //Spiller1 skal nu sætte property til pledge
        fieldProperty1.rent(playerHandler.getPlayers()[1], fieldProperty1.getProperty().getRent1House());


        //Tester at den ene spiller mistede penge og den anden fik
        assertEquals(afterbuy,playerHandler.getPlayers()[0].getMoney(),"expect player1 to have: " + afterbuy + ". player1 has " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to have: " + START_MONEY + ". Player 2 has: "+ playerHandler.getPlayers()[1].getMoney());
    }

}