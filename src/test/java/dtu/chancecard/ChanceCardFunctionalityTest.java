package dtu.chancecard;

import dtu.board.Chance;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardFunctionalityTest {

    @Test
    void chanceCardFunctionTest() {
        ChanceCardFunctionality chanceCardFunctionality = new ChanceCardFunctionality();
        PlayerHandler playerHandler = new PlayerHandler();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 50000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        chanceCardFunctionality.setPlayerHandler(playerHandler);

        chanceCardFunctionality.chanceCardFunction(0, playerHandler.getPlayers()[0]);

        assertEquals(50000, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(1, playerHandler.getPlayers()[0]);

        assertEquals(50000, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(2, playerHandler.getPlayers()[0]);

        assertEquals(49000, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(3, playerHandler.getPlayers()[0]);

        assertEquals(48700, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(4, playerHandler.getPlayers()[0]);

        assertEquals(48500, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(5, playerHandler.getPlayers()[0]);

        assertEquals(45500, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(6, playerHandler.getPlayers()[0]);

        assertEquals(42500, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(7, playerHandler.getPlayers()[0]);

        assertEquals(41500, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(8, playerHandler.getPlayers()[0]);

        assertEquals(41300, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(9, playerHandler.getPlayers()[0]);

        assertEquals(40300, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(10, playerHandler.getPlayers()[0]);

        assertEquals(40100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(11, playerHandler.getPlayers()[0]);

        assertEquals(38100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(12, playerHandler.getPlayers()[0]);

        assertEquals(38600, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(13, playerHandler.getPlayers()[0]);

        assertEquals(39100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(14, playerHandler.getPlayers()[0]);

        assertEquals(40100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(15, playerHandler.getPlayers()[0]);

        assertEquals(41100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(16, playerHandler.getPlayers()[0]);

        assertEquals(42100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(17, playerHandler.getPlayers()[0]);

        assertEquals(45100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(18, playerHandler.getPlayers()[0]);

        assertEquals(46100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(19, playerHandler.getPlayers()[0]);

        assertEquals(47100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(20, playerHandler.getPlayers()[0]);

        assertEquals(48100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(21, playerHandler.getPlayers()[0]);

        assertEquals(49100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(22, playerHandler.getPlayers()[0]);

        assertEquals(50100, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(23, playerHandler.getPlayers()[0]);

        assertEquals(50300, playerHandler.getPlayers()[0].getMoney());

        //Testing if it gives money or not if value is under 15000
        playerHandler.getPlayers()[0].setMoney(14500);
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney());
        //And also that it doesn't give it if it's above 15000
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney());
        //And the boundary = 15000
        playerHandler.getPlayers()[0].setMoney(15000);
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(15000, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(25, playerHandler.getPlayers()[0]);
        assertEquals(15400, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(26, playerHandler.getPlayers()[0]);
        assertEquals(16400, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(27, playerHandler.getPlayers()[0]);
        assertEquals(17400, playerHandler.getPlayers()[0].getMoney());

        chanceCardFunctionality.chanceCardFunction(28, playerHandler.getPlayers()[0]);
        assertEquals(0, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(29, playerHandler.getPlayers()[0]);
        assertEquals(0, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(30, playerHandler.getPlayers()[0]);
        assertEquals(3, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(31, playerHandler.getPlayers()[0]);
        assertEquals(0, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(32, playerHandler.getPlayers()[0]);
        assertEquals(37, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(33, playerHandler.getPlayers()[0]);
        assertEquals(11, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(34, playerHandler.getPlayers()[0]);
        assertEquals(15, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(35, playerHandler.getPlayers()[0]);
        assertEquals(25, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(36, playerHandler.getPlayers()[0]);
        assertEquals(15, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(37, playerHandler.getPlayers()[0]);
        assertEquals(24, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(38, playerHandler.getPlayers()[0]);
        assertEquals(32, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(39   , playerHandler.getPlayers()[0]);
        assertEquals(35, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(40, playerHandler.getPlayers()[0]);
        assertEquals(19, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(41, playerHandler.getPlayers()[0]);
        assertEquals(39, playerHandler.getPlayers()[0].getPosition());

        chanceCardFunctionality.chanceCardFunction(42, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isGetOutOfJailCard());

        playerHandler.getPlayers()[0].setGetOutOfJailCard(false);
        assertEquals(false, playerHandler.getPlayers()[0].isGetOutOfJailCard());
        chanceCardFunctionality.chanceCardFunction(43, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isGetOutOfJailCard());

        assertEquals(false, playerHandler.getPlayers()[0].isJail());
        chanceCardFunctionality.chanceCardFunction(44, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isJail());

        playerHandler.getPlayers()[0].setJail(false);
        assertEquals(false, playerHandler.getPlayers()[0].isJail());
        chanceCardFunctionality.chanceCardFunction(45, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isJail());


    }
}