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

        Property property = new Property(0,"DTU",PROPERTY_PRICE,200,100,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);

        propertyField.action(player);

        //Se om player er blevet ejer og mister den rette mængde penge penge
        assertTrue((player.getMoney() == endMoney) && (property.getOwner() == player), "expect player to have: " + endMoney + " and owner of property to be: " + player + ". player has " + player.getMoney()
        + ". And property is owned by: " + property.getOwner());
        System.out.println("expect player to have: " + endMoney + ", player has: " + player.getMoney() + ". Expect property to be owned: " + true + ", property is: " + property.getOwned());
    }

    @Test
    void testBuyPropertyNoCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 400;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,"DTU",PROPERTY_PRICE,200,100,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);

        propertyField.action(player);

        //Ser om player nægtes købet, da han ville gå fallit
        assertTrue((player.getMoney() == START_MONEY) && (property.getOwner() == null), "expect player to have: " + START_MONEY + " and owner of property to be: " + null + ". player has " + player.getMoney()
                + ". And property is owned by: " + property.getOwner());
        System.out.println("expect player to have: " + START_MONEY + ", player has: " + player.getMoney() + ". Expect property to be owned: " + false + ", property is: " + property.getOwned());
    }

    @Test
    void testLandOnOwnedProperty() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4000;
        //Expected
        int endMoney = START_MONEY - PROPERTY_PRICE;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Property property = new Property(0,"DTU",PROPERTY_PRICE,200,0,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);

        propertyField.action(player1);
        propertyField.action(player2);

        //Ser om player er blevet ejer og mister den rette mængde penge penge
        assertTrue((player1.getMoney() == endMoney) && (property.getOwner() == player1), "expect player to have: " + endMoney + " and owner of property to be: " + player1 + ". player has " + player1.getMoney()
                + ". And property is owned by: " + property.getOwner());
        System.out.println("expect player1 to have: " + endMoney + ", player1 has: " + player1.getMoney() + ". Expect property to be owned: " + true + ", property is: " + property.getOwned());
    }


}