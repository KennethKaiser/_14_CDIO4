package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class quitGameTest {

    @Test
    void quitGameTest() {
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(6);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");
        playerHandler.initializePlayerInPlayers(4, "Test5", 4000, "yellow");
        playerHandler.initializePlayerInPlayers(5, "Test6", 4000, "white");

        System.out.println(playerHandler.getPlayers().length);
        System.out.println(playerHandler.getPlayers()[0].getName());
        System.out.println(playerHandler.getPlayers()[1].getName());
        System.out.println(playerHandler.getPlayers()[2].getName());
        System.out.println(playerHandler.getPlayers()[3].getName());
        System.out.println(playerHandler.getPlayers()[4].getName());
        System.out.println(playerHandler.getPlayers()[5].getName());

        playerHandler.quitGame(playerHandler.getPlayers()[4]);
        assertEquals(5, playerHandler.getPlayers().length);

        System.out.println(playerHandler.getPlayers().length);
        System.out.println(playerHandler.getPlayers()[0].getName());
        System.out.println(playerHandler.getPlayers()[1].getName());
        System.out.println(playerHandler.getPlayers()[2].getName());
        System.out.println(playerHandler.getPlayers()[3].getName());
        System.out.println(playerHandler.getPlayers()[4].getName());

        playerHandler.quitGame(playerHandler.getPlayers()[0]);
        assertEquals(4, playerHandler.getPlayers().length);

        System.out.println(playerHandler.getPlayers().length);
        System.out.println(playerHandler.getPlayers()[0].getName());
        System.out.println(playerHandler.getPlayers()[1].getName());
        System.out.println(playerHandler.getPlayers()[2].getName());
        System.out.println(playerHandler.getPlayers()[3].getName());
    }

}