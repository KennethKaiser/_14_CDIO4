package dtu.board;

import dtu.controllers.BoardController;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testOtherSetFunctions() {
        //Variable
        final int RENT = 250;
        final int PLEDGE = 0;
        final int START_MONEY = 4000;
        final int PRICE = 1200;
        final int ID = 1;
        final int FAMILY = 1;
        final int HOUSEPRICE = 1000;
        int newPledge = 900;
        int newID = 2;
        int newFamilie = 3;
        int newPrice = 1500;
        int newHousePrice = 350;
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

        //Tester Pledge
        assertEquals(PLEDGE,fieldProperty1.getProperty().getPledge(),"expect property to pledge have: " + PLEDGE + ". property has " + fieldProperty1.getProperty().getPledge());

        fieldProperty1.getProperty().setPledge(newPledge);

        assertEquals(newPledge,fieldProperty1.getProperty().getPledge(),"expect property to pledge have: " + newPledge + ". property has " + fieldProperty1.getProperty().getPledge());

        //Tester ID
        assertEquals(ID,fieldProperty1.getProperty().getID(),"expect property to have ID: " + PLEDGE + ". property has " + fieldProperty1.getProperty().getID());

        fieldProperty1.getProperty().setID(newID);

        assertEquals(newID,fieldProperty1.getProperty().getID(),"expect property to have ID: " + newID + ". property has " + fieldProperty1.getProperty().getID());

        //Tester Family
        assertEquals(FAMILY,fieldProperty1.getProperty().getFamilie(),"expect property to have family: " + FAMILY + ". property has " + fieldProperty1.getProperty().getFamilie());

        fieldProperty1.getProperty().setFamilie(newFamilie);

        assertEquals(newFamilie,fieldProperty1.getProperty().getFamilie(),"expect property to have family: " + newFamilie + ". property has " + fieldProperty1.getProperty().getFamilie());

        //Tester Price
        assertEquals(PRICE,fieldProperty1.getProperty().getPrice(),"expect property to have price: " + PRICE + ". property has " + fieldProperty1.getProperty().getPrice());

        fieldProperty1.getProperty().setPrice(newPrice);

        assertEquals(newPrice,fieldProperty1.getProperty().getPrice(),"expect property to have: price" + newPrice + ". property has " + fieldProperty1.getProperty().getPrice());

        //Tester HousePrice
        assertEquals(HOUSEPRICE,fieldProperty1.getProperty().getHousePrice(),"expect property to have price: " + HOUSEPRICE + ". property has " + fieldProperty1.getProperty().getHousePrice());

        fieldProperty1.getProperty().setHousePrice(newHousePrice);

        assertEquals(newHousePrice,fieldProperty1.getProperty().getHousePrice(),"expect property to pledge have: " + newHousePrice + ". property has " + fieldProperty1.getProperty().getHousePrice());


    }

}