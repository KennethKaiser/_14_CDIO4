package dtu.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void changePlayerPropertiesTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 0, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 0, "green");

        playerHandler.getPlayers()[0].setId(10);
        assertEquals(10, playerHandler.getPlayers()[0].getId());
        playerHandler.getPlayers()[0].setName("Testitest");
        assertEquals("Testitest", playerHandler.getPlayers()[0].getName());
        playerHandler.getPlayers()[0].setColor("testicolor");
        assertEquals("testicolor", playerHandler.getPlayers()[0].getColor());
    }


}