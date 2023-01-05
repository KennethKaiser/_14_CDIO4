import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.board.PropertyList;
import dtu.game.GameActions;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertTrue;

class TCX_PropertyTest {

    @Test
    void testBuyingRødovrevej() {
        //Variable
        final int START_MONEY = 4400;
        final int RØD_PRICE = 1200;
        final int RENT_HOUSE = 200;
        //Expected
        int moneyAfterBuying = START_MONEY - RØD_PRICE;

       Player player = new Player(0,"Nicklas",START_MONEY,"Black");
       Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

       GameActions.buyProperty(player, PropertyList.getRødovrevej());


        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterBuying) && (property.getActiveRent() == RENT_HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_HOUSE + ". property has rent to " + property.getActiveRent()
        + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_HOUSE + ", property has rent: " + property.getActiveRent());
    }

}