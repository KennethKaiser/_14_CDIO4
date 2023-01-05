package dtu.game;

import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameActionsTest {

    @Test
    void movePlayerChanceCard() {
        Player player = new Player(1, "tis", 4000, "black");
        GameActions gameActions = new GameActions();
        player.setPosition(2);

        gameActions.movePlayerChanceCard(player, 10);

        assertEquals(10, player.getPosition(), "test");


    }

    @Test
    void nearestFerryTest(){
        Player player = new Player(1, "tis", 4000, "black");
        GameActions gameActions = new GameActions();
        player.setPosition(38);
        gameActions.nearestFerry(player);
        System.out.println(player.getPosition());
    }
}