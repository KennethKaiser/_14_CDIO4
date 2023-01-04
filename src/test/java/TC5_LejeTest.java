import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.game.GameActions;
import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertTrue;

class TC5_LejeTest {

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

        Property property = new Property("DTU",300,200,RENT,500,600,700,800,900,5);

        FieldProperty propertyField = new FieldProperty(property);
        property.setOwner(player2);
        property.setOwned(true);
        property.setActiveRent(0);

        propertyField.action(player1);

        //Se om middel er fin
        assertTrue((player1.getMoney() == lost) && (player2.getMoney() == gained), "expected player1 have: " + lost + " and player 2 have: " + gained + ". player1 has " + player1.getMoney()
        + ". And player 2 has: "+ player2.getMoney());
        System.out.println("expect player1 to have: " + lost + ", player1 has: " + player1.getMoney() + ". Expect player2 to have: " + gained + ", player 2 has: " + player2.getMoney());

    }

}