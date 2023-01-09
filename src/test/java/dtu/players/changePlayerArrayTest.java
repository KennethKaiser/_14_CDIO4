package dtu.players;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class changePlayerArrayTest {

    @Test
    void changePlayerArrayTest() {
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(6);

        playerHandler.initializePlayerInPlayers(0,"Niels", 4000, "Black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Hans", 4000, "red");
        playerHandler.initializePlayerInPlayers(4, "Hans", 4000, "red");
        playerHandler.initializePlayerInPlayers(5, "Hans", 4000, "red");
        playerHandler.getPlayers()[0].setMoney(-1);
        playerHandler.getPlayers()[2].setMoney(-1);
        playerHandler.getPlayers()[5].setMoney(-1);
        System.out.println(playerHandler.getPlayers()[1]);

        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            playerHandler.isPlayerBankrupt(playerHandler.getPlayers()[i]);
            playerHandler.changePlayerArray();
        }
        System.out.println(playerHandler.getPlayers()[0]);

        assertEquals(3, playerHandler.getPlayers().length);
    }
}