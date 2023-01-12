package dtu.board;

import dtu.board.Board;
import dtu.board.FieldProperty;
import dtu.controllers.BoardController;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TC6_PropertyTest {

    @Test
    void testRødovrevej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 1200;
        final int HOUSE = 1000;
        final int RENT = 50;
        final int RENT1 = 250;
        final int RENT2 = 750;
        final int RENT3 = 2250;
        final int RENT4 = 4000;
        final int RENT5 = 6000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[1];

        //Test Rødovrevej. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect Rødovrevej to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

        //Test at Rødovrevej er det rette felt
        assertEquals("Rødovrevej",fieldProperty.getProperty().getName(),"expect Rødovrevej to at start be named: " + "Rødovrevej" + ". Rødovrevej is named: " + fieldProperty.getProperty().getName());
        assertEquals(1,fieldProperty.getProperty().getID(),"expect Rødovrevej to have ID: " + 1 + ". Rødovrevej has ID: " + fieldProperty.getProperty().getID());
        assertEquals(1,fieldProperty.getProperty().getFamilie(),"expect Rødovrevej to have family: " + 1 + ". Rødovrevej has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test Rødovrevej. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test Rødovrevej. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test Rødovrevej. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test Rødovrevej. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test Rødovrevej. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test Rødovrevej. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test Rødovrevej. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Rødovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testHvidovrevej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 1200;
        final int HOUSE = 1000;
        final int RENT = 50;
        final int RENT1 = 250;
        final int RENT2 = 400;
        final int RENT3 = 750;
        final int RENT4 = 2250;
        final int RENT5 = 6000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[3];

        //Test Hvidovrevej. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect Hvidovrevej to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

//Test at Hvidovrevej er det rette felt
        assertEquals("Hvidovrevej",fieldProperty.getProperty().getName(),"expect Hvidovrevej to at start be named: " + "Hvidovrevej" + ". Hvidovrevej is named: " + fieldProperty.getProperty().getName());
        assertEquals(3,fieldProperty.getProperty().getID(),"expect Hvidovrevej to have ID: " + 3 + ". Hvidovrevej has ID: " + fieldProperty.getProperty().getID());
        assertEquals(1,fieldProperty.getProperty().getFamilie(),"expect Hvidovrevej to have family: " + 1 + ". Hvidovrevej has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test Hvidovrevej. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect hvidovrevej after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test hvidovrevej. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test Hvidovrevej. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test Hvidovrevej. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test Hvidovrevej. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test Hvidovrevej. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test Hvidovrevej. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Hvidovrevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testRoskildevej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 2000;
        final int HOUSE = 1000;
        final int RENT = 100;
        final int RENT1 = 600;
        final int RENT2 = 1800;
        final int RENT3 = 5400;
        final int RENT4 = 8000;
        final int RENT5 = 11000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[6];

        //Test Roskildevej. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect Roskildevej to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

        //Test at Roskildevej er det rette felt
        assertEquals("Roskildevej",fieldProperty.getProperty().getName(),"expect Roskildevej to at start be named: " + "Roskildevej" + ". Roskildevej is named: " + fieldProperty.getProperty().getName());
        assertEquals(6,fieldProperty.getProperty().getID(),"expect Roskildevej to have ID: " + 6 + ". Roskildevej has ID: " + fieldProperty.getProperty().getID());
        assertEquals(2,fieldProperty.getProperty().getFamilie(),"expect Roskildevej to have family: " + 2 + ". Roskildevej has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test Roskildevej. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test Roskildevej. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test Roskildevej. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test Roskildevej. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test Roskildevej. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test Roskildevej. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test Roskildevej. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Roskildevej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testValbyLanggade() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 2000;
        final int HOUSE = 1000;
        final int RENT = 100;
        final int RENT1 = 600;
        final int RENT2 = 1800;
        final int RENT3 = 5400;
        final int RENT4 = 8000;
        final int RENT5 = 11000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[8];

        //Test ValbyLanggade. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect ValbyLanggade to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

        //Test at ValbyLanggade er det rette felt
        assertEquals("Valby Langgade",fieldProperty.getProperty().getName(),"expectValby Langgade to at start be named: " + "Valby Langgade" + ". ValbyLanggade is named: " + fieldProperty.getProperty().getName());
        assertEquals(8,fieldProperty.getProperty().getID(),"expect ValbyLanggade to have ID: " + 8 + ". ValbyLanggade has ID: " + fieldProperty.getProperty().getID());
        assertEquals(2,fieldProperty.getProperty().getFamilie(),"expect ValbyLanggade to have family: " + 2 + ". ValbyLanggade has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test ValbyLanggade. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test ValbyLanggade. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test ValbyLanggade. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test ValbyLanggade. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test ValbyLanggade. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test ValbyLanggade. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test ValbyLanggade. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect ValbyLanggade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testAllégade() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 2400;
        final int HOUSE = 1000;
        final int RENT = 150;
        final int RENT1 = 800;
        final int RENT2 = 2000;
        final int RENT3 = 6000;
        final int RENT4 = 9000;
        final int RENT5 = 12000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[9];

        //Test Allégade. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect Allégade to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

        //Test at Allégade er det rette felt
        assertEquals("Allégade",fieldProperty.getProperty().getName(),"expect Allégade to at start be named: " + "Allégade" + ". Allégade is named: " + fieldProperty.getProperty().getName());
        assertEquals(9,fieldProperty.getProperty().getID(),"expect Allégade to have ID: " + 9 + ". Allégade has ID: " + fieldProperty.getProperty().getID());
        assertEquals(2,fieldProperty.getProperty().getFamilie(),"expect Allégade to have family: " + 2 + ". Allégade has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test Allégade. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test Allégade. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test Allégade. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test Allégade. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test Allégade. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test Allégade. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test Allégade. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Allégade after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testFrederiksbergAllé() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 2800;
        final int HOUSE = 2000;
        final int RENT = 200;
        final int RENT1 = 1000;
        final int RENT2 = 3000;
        final int RENT3 = 9000;
        final int RENT4 = 12500;
        final int RENT5 = 15000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[11];

        //Test FrederiksbergAllé. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect FrederiksbergAllé to at start be owned by: " + null + ". Rødovrevej is at start owned by: " + fieldProperty.getOwner());

        //Test at FrederiksbergAllé er det rette felt
        assertEquals("Frederiksberg Allé",fieldProperty.getProperty().getName(),"expect FrederiksbergAllé to at start be named: " + "Frederiksberg Allé" + ". FrederiksbergAllé is named: " + fieldProperty.getProperty().getName());
        assertEquals(11,fieldProperty.getProperty().getID(),"expect FrederiksbergAllé to have ID: " + 11 + ". FrederiksbergAllé has ID: " + fieldProperty.getProperty().getID());
        assertEquals(3,fieldProperty.getProperty().getFamilie(),"expect FrederiksbergAllé to have family: " + 3 + ". FrederiksbergAllé has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test FrederiksbergAllé. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test FrederiksbergAllé. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test FrederiksbergAllé. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test FrederiksbergAllé. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test FrederiksbergAllé. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test FrederiksbergAllé. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft4Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft4Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test FrederiksbergAllé. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + Aft5Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAft5Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect FrederiksbergAllé after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Rødovrevej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testBülowsvej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 2800;
        final int HOUSE = 2000;
        final int RENT = 200;
        final int RENT1 = 1000;
        final int RENT2 = 3000;
        final int RENT3 = 9000;
        final int RENT4 = 12500;
        final int RENT5 = 15000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[13];

        //Test Bülowsvej. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect FrederiksbergAllé to at start be owned by: " + null + ". Bülowsvej is at start owned by: " + fieldProperty.getOwner());

        //Test at Bülowsvej er det rette felt
        assertEquals("Bülowsvej",fieldProperty.getProperty().getName(),"expect Bülowsvej to at start be named: " + "Bülowsvej" + ". Bülowsvej is named: " + fieldProperty.getProperty().getName());
        assertEquals(13,fieldProperty.getProperty().getID(),"expect Bülowsvej to have ID: " + 13 + ". Bülowsvej has ID: " + fieldProperty.getProperty().getID());
        assertEquals(3,fieldProperty.getProperty().getFamilie(),"expect Bülowsvej to have family: " + 3 + ". Bülowsvej has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test Bülowsvej. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after buy to be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test Bülowsvej. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test Bülowsvej. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent1 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent1 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test Bülowsvej. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent2 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent2 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test Bülowsvej. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent3 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent3 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test Bülowsvej. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test Bülowsvej. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect Bülowsvej after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". Bülowsvej after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testGlKongevej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 3200;
        final int HOUSE = 2000;
        final int RENT = 250;
        final int RENT1 = 1250;
        final int RENT2 = 3750;
        final int RENT3 = 10000;
        final int RENT4 = 14000;
        final int RENT5 = 18000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[14];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Gl. Kongevej",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Gl. Kongevej" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(14,fieldProperty.getProperty().getID(),"expect field to have ID: " + 14 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(3,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 3 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testBernstorffsvej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 3600;
        final int HOUSE = 2000;
        final int RENT = 300;
        final int RENT1 = 1400;
        final int RENT2 = 4000;
        final int RENT3 = 11000;
        final int RENT4 = 15000;
        final int RENT5 = 19000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[16];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Bernstorffsvej",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Bernstorffsvej" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(16,fieldProperty.getProperty().getID(),"expect field to have ID: " + 16 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(4,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 4 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testHellerupvej() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 3600;
        final int HOUSE = 2000;
        final int RENT = 300;
        final int RENT1 = 1400;
        final int RENT2 = 4000;
        final int RENT3 = 11000;
        final int RENT4 = 15000;
        final int RENT5 = 19000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[18];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Hellerupvej",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Hellerupvej" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(18,fieldProperty.getProperty().getID(),"expect field to have ID: " + 18 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(4,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 4 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testStrandvejen() {
        //Variable
        final int START_MONEY = 40000;
        final int PRICE = 4000;
        final int HOUSE = 2000;
        final int RENT = 350;
        final int RENT1 = 1600;
        final int RENT2 = 4400;
        final int RENT3 = 12000;
        final int RENT4 = 16000;
        final int RENT5 = 20000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[19];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Strandvejen",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Strandvejen" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(19,fieldProperty.getProperty().getID(),"expect field to have ID: " + 19 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(4,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 4 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testTrianglen() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 4400;
        final int HOUSE = 3000;
        final int RENT = 350;
        final int RENT1 = 1800;
        final int RENT2 = 5000;
        final int RENT3 = 14000;
        final int RENT4 = 17500;
        final int RENT5 = 21000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[21];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Trianglen",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Trianglen" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(21,fieldProperty.getProperty().getID(),"expect field to have ID: " + 21 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(5,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 5 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testØsterbrogade() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 4400;
        final int HOUSE = 3000;
        final int RENT = 350;
        final int RENT1 = 1800;
        final int RENT2 = 5000;
        final int RENT3 = 14000;
        final int RENT4 = 17500;
        final int RENT5 = 21000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[23];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Østerbrogade",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Østerbrogade" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(23,fieldProperty.getProperty().getID(),"expect field to have ID: " + 23 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(5,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 5 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testGrønningen() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 4800;
        final int HOUSE = 3000;
        final int RENT = 400;
        final int RENT1 = 2000;
        final int RENT2 = 6000;
        final int RENT3 = 15000;
        final int RENT4 = 18500;
        final int RENT5 = 22000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[24];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Grønningen",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Grønningen" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(24,fieldProperty.getProperty().getID(),"expect field to have ID: " + 24 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(5,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 5 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testBredgade() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 5200;
        final int HOUSE = 3000;
        final int RENT = 450;
        final int RENT1 = 2200;
        final int RENT2 = 6600;
        final int RENT3 = 16000;
        final int RENT4 = 19500;
        final int RENT5 = 23000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[26];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Bredgade",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Bredgade" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(26,fieldProperty.getProperty().getID(),"expect field to have ID: " + 26 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(6,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 6 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testKgsNytorv() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 5200;
        final int HOUSE = 3000;
        final int RENT = 450;
        final int RENT1 = 2200;
        final int RENT2 = 6600;
        final int RENT3 = 16000;
        final int RENT4 = 19500;
        final int RENT5 = 23000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[27];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Kgs. Nytorv",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Kgs. Nytorv" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(27,fieldProperty.getProperty().getID(),"expect field to have ID: " + 27 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(6,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 6 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testØstergade() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 5600;
        final int HOUSE = 3000;
        final int RENT = 500;
        final int RENT1 = 2400;
        final int RENT2 = 7200;
        final int RENT3 = 17000;
        final int RENT4 = 20500;
        final int RENT5 = 24000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[29];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Østergade",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Østergade" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(29,fieldProperty.getProperty().getID(),"expect field to have ID: " + 29 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(6,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 6 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testAmagertorv() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 6000;
        final int HOUSE = 4000;
        final int RENT = 550;
        final int RENT1 = 2600;
        final int RENT2 = 7800;
        final int RENT3 = 18000;
        final int RENT4 = 22000;
        final int RENT5 = 25000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[31];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Amagertorv",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Amagertorv" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(31,fieldProperty.getProperty().getID(),"expect field to have ID: " + 31 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(7,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 7 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testVimmelskaftet() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 6000;
        final int HOUSE = 4000;
        final int RENT = 550;
        final int RENT1 = 2600;
        final int RENT2 = 7800;
        final int RENT3 = 18000;
        final int RENT4 = 22000;
        final int RENT5 = 25000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[32];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Vimmelskaftet",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Vimmelskaftet" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(32,fieldProperty.getProperty().getID(),"expect field to have ID: " + 32 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(7,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 7 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testNygade() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 6400;
        final int HOUSE = 4000;
        final int RENT = 600;
        final int RENT1 = 3000;
        final int RENT2 = 9000;
        final int RENT3 = 20000;
        final int RENT4 = 24000;
        final int RENT5 = 28000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[34];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Nygade",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Nygade" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(34,fieldProperty.getProperty().getID(),"expect field to have ID: " + 34 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(7,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 7 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testFrederiksberggade() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 7000;
        final int HOUSE = 4000;
        final int RENT = 700;
        final int RENT1 = 3500;
        final int RENT2 = 10000;
        final int RENT3 = 22000;
        final int RENT4 = 26000;
        final int RENT5 = 30000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[37];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Frederiksberggade",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Frederiksberggade" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(37,fieldProperty.getProperty().getID(),"expect field to have ID: " + 37 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(8,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 8 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

    @Test
    void testRådhuspladsen() {
        //Variable
        final int START_MONEY = 400000;
        final int PRICE = 8000;
        final int HOUSE = 4000;
        final int RENT = 1000;
        final int RENT1 = 4000;
        final int RENT2 = 12000;
        final int RENT3 = 28000;
        final int RENT4 = 34000;
        final int RENT5 = 40000;
        BoardController boardController = new BoardController();
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();

        /*
        //Expected owner if they paid for houses
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1House = AftRent - HOUSE;
        int Aft1Rent = Aft1House + RENT1;
        int Aft2House = Aft1Rent - HOUSE;
        int Aft2Rent = Aft2House + RENT2;
        int Aft3House = Aft2Rent - HOUSE;
        int Aft3Rent = Aft3House + RENT3;
        int Aft4House = Aft3Rent - HOUSE;
        int Aft4Rent = Aft4House + RENT4;
        int Aft5House = Aft4Rent - (HOUSE * 5);
        int Aft5Rent = Aft5House + RENT5;
         */

        //Expected owner
        int AftBuyMoney = START_MONEY - PRICE;
        int AftRent = AftBuyMoney + RENT;
        int Aft1Rent = AftRent + RENT1;
        int Aft2Rent = Aft1Rent + RENT2;
        int Aft3Rent = Aft2Rent + RENT3;
        int Aft4Rent = Aft3Rent + RENT4;
        int Aft5Rent = Aft4Rent + RENT5;

        //Expected renter
        int RAftRent = START_MONEY - RENT;
        int RAft1Rent = RAftRent - RENT1;
        int RAft2Rent = RAft1Rent - RENT2;
        int RAft3Rent = RAft2Rent - RENT3;
        int RAft4Rent = RAft3Rent - RENT4;
        int RAft5Rent = RAft4Rent - RENT5;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", START_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", START_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", START_MONEY, "red");


        FieldProperty fieldProperty = (FieldProperty) board.getCurrentBoard()[39];

        //Test field. No action yet
        assertEquals(START_MONEY,playerHandler.getPlayers()[0].getMoney(),"expect player1 at start to have: " + START_MONEY + ". player1 at start has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 at start to have: " + START_MONEY + ". player2 at start has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(null,fieldProperty.getOwner(),"expect field to at start be owned by: " + null + ". field is at start owned by: " + fieldProperty.getOwner());

        //Test at field er det rette felt
        assertEquals("Rådhuspladsen",fieldProperty.getProperty().getName(),"expect field to at start be named: " + "Rådhuspladsen" + ". field is named: " + fieldProperty.getProperty().getName());
        assertEquals(39,fieldProperty.getProperty().getID(),"expect field to have ID: " + 39 + ". field has ID: " + fieldProperty.getProperty().getID());
        assertEquals(8,fieldProperty.getProperty().getFamilie(),"expect field to have family: " + 8 + ". field has family: " + fieldProperty.getProperty().getFamilie());


        fieldProperty.buy(playerHandler.getPlayers()[0]);

        //Test field. Bought by player1
        assertEquals(AftBuyMoney,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after buying field to have: " + AftBuyMoney + ". player1 after buying field has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(START_MONEY,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after buy still have: " + START_MONEY + ". player2 after buy has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after buy to be owned by: " + playerHandler.getPlayers()[0] + ". field after buy is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentNormal());

        //Test field. Rent0 from player2
        assertEquals(AftRent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent0 have: " + AftRent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAftRent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent0 have: " + RAftRent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent1House());

        //Test field. Rent1 from player2
        assertEquals(Aft1Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent1 have: " + Aft1Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft1Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent1 have: " + RAft1Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent2House());

        //Test field. Rent2 from player2
        assertEquals(Aft2Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent2 have: " + Aft2Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft2Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent2 have: " + RAft2Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent3House());

        //Test field. Rent3 from player2
        assertEquals(Aft3Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent3 have: " + Aft3Rent + ". player1 after rent0 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft3Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent3 have: " + RAft3Rent + ". player2 after rent0 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRent4House());

        //Test field. Rent4 from player2
        assertEquals(Aft4Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent4 have: " + Aft4Rent + ". player1 after rent4 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft4Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent4 have: " + RAft4Rent + ". player2 after rent4 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());


        fieldProperty.rent(playerHandler.getPlayers()[1],fieldProperty.getProperty().getRentHotel());

        //Test field. Rent5 from player2
        assertEquals(Aft5Rent,playerHandler.getPlayers()[0].getMoney(),"expect player1 to after rent5 have: " + Aft5Rent + ". player1 after rent5 has: " + playerHandler.getPlayers()[0].getMoney());
        assertEquals(RAft5Rent,playerHandler.getPlayers()[1].getMoney(),"expect player2 to after rent5 have: " + RAft5Rent + ". player2 after rent5 has: " + playerHandler.getPlayers()[1].getMoney());
        assertEquals(playerHandler.getPlayers()[0],fieldProperty.getOwner(),"expect field after rent to still be owned by: " + playerHandler.getPlayers()[0] + ". field after rent is owned by: " + fieldProperty.getOwner());

    }

}