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
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000,-.
                player.setMoney(player.getMoney() + 3000);
                break;
            }
            case 18: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 19: {
                //Grundet en veloverstået lønsamtale har De fået lønforhøjelse. Modtag 1000,-.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 20: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 21: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 22: {
                //De har solgt nogle gamle møbler på auktion. Modtag 1000,- af banken.
                player.setMoney(player.getMoney() + 1000);
                break;
            }
            case 23: {
                //Værdien af egen avl fra nyttehaven udgør 200,- som de modtager af banken.
                player.setMoney(player.getMoney() + 200);
                break;
            }
            case 24: {
                //De modtager “Matador-legatet” på 40.000,-  men kun hvis værdier ikke overstiger 15.000,-
                getValueOfAllAsssets(player);
            }
            case 25: {
                //Det er deres fødselsdag. Modtag af hver medspiller 200,-.
                getMoneyFromOtherPlayers(player, 200);
                    break;
            }
            case 26: {
                //De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.
                getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 27: {
                //De skal holde familiefest og får et tilskud fra hver medspiller på 500,-.
                getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 28: {
                //Ryk frem til START
                player.setPosition(0);
                break;
            }
            case 29: {
                //Ryk frem til START
                player.setPosition(0);
                break;
            }
            case 30: {
                //Ryk tre felter frem
                player.setPosition(player.getPosition()+3);
            }
            case 31: {
                //Ryk tre felter tilbage
                player.setPosition(player.getPosition()-3);
                break;
            }
            case 32: {
                ////Ryk tre felter tilbage
                player.setPosition(player.getPosition()-3);
                break;
            }
            case 33: {
                //Ryk frem til Frederiksberg Allé. Hvis De passere START  indkasser da 4000 kr.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 34: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 35: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 36: {
                //Tag med Mols-Linien flyt brikken frem og hvis De passerer START indkassér da 4000,-.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 37: {
                //Ryk frem til Grønningen hvis De passerer START indkasser da 4000,-.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 38: {
                //Ryk frem til Vimmelskaftet hvis de passerer START indkasser da 4000,-.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 39: {
                //Tag med den nærmeste færge. Hvis de passerer START indkasser da 4000,-.
                //awaiting method for moving player over start instead of "teleporting" player.

                break;
            }
            case 40: {
                //Ryk frem til Strandvejen. Hvis De passere START  indkasser da 4000,-.
                //awaiting method for moving player over start instead of "teleporting" player.
                break;
            }
            case 41: {
                //Tag til Rådhuspladsen
                player.setPosition(39);
                break;
            }
            case 42: {
                //I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det  eller De kan sælge det.
                player.setGetOutOfJailCard(true);
                break;
            }
            case 43: {
                //I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det  eller De kan sælge det.
                player.setGetOutOfJailCard(true);
                break;
            }
            case 44: {
                player.setJail(true);
                break;
            }
            case 45:{
                player.setJail(true);
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
     * getMoneyFromOtherPlayers takes the length of the array of players, and adds that amount times para2 times to the current player
     * after that it deducts para2 from each player, also the current player to compensate for the para 2 amount the current player
     * gets too much. Adding money before retracting, so you can't go bankrupt from picking this chancecard.
     * @param player
     * @param amount
     */
    public void getMoneyFromOtherPlayers(Player player, int amount) {
        player.setMoney(player.getMoney()+(playerHandler.getPlayers().length*amount));
        for (int i=0; i<playerHandler.getPlayers().length; i++){
            playerHandler.getPlayers()[i].setMoney(player.getMoney()-amount);
        }
    }
}


