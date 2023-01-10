import dtu.board.Board;
import dtu.board.FieldProperty;
import dtu.board.PropertyList;
import dtu.board.PropertyHandler;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TC8_PropertyTest {

    Board board = new Board();


    @Test
    void testBuyingRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        //Expected
        int moneyAfterBuying = START_MONEY - RØD_PRICE;

       Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Rødovrevej.buy(player);
       //propertyHandler.buyProperty(player, PropertyList.getRødovrevej());


        //Ser om player er blevet ejer og mistet rette mængde penge penge
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        assertEquals(Rødovrevej.getOwner(),player,"Spilleren: " + player + " skulle gerne være ejer. Ejeren er: " + Rødovrevej.getOwner());
    }

    @Test
    void testBuildingFailHouseRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        final int RØD_HOUSEPRICE = 1000;
        //Expected
        int moneyAfterBuying = START_MONEY - RØD_PRICE;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");


        //propertyHandler.buyProperty(player, PropertyList.getRødovrevej());
        //propertyHandler.buildHouse(player,PropertyList.getRødovrevej());


        //Ser om player har rette mængde penge og Rødovrevej ikke har fået hus
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getBuildings(),0,"Rødovre skulle have bygninger: " + 0 + " Rødovre har: " + PropertyList.getRødovrevej().getBuildings());
    }

    @Test
    void testBuilding1HouseRødovrevej() {
        //Variable
        final int START_MONEY = 4400;
        final int REDnWHITE_PRICE = 1200;
        final int RØD_HOUSEPRICE = 1000;
        //Expected
        int moneyAfterBuying = START_MONEY - (REDnWHITE_PRICE * 2) - RØD_HOUSEPRICE;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        //propertyHandler.buyProperty(player, PropertyList.getRødovrevej());
        //propertyHandler.buyProperty(player,PropertyList.getHvidovrevej());
        //propertyHandler.buildHouse(player,PropertyList.getRødovrevej());


        //Ser om player har mistet rette mængde penge og Rødovrevej har fået en bygning
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getBuildings(),1,"Rødovre skulle have bygninger: " + 1 + " Rødovre har: " + PropertyList.getRødovrevej().getBuildings());
    }

    @Test
    void testRentRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        final int RØD_RENT = 50;
        //Expected
        int moneyAfterRent = START_MONEY - RØD_RENT;
        int moneyAfterRentGood = (START_MONEY - RØD_PRICE) + RØD_RENT;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Rødovrevej.buy(player1);
        Rødovrevej.setActiveRent(0);
        Rødovrevej.rent(player2);
        //propertyHandler.buyProperty(player1, PropertyList.getRødovrevej());
        //propertyHandler.payRent(player2,PropertyList.getRødovrevej());


        //Ser om player1 og 2 har rette mængde penge og Rødovrevej har rette ejer
        assertEquals(player2.getMoney(),moneyAfterRent,"Spilleren2 burde have: " + moneyAfterRent + ". Spilleren har: "+ player2.getMoney());
        assertEquals(player1.getMoney(),moneyAfterRentGood,"Spilleren1 burde have: " + moneyAfterRentGood + ". Spilleren har: "+ player1.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getOwner(),player1,"Spilleren: " + player1 + " skulle gerne være ejer. Ejeren er: " + PropertyList.getRødovrevej().getOwner());
    }

    @Test
    void test2XRentRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        FieldProperty Hvidovrevej;
        Hvidovrevej = (FieldProperty) board.getCurrentBoard()[3];
        final int START_MONEY = 4400;
        final int RØDnHVID_PRICE = 1200;
        final int RØD_RENT = 50;
        //Expected
        int moneyAfterRent = START_MONEY - (RØD_RENT * 2);
        int moneyAfterRentGood = (START_MONEY - (RØDnHVID_PRICE * 2)) + (RØD_RENT * 2);

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Rødovrevej.buy(player1);
        Hvidovrevej.buy(player1);
        Rødovrevej.setActiveRent(0);
        Rødovrevej.rent(player2);
        //propertyHandler.buyProperty(player1, PropertyList.getRødovrevej());
        //propertyHandler.buyProperty(player1, PropertyList.getHvidovrevej());
        //propertyHandler.payRent(player2,PropertyList.getRødovrevej());


        //Ser om player 2 og 1 har rette mængde penge og player1 stadig er ejer
        assertEquals(player2.getMoney(),moneyAfterRent,"Spilleren2 burde have: " + moneyAfterRent + ". Spilleren har: "+ player2.getMoney());
        assertEquals(player1.getMoney(),moneyAfterRentGood,"Spilleren1 burde have: " + moneyAfterRentGood + ". Spilleren har: "+ player1.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getOwner(),player1,"Spilleren: " + player1 + " skulle gerne være ejer. Ejeren er: " + PropertyList.getRødovrevej().getOwner());
    }

    @Test
    void testPledgingRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        final int START_MONEY = 4400;
        final int REDnWHITE_PRICE = 1200;
        //Expected
        int moneyAfterBuying = START_MONEY - REDnWHITE_PRICE + (REDnWHITE_PRICE / 2);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Rødovrevej.buy(player);
        //Rødovrevej.pledge(player)

        //propertyHandler.buyProperty(player, PropertyList.getRødovrevej());
        //propertyHandler.pledgeProperty(player, PropertyList.getRødovrevej());


        //Ser om player har mistet rette penge og bygningen er pantsat
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getPledgestate(),true,"Rødovre skulle have være pledged så: " + true + " Rødovre pledgestate er: " + PropertyList.getRødovrevej().getPledgestate());
    }

    @Test
    void testRentPledgingRødovrevej() {
        //Variable
        FieldProperty Rødovrevej;
        Rødovrevej = (FieldProperty) board.getCurrentBoard()[1];
        final int START_MONEY = 4400;
        final int REDnWHITE_PRICE = 1200;
        //expected
        final int endMoney = START_MONEY - (REDnWHITE_PRICE / 2);

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Rødovrevej.buy(player1);
        //Rødovrevej.pledge(player1);
        Rødovrevej.rent(player2);
        //propertyHandler.buyProperty(player1, PropertyList.getRødovrevej());
        //propertyHandler.pledgeProperty(player1, PropertyList.getRødovrevej());
        //propertyHandler.payRent(player2,PropertyList.getRødovrevej());


        //Se om player1 fortsat har samme penge, player1 har fået pledge penge og Rødovrevej er pledged
        assertEquals(player2.getMoney(),START_MONEY,"Spilleren burde have: " + START_MONEY + ". Spilleren har: "+ player2.getMoney());
        assertEquals(player1.getMoney(),endMoney,"Spilleren burde have: " + endMoney + ". Spilleren har: "+ player2.getMoney());
        //assertEquals(PropertyList.getRødovrevej().getPledgestate(),true,"Rødovre skulle have være pledged så: " + true + " Rødovre pledgestate er: " + PropertyList.getRødovrevej().getPledgestate());
    }

}