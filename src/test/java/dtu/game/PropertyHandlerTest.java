package dtu.game;

import dtu.players.Player;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyHandlerTest {

    @Test
    void movePlayerChanceCard() {
        Player player = new Player(1, "tis", 4000, "black");
        PlayerHandler playerHandler = new PlayerHandler();
        player.setPosition(2);

        playerHandler.movePlayerChanceCard(player, 10);

        assertEquals(10, player.getPosition(), "test");


    }


}