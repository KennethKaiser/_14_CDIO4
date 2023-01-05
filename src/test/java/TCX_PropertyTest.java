import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.board.PropertyList;
import dtu.game.GameActions;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

class TCX_PropertyTest {

    @Test
    void testBuyingRødovrevej() {
        //Variable
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        //Expected
        int moneyAfterBuying = START_MONEY - RØD_PRICE;

       Player player = new Player(0,"Nicklas",START_MONEY,"Black");

       GameActions.buyProperty(player, PropertyList.getRødovrevej());


        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        assertEquals(PropertyList.getRødovrevej().getOwner(),player,"Spilleren: " + player + " skulle gerne være ejer. Ejeren er: " + PropertyList.getRødovrevej().getOwner());
    }

    @Test
    void testBuildingHouseRødovrevej() {
        //Variable
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        final int RØD_HOUSEPRICE = 1000;
        //Expected
        int moneyAfterBuying = START_MONEY - RØD_PRICE - RØD_HOUSEPRICE;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        GameActions.buyProperty(player, PropertyList.getRødovrevej());
        GameActions.buildHouse(player,PropertyList.getRødovrevej());


        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertEquals(player.getMoney(),moneyAfterBuying,"Spilleren burde have: " + moneyAfterBuying + ". Spilleren har: "+ player.getMoney());
        assertEquals(PropertyList.getRødovrevej().getBuildings(),1,"Rødovre skulle have bygninger: " + 1 + " Rødovre har: " + PropertyList.getRødovrevej().getBuildings());
    }

    @Test
    void testRentRødovrevej() {
        //Variable
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        final int RØD_RENT = 50;
        //Expected
        int moneyAfterRent = START_MONEY - RØD_RENT;
        int moneyAfterRentGood = (START_MONEY - RØD_PRICE) + RØD_RENT;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        GameActions.buyProperty(player1, PropertyList.getRødovrevej());
        GameActions.payRent(player2,PropertyList.getRødovrevej());


        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertEquals(player1.getMoney(),moneyAfterRentGood,"Spilleren1 burde have: " + moneyAfterRentGood + ". Spilleren har: "+ player1.getMoney());
        assertEquals(player2.getMoney(),moneyAfterRent,"Spilleren2 burde have: " + moneyAfterRent + ". Spilleren har: "+ player2.getMoney());
        assertEquals(PropertyList.getRødovrevej().getOwner(),player1,"Spilleren: " + player1 + " skulle gerne være ejer. Ejeren er: " + PropertyList.getRødovrevej().getOwner());
    }

}