package dtu.chancecard;

import dtu.players.Player;
import dtu.players.PlayerHandler;

public class ChanceCardFunctionality {
    PlayerHandler playerHandler = new PlayerHandler();
    public void chanceCardFunction(int id, Player player) {
        switch (id) {
            case 0: {
                //Oliepriserne er steget  og De skal betale 500,- pr hus og 2000,- pr hotel.
                break;
            }
            case 1: {
                //Ejendomsskatten er steget. Ekstraudgifterne er: 800,- pr. hus og 2300,- pr. hotel.
                break;
            }
            case 2: {
                //De har kørt overfor "rødt lys". Betal 1000 kroner i bøde.
                player.setMoney(player.getMoney() - 1000);
                break;
            }
            case 3: {
                //Betal for vognvask og smøring 300,-
                player.setMoney(player.getMoney() - 300);
                break;
            }
            case 4: {
                //Betal 200,- for levering af 2 kasser øl.
                player.setMoney(player.getMoney() - 200);
                break;
            }
            case 5: {
                //Betal 3000,- for reparation af deres vogn.
                player.setMoney(player.getMoney() - 3000);
                break;
            }
            case 6: {
                //Betal 3000,- for reparation af deres vogn.
                player.setMoney(player.getMoney() - 3000);
                break;
            }
            case 7: {
                //De har købt 4 nye dæk til Deres vogn. Betal 1000,-.
                player.setMoney(player.getMoney() - 1000);
                break;
            }
            case 8: {
                //De har fået en parkeringsbøde. Betal 200,- i bøde.
                player.setMoney(player.getMoney() - 200);
                break;
            }
            case 9: {
                //Betal deres bilforsikring 1000,-
                player.setMoney(player.getMoney() - 1000);
                break;
            }
            case 10: {
                //De har været udenlands og købt for mange Cult Shaker bedre kendt som "Son of a Bitch".  Betal 200,- i told.
                player.setMoney(player.getMoney() - 200);
                break;
            }
            case 11: {
                //Tandlægeregning. Betal 2000,-
                player.setMoney(player.getMoney() - 2000);
                break;
            }
            case 12: {
                //De har vundet i klasselotteriet. Modtag 500,-.
                player.setMoney(player.getMoney() + 500);
                break;
            }
            case 13: {
                //De har vundet i klasselotteriet. Modtag 500,-.
                player.setMoney(player.getMoney() + 500);
                break;
            }
            case 14: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 15: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 16: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 17: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 18: {
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000,-.
                player.setMoney(player.getMoney() + 3000);
                break;
            }
            case 19: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 20: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 21: {
                //Grundet en veloverstået lønsamtale har De fået lønforhøjelse. Modtag 1000,-.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 22: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 23: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 24: {
                //De har solg nogle gamle møbler på auktion. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 25: {
                //Værdien af egen avl fra nyttehaven udgør 200,- som de modtager af banken.
                player.setMoney(player.getMoney() + 200);
                break;
            }
            case 26: {
                //De modtager “Matador-legatet” på 40.000,-  men kun hvis værdier ikke overstiger 15.000,-
                getValueOfAllAsssets(player);
            }
            case 27: {
                //Det er deres fødselsdag. Modtag af hver medspiller 200,-.
                birthdayGiftChanceCard(player);
                    break;
            }
            case 28: {

                break;
            }
            case 29: {

                break;
            }
            case 30: {

                break;
            }
            case 31: {

                break;
            }
            case 32: {

                break;
            }
            case 33: {

                break;
            }
            case 34: {

                break;
            }
            case 35: {

                break;
            }
            case 36: {

                break;
            }
            case 37: {

                break;
            }
            case 38: {

                break;
            }
            case 39: {

                break;
            }
            case 40: {

                break;
            }
            case 41: {

                break;
            }
            case 42: {

                break;
            }
            case 43: {

                break;
            }
            case 44: {

                break;
            }
            case 45: {

                break;
            }
            case 46: {

                break;
            }
        }

    }

    public void getValueOfAllAsssets(Player player) {
        if ((player.getMoney()/*+ add value of ArrayLists of PlayerProperties + Value of house and hotel here */) < 15000) {
            player.setMoney(player.getMoney() + 40000);
        } else {
            player.setMoney(player.getMoney());
        }
    }

    /**
     *
     * birthdayGiftChanceCard takes the lenght of the array of players, and adds that amount times 200 to the current player
     * after that it deducts 200 from each player, also the current player to compensate for the 200 the current player
     * gets too much. Adding money before retracting, so you can't go bankrupt from picking this chancecard.
     * @param player
     */
    public void birthdayGiftChanceCard(Player player) {
        player.setMoney(player.getMoney()+(playerHandler.getPlayers().length*200));
        for (int i=0; i<playerHandler.getPlayers().length; i++){
            playerHandler.getPlayers()[i].setMoney(player.getMoney()-200);
        }
    }
}


