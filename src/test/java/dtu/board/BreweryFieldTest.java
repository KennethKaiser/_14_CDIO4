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
    void type() {
    }
}