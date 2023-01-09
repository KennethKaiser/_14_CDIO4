package dtu.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isPlayerBankruptTest {

    @Test
    void isPlayerBankruptTest() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 4000, "Black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 4000, "red");

        playerHandler.getPlayers()[0].setMoney(-1);

        playerHandler.isPlayerBankrupt(playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isBankrupt());


    }


}
