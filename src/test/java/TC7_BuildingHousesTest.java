import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.board.PropertyHandler;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TC7_BuildingHousesTest {

    /*PropertyHandler propertyHandler = new PropertyHandler();

    @Test
    void testBuyHouseHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4400;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - HOUSE_PRICE;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuyHouseNoCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 500;
        final int HOUSE_PRICE = 500;
        final int RENT_NORM = 100;
        final int RENT_HOUSE = 200;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying;

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,RENT_NORM,RENT_HOUSE,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);

        //Se om player er nægtet at købe huset
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_NORM), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_NORM + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_NORM + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuy2HousesHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4400;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_2HOUSE = 500;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 2);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,RENT_2HOUSE,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_2HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_2HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_2HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuy3HousesHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4400;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_3HOUSE = 500;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 3);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,200,RENT_3HOUSE,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_3HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_3HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_3HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuy3HousesHasNoCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 1500;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_2HOUSE = 300;
        final int RENT_3HOUSE = 500;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 2);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,RENT_2HOUSE,RENT_3HOUSE,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_2HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_2HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_2HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuy4HousesHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 4400;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_4HOUSE = 500;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 4);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,200,700,RENT_4HOUSE,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_4HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_4HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_4HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuyHotelHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 44000;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_HOTEL = 900;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 4) - (HOUSE_PRICE * 5);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,200,700,800,RENT_HOTEL,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_HOTEL), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_HOTEL + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_HOTEL + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuyHotelHasNoCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 2500;
        final int HOUSE_PRICE = 500;
        final int RENT_4HOUSE = 800;
        final int RENT_HOTEL = 900;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 4);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,200,200,700,RENT_4HOUSE,RENT_HOTEL,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_4HOUSE), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_4HOUSE + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_4HOUSE + ", property has rent: " + property.getActiveRent());
    }

    @Test
    void testBuyHotelAgainHasCash() {
        //Variable
        final int PROPERTY_PRICE = 400;
        final int START_MONEY = 44000;
        final int HOUSE_PRICE = 500;
        final int RENT_HOUSE = 200;
        final int RENT_HOTEL = 900;
        //Expected
        int moneyAfterBuying = START_MONEY - PROPERTY_PRICE;
        int moneyAfterHouse = moneyAfterBuying - (HOUSE_PRICE * 4) - (HOUSE_PRICE * 5);

        Player player = new Player(0,"Nicklas",START_MONEY,"Black");

        Property property = new Property(0,1,"DTU",PROPERTY_PRICE,HOUSE_PRICE,100,RENT_HOUSE,200,700,800,RENT_HOTEL,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwned(false);
        propertyField.action(player);

        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);
        propertyHandler.buildHouse(player,property);

        //Se om player er blevet ejer og mistet rette mængde penge penge
        assertTrue((player.getMoney() == moneyAfterHouse) && (property.getActiveRent() == RENT_HOTEL), "expect player to have: " + moneyAfterHouse + " and rent of property to be: " + RENT_HOTEL + ". property has rent to " + property.getActiveRent()
                + ". And player has: " + player.getMoney());
        System.out.println("expect player to have: " + moneyAfterHouse + ", player has: " + player.getMoney() + ". Expect property to have rent: " + RENT_HOTEL + ", property has rent: " + property.getActiveRent());
    }
*/
}