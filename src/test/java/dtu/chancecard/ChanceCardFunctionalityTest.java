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
        int StartMoney = 500000;

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", StartMoney, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        chanceCardFunctionality.setPlayerHandler(playerHandler);

        //Tester kort id:0
        chanceCardFunctionality.chanceCardFunction(0, playerHandler.getPlayers()[0]);

        assertEquals(StartMoney, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:0");

        //Tester kort id:1
        int money1 = playerHandler.getPlayers()[0].getMoney() -1000;
        chanceCardFunctionality.chanceCardFunction(1, playerHandler.getPlayers()[0]);

        assertEquals(money1, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:1");

        //Tester kort id:2
        int money2 = playerHandler.getPlayers()[0].getMoney() -300;
        chanceCardFunctionality.chanceCardFunction(2, playerHandler.getPlayers()[0]);

        assertEquals(money2, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:2");

        //Tester kort id:3
        int money3 = playerHandler.getPlayers()[0].getMoney() - 200;
        chanceCardFunctionality.chanceCardFunction(3, playerHandler.getPlayers()[0]);

        assertEquals(money3, playerHandler.getPlayers()[0].getMoney(), "Tester card ID:3");

        //Tester kort id:4
        int money4 = playerHandler.getPlayers()[0].getMoney() - 3000;
        chanceCardFunctionality.chanceCardFunction(4, playerHandler.getPlayers()[0]);

        assertEquals(money4, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:4");

        //tester kort id:5
        int money5 = playerHandler.getPlayers()[0].getMoney() - 3000;
        chanceCardFunctionality.chanceCardFunction(5, playerHandler.getPlayers()[0]);

        assertEquals(money5, playerHandler.getPlayers()[0].getMoney(), "Tester card ID:5");

        //Tester kort id:6
        int money6 = playerHandler.getPlayers()[0].getMoney() - 1000;
        chanceCardFunctionality.chanceCardFunction(6, playerHandler.getPlayers()[0]);

        assertEquals(money6, playerHandler.getPlayers()[0].getMoney(),"tester card ID:6");

        //Tester kort id:7
        int money7 = playerHandler.getPlayers()[0].getMoney() - 200;
        chanceCardFunctionality.chanceCardFunction(7, playerHandler.getPlayers()[0]);

        assertEquals(money7, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:7");

        //tester kort id:8
        int money8 = playerHandler.getPlayers()[0].getMoney() - 1000;
        chanceCardFunctionality.chanceCardFunction(8, playerHandler.getPlayers()[0]);

        assertEquals(money8, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:8");

        //Tester kort id:9
        int money9 = playerHandler.getPlayers()[0].getMoney() - 200;
        chanceCardFunctionality.chanceCardFunction(9, playerHandler.getPlayers()[0]);

        assertEquals(money9, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:9");

        //Tester kort id:10
        int money10 = playerHandler.getPlayers()[0].getMoney() - 2000;
        chanceCardFunctionality.chanceCardFunction(10, playerHandler.getPlayers()[0]);

        assertEquals(money10, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:10");

        //Tester kort id:11
        int money11 = playerHandler.getPlayers()[0].getMoney() + 500;
        chanceCardFunctionality.chanceCardFunction(11, playerHandler.getPlayers()[0]);

        assertEquals(money11, playerHandler.getPlayers()[0].getMoney(), "Tester card ID:11");

        //Tester kort id:12
        int money12 = playerHandler.getPlayers()[0].getMoney() + 500;
        chanceCardFunctionality.chanceCardFunction(12, playerHandler.getPlayers()[0]);

        assertEquals(money12, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:12");

        //Tester kort id:13
        int money13 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(13, playerHandler.getPlayers()[0]);

        assertEquals(money13, playerHandler.getPlayers()[0].getMoney(), "Tester card ID:13");

        //Tester kort id:14
        int money14 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(14, playerHandler.getPlayers()[0]);

        assertEquals(money14, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:14");

        //Tester kort id:15
        int money15 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(15, playerHandler.getPlayers()[0]);

        assertEquals(money15, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:15");

        //Tester kort id:16
        int money16 = playerHandler.getPlayers()[0].getMoney() + 3000;
        chanceCardFunctionality.chanceCardFunction(16, playerHandler.getPlayers()[0]);

        assertEquals(money16, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:16");

        //Tester kort id:17
        int money17 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(17, playerHandler.getPlayers()[0]);

        assertEquals(45100, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:17");

        //Tester kort id:18
        int money18 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(18, playerHandler.getPlayers()[0]);

        assertEquals(money18, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:18");

        //Tester kort id:19
        int money19 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(19, playerHandler.getPlayers()[0]);

        assertEquals(money19, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:19");

        //Tester kort id:20
        int money20 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(20, playerHandler.getPlayers()[0]);

        assertEquals(money20, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:20");

        //Tester kort id:21
        int money21 = playerHandler.getPlayers()[0].getMoney() + 1000;
        chanceCardFunctionality.chanceCardFunction(21, playerHandler.getPlayers()[0]);

        assertEquals(money21, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:21");

        //Tester kort id:22
        int money22 = playerHandler.getPlayers()[0].getMoney() + 200;
        chanceCardFunctionality.chanceCardFunction(22, playerHandler.getPlayers()[0]);

        assertEquals(money22, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:22");

        //Tester kort id:23
        int money23 = playerHandler.getPlayers()[0].getMoney() + 200;
        chanceCardFunctionality.chanceCardFunction(23, playerHandler.getPlayers()[0]);

        assertEquals(money23, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:23");

        //Tester card id:24
        //Testing if it gives money or not if value is under 15000
        playerHandler.getPlayers()[0].setMoney(14500);
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:24, under 15000");
        //And also that it doesn't give it if it's above 15000
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:24, over 15000");
        //And the boundary = 15000
        playerHandler.getPlayers()[0].setMoney(15000);
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(15000, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:24, on 15000");

        //Tetser card id:25
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