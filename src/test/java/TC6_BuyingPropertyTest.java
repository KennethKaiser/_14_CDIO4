import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertTrue;

class TC6_BuyingPropertyTest {

    @Test
    void testBuyProperty() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4000;
        //Expected
        int endMoney = START_MONEY - PROPERTY_PRICE;

       Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property("DTU",PROPERTY_PRICE,200,100,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);

        propertyField.action(player);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == endMoney) && (property.getOwner() == player), "expect player to have: " + endMoney + " and owner of property to be: " + player + ". player has " + player.getMoney()
        + ". And property is owned by: " + property.getOwner());
        System.out.println("expect player to have: " + endMoney + ", player has: " + player.getMoney() + ". Expect property to be owned: " + true + ", property is: " + property.getOwned());
    }


}