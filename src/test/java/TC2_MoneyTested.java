import dtu.players.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TC2_MoneyTested {

    //Ændring af værdi
   final int STARTM = 4000;
    final int MINUS = 200;
    final int PLUS = 300;
    final int BIGMINUS = 4000;
    final int BIGPLUS = 4000;
    final int NEGMINUS = 4001;

    //Forventede værdier
    final int AFT_MINUS = 3800;
    final int AFT_PLUS = 4300;
    final int AFT_BIGMINUS = 0;
    final int AFT_BIGPLUS = 8000;
    final int AFT_NEGMINUS = -1;

    Player player = new Player(1, "Nicklas",STARTM,"Black");

    @Test
    void testLosingMoney() {
        player.setMoney(player.getMoney() - MINUS);

        assertTrue((player.getMoney() == AFT_MINUS), "expected (" + AFT_MINUS + ") should be eaquel to players money: " + player.getMoney());
        System.out.println("player money is: " + player.getMoney() + ", expected value is " + AFT_MINUS);
    }

    @Test
    void testGainingMoney() {
        player.setMoney(player.getMoney() + PLUS);

        assertTrue((player.getMoney() == AFT_PLUS), "expected (" + AFT_PLUS + ") should be eaquel to players money: " + player.getMoney());
        System.out.println("player money is: " + player.getMoney() + ", expected value is " + AFT_PLUS);
    }

    @Test
    void testLosingMuchMoney() {
        player.setMoney(player.getMoney() - BIGMINUS);

        assertTrue((player.getMoney() == AFT_BIGMINUS), "expected (" + AFT_BIGMINUS + ") should be eaquel to players money: " + player.getMoney());
        System.out.println("player money is: " + player.getMoney() + ", expected value is " + AFT_BIGMINUS);
    }

    @Test
    void testGainingMuchMoney() {
        player.setMoney(player.getMoney() + BIGPLUS);

        assertTrue((player.getMoney() == AFT_BIGPLUS), "expected (" + AFT_BIGPLUS + ") should be eaquel to players money: " + player.getMoney());
        System.out.println("player money is: " + player.getMoney() + ", expected value is " + AFT_BIGPLUS);
    }

    @Test
    void testGettingNegativMoney() {
        player.setMoney(player.getMoney() - NEGMINUS);

        assertTrue((player.getMoney() == AFT_NEGMINUS), "expected (" + AFT_NEGMINUS + ") should be eaquel to players money: " + player.getMoney());
        System.out.println("player money is: " + player.getMoney() + ", expected value is " + AFT_NEGMINUS);
    }

}