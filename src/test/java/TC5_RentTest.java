import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.board.PropertyList;
import dtu.board.PropertyHandler;
import dtu.board.Board;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TC5_RentTest {

    PropertyHandler propertyHandler = new PropertyHandler();
    Board board = new Board();

    @Test
    void testPayRent() {
        //Variable
        int RENT = 400;
        final int START_MONEY = 4000;
        //Expected
        int lost = START_MONEY - RENT;
        int gained = START_MONEY + RENT;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Property property = new Property(0, 1,"DTU",300,200,RENT,500,600,700,800,900,5);
        Property property2 = new Property(1, 1,"Bornholm",300,200,RENT,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        propertyField.setOwner(player2);
        propertyField.setOwned(true);
        propertyField.setActiveRent(0);
        FieldProperty propertyField2 = new FieldProperty(property2);
        propertyField2.setOwner(player1);
        propertyField2.setOwned(true);
        propertyField2.setActiveRent(0);

        propertyField.rent(player1);

        //Tester at den ene spiller mistede penge og den anden fik
        assertTrue((player1.getMoney() == lost) && (player2.getMoney() == gained), "expect player1 to have: " + lost + " and player2 to have: " + gained + ". player1 has " + player1.getMoney()
                + ". And player 2 has: "+ player2.getMoney());
        System.out.println("expect player1 to have: " + lost + ", player1 has: " + player1.getMoney() + ". Expect player2 to have: " + gained + ", player 2 has: " + player2.getMoney());
    }

    @Test
    void testPay2XRent() {
        //Variable
        int RENT = 400;
        final int START_MONEY = 4000;
        //Expected
        int lost = START_MONEY - (RENT * 2);
        int gained = START_MONEY + (RENT * 2);

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Property property = new Property(0, 1,"DTU",300,200,RENT,500,600,700,800,900,5);
        Property property2 = new Property(1, 1,"Bornholm",300,200,RENT,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        propertyField.setOwner(player2);
        propertyField.setOwned(true);
        propertyField.setActiveRent(0);
        FieldProperty propertyField2 = new FieldProperty(property2);
        propertyField2.setOwner(player2);
        propertyField2.setOwned(true);
        propertyField2.setActiveRent(0);

        propertyField.rent(player1);

        //Tester at den ene spiller mistede penge og den anden fik
        assertTrue((player1.getMoney() == lost) && (player2.getMoney() == gained), "expect player1 to have: " + lost + " and player2 to have: " + gained + ". player1 has " + player1.getMoney()
                + ". And player 2 has: "+ player2.getMoney());
        System.out.println("expect player1 to have: " + lost + ", player1 has: " + player1.getMoney() + ". Expect player2 to have: " + gained + ", player 2 has: " + player2.getMoney());
    }

    @Test
    void testPay0Rent() {
        //Variable
        int RENT = 0;
        final int START_MONEY = 4000;
        //Expected
        int lost = START_MONEY - RENT;
        int gained = START_MONEY + RENT;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Property property = new Property(0,1,"DTU",300,200,RENT,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        propertyField.setOwner(player2);
        propertyField.setOwned(true);
        propertyField.setActiveRent(0);

        propertyField.rent(player1);

        //Testede om systemet virkede med værdier på 0
        assertTrue((player1.getMoney() == lost) && (player2.getMoney() == gained), "expect player1 to have: " + lost + " and player2 to have: " + gained + ". player1 has " + player1.getMoney()
                + ". And player 2 has: "+ player2.getMoney());
        System.out.println("expect player1 to have: " + lost + ", player1 has: " + player1.getMoney() + ". Expect player2 to have: " + gained + ", player 2 has: " + player2.getMoney());
    }

    @Test
    void testPayRent1House() {
        //Variable
        int RENT_HOUSE = 450;
        final int START_MONEY = 4000;
        //Expected
        int lost = START_MONEY - RENT_HOUSE;
        int gained = START_MONEY + RENT_HOUSE;

        Player player1 = new Player(0,"Nicklas",START_MONEY,"Black");
        Player player2 = new Player(1,"Andreas",START_MONEY,"Red");

        Property property = new Property(0,1,"DTU",300,200,200,RENT_HOUSE,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        propertyField.setOwner(player2);
        propertyField.setOwned(true);
        propertyField.setActiveRent(1);

        propertyField.rent(player1);

        //Tester at lejen også ændres hvis der er et hus
        assertTrue((player1.getMoney() == lost) && (player2.getMoney() == gained), "expect player1 to have: " + lost + " and player2 to have: " + gained + ". player1 has " + player1.getMoney()
                + ". And player 2 has: "+ player2.getMoney());
        System.out.println("expect player1 to have: " + lost + ", player1 has: " + player1.getMoney() + ". Expect player2 to have: " + gained + ", player 2 has: " + player2.getMoney());
    }

}