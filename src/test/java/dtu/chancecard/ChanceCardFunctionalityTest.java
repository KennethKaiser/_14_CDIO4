package dtu.chancecard;

import dtu.board.Chance;
import dtu.board.Jackpot;
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

        //Temp
        Jackpot jackpot = new Jackpot();
        chanceCardFunctionality.setJackpot(jackpot);

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

        assertEquals(money17, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:17");

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
        int money23 = playerHandler.getPlayers()[0].getMoney() + (200 * 2);
        chanceCardFunctionality.chanceCardFunction(23, playerHandler.getPlayers()[0]);

        assertEquals(money23, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:23");

        //Tester card id:24
        int money24 = playerHandler.getPlayers()[0].getMoney() + (500 * 2);
        chanceCardFunctionality.chanceCardFunction(24, playerHandler.getPlayers()[0]);
        assertEquals(money24, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:24");

        //Tetser card id:25
        int money25 = playerHandler.getPlayers()[0].getMoney() + (500 * 2);
        chanceCardFunctionality.chanceCardFunction(25, playerHandler.getPlayers()[0]);
        assertEquals(money25, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:25");

        //Tester card id:26
        //Testing if it gives money or not if value is under 15000
        playerHandler.getPlayers()[0].setMoney(14500);
        chanceCardFunctionality.chanceCardFunction(26, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:26, under 15000");
        //And also that it doesn't give it if it's above 15000
        chanceCardFunctionality.chanceCardFunction(26, playerHandler.getPlayers()[0]);
        assertEquals(54500, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:26, over 15000");
        //And the boundary = 15000
        playerHandler.getPlayers()[0].setMoney(15000);
        chanceCardFunctionality.chanceCardFunction(26, playerHandler.getPlayers()[0]);
        assertEquals(15000, playerHandler.getPlayers()[0].getMoney(),"Tester card ID:26, on 15000");


        //Tester card id:27
        int money27 = playerHandler.getPlayers()[0].getMoney();
        chanceCardFunctionality.chanceCardFunction(27, playerHandler.getPlayers()[0]);
        assertEquals(money27, playerHandler.getPlayers()[0].getMoney(), "Tester card ID:27");

        //Tester card id:28
        int START = 0;
        chanceCardFunctionality.chanceCardFunction(28, playerHandler.getPlayers()[0]);
        assertEquals(START, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:28");

        //Tester card id:29
        playerHandler.getPlayers()[0].setPosition(3);
        chanceCardFunctionality.chanceCardFunction(29, playerHandler.getPlayers()[0]);
        assertEquals(START, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:29");

        //Tester card id:30
        int pos30 = playerHandler.getPlayers()[0].getPosition() + 3;
        chanceCardFunctionality.chanceCardFunction(30, playerHandler.getPlayers()[0]);
        assertEquals(pos30, playerHandler.getPlayers()[0].getPosition(), "Tester card ID:30");

        //Tester card id:31
        int pos31 = playerHandler.getPlayers()[0].getPosition() - 3;
        chanceCardFunctionality.chanceCardFunction(31, playerHandler.getPlayers()[0]);
        assertEquals(pos31, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:31");

        //Tester card id:32
        playerHandler.getPlayers()[0].setPosition(30);
        int pos32 = playerHandler.getPlayers()[0].getPosition() - 3;
        chanceCardFunctionality.chanceCardFunction(32, playerHandler.getPlayers()[0]);
        assertEquals(pos32, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:32");

        //Tester card id:33
        int pos33 = 11;
        chanceCardFunctionality.chanceCardFunction(33, playerHandler.getPlayers()[0]);
        assertEquals(pos33, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:33");

        //Tester card id:34
        playerHandler.getPlayers()[0].setPosition(11);
        int pos34 = 15;
        chanceCardFunctionality.chanceCardFunction(34, playerHandler.getPlayers()[0]);
        assertEquals(pos34, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:34");

        //tester card id:35
        int pos35 = 24;
        chanceCardFunctionality.chanceCardFunction(35, playerHandler.getPlayers()[0]);
        assertEquals(pos35, playerHandler.getPlayers()[0].getPosition(),"Tester card ID: 35");

        //Tester card id:36
        int pos36 = 32;
        chanceCardFunctionality.chanceCardFunction(36, playerHandler.getPlayers()[0]);
        assertEquals(32, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:36");

        //Tester card id:37
        playerHandler.getPlayers()[0].setPosition(32);
        int pos37 = 35;
        chanceCardFunctionality.chanceCardFunction(37, playerHandler.getPlayers()[0]);
        assertEquals(pos37, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:37");

        //Tester card id:38
        int pos38 = 19;
        chanceCardFunctionality.chanceCardFunction(38, playerHandler.getPlayers()[0]);
        assertEquals(pos38, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:38");

        //Tester card id:39
        int pos39 = 39;
        chanceCardFunctionality.chanceCardFunction(39   , playerHandler.getPlayers()[0]);
        assertEquals(pos39, playerHandler.getPlayers()[0].getPosition(),"Tester card ID: 39");

        //Tester card id:40
        chanceCardFunctionality.chanceCardFunction(40, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isGetOutOfJailCard(),"Tester card ID:40");

        //Tester card id:41
        playerHandler.getPlayers()[0].setGetOutOfJailCard(false);
        chanceCardFunctionality.chanceCardFunction(41, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isGetOutOfJailCard(), "Tester card ID:41");

        //Tester card 42
        playerHandler.getPlayers()[0].setPosition(34);
        int pos42 = 35;
        chanceCardFunctionality.chanceCardFunction(42, playerHandler.getPlayers()[0]);
        assertEquals(pos42, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:42");

        //Tester card 43
        playerHandler.getPlayers()[0].setPosition(34);
        int pos43 = 35;
        chanceCardFunctionality.chanceCardFunction(43, playerHandler.getPlayers()[0]);
        assertEquals(pos43, playerHandler.getPlayers()[0].getPosition(),"Tester card ID:43");

        //Tester card id:44
        playerHandler.getPlayers()[0].setGetOutOfJailCard(false);
        playerHandler.getPlayers()[0].setPosition(22);
        assertEquals(false, playerHandler.getPlayers()[0].isJail(),"Tester card ID:44 del1");
        chanceCardFunctionality.chanceCardFunction(44, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isJail(), "Tester card ID:44 del 2");

        //Tester card id:45
        playerHandler.getPlayers()[0].setGetOutOfJailCard(false);
        playerHandler.getPlayers()[0].setPosition(22);
        playerHandler.getPlayers()[0].setJail(false);
        assertEquals(false, playerHandler.getPlayers()[0].isJail(), "Tester card ID:45 del 1");
        chanceCardFunctionality.chanceCardFunction(45, playerHandler.getPlayers()[0]);
        assertEquals(true, playerHandler.getPlayers()[0].isJail(),"Tester card ID:45 del 2");


    }

    @Test
    void testGetNSet() {
        ChanceCardFunctionality chanceCardFunctionality = new ChanceCardFunctionality();
        PlayerHandler playerHandler = new PlayerHandler();
        int StartMoney = 500000;
        //Temp
        Jackpot jackpot = new Jackpot();
        chanceCardFunctionality.setJackpot(jackpot);

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", StartMoney, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 10000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 10000, "red");

        chanceCardFunctionality.setPlayerHandler(playerHandler);

        assertEquals(false,chanceCardFunctionality.isDidPlayerMove(),"Tester spilleren ikke er flyttet");

        chanceCardFunctionality.setDidPlayerMove(true);

        assertEquals(true,chanceCardFunctionality.isDidPlayerMove(),"Tester spilleren har flyttet sig");

        assertEquals(jackpot,chanceCardFunctionality.getJackpot(),"Tester jackpot");

        assertEquals(playerHandler,chanceCardFunctionality.getPlayerHandler(),"Tester playerHandler");

    }

}