package dtu.board;

import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreweryFieldTest {

    @Test
    void buy() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 40000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 40000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 40000, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 0, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);

        BreweryField breweryField = new BreweryField(brewery);
        BreweryField breweryField1 = new BreweryField(new Brewery(1, "test2", 1, 20,30,40));
        assertFalse(breweryField1.buy(playerHandler.getPlayers()[3]));
        assertEquals(true, breweryField.buy(playerHandler.getPlayers()[0]));
        assertEquals(playerHandler.getPlayers()[0], breweryField.getOwner());

        assertEquals(true, breweryField.getOwned());
        assertEquals(false, breweryField.isPledgeState());


    }

    @Test
    void rent() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 20, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 20, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 20, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 20, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);

        BreweryField breweryField = new BreweryField(brewery);
        breweryField.buy(playerHandler.getPlayers()[0]);

        breweryField.rent(playerHandler.getPlayers()[1], brewery.getRent1());

        assertEquals(0, playerHandler.getPlayers()[1].getMoney());



    }

    @Test
    void landedLabel() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 20, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 20, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 20, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 20, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);

        BreweryField breweryField = new BreweryField(brewery);

        assertEquals("Du er landet på test.", breweryField.landedLabel());




    }

    @Test
    void activeRent() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 40000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 40000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 40000, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 0, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);
        BreweryField breweryField1 = new BreweryField(new Brewery(1, "test2", 1, 20,30,40));
        BreweryField breweryField = new BreweryField(brewery);

        breweryField.buy(playerHandler.getPlayers()[0]);
        assertEquals(200, breweryField.findActiveRent(10));

        breweryField1.buy(playerHandler.getPlayers()[0]);
        assertEquals(300, breweryField.findActiveRent(10));

        breweryField.setPledgeState(true);
        assertTrue(breweryField.isPledgeState());

        breweryField.setOwner(playerHandler.getPlayers()[1]);
        assertEquals(playerHandler.getPlayers()[1], breweryField.getOwner());

    }

    @Test
    void Messages() {
        //expected
        final String TYPE = "brewery";

        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 20, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 20, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 20, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 20, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);

        BreweryField breweryField = new BreweryField(brewery);

        //Tester at brewery er rette type
        assertEquals(TYPE, breweryField.type(), "Expect BreweryField to have type: " + TYPE + ". type is: " + breweryField.type());
        //Tester at det det rette brewery i BreweryField
        assertEquals(brewery, breweryField.getBrewery(), "Expect BreweryField to have brewery: " + brewery + ". BreweryField has: " + breweryField.getBrewery());
    }

    @Test
    void SetOwned() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 20, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 20, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 20, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 20, "green");
        Brewery brewery = new Brewery(0, "test", 0, 10, 20, 30);

        BreweryField breweryField = new BreweryField(brewery);

        //Tester at brewery ikker er ejet
        assertEquals(false, breweryField.getOwned(), "Expect BreweryField to have ownership: " + false + ". ownership is: " + breweryField.getOwned());

        breweryField.setOwned(true);

        //Tester at BreweryField nu er ejet
        assertEquals(true, breweryField.getOwned(), "Expect BreweryField to have ownership: " + true + ". ownership is: " + breweryField.getOwned());
    }
}