package dtu.chancecard;

import dtu.filereader.CSVFileReader;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import dtu.game.GameActions;

public class ChanceCardFunctionality {
    PlayerHandler playerHandler = new PlayerHandler();
    GameActions gameActions = new GameActions();

    /* Reason why we are initializing the csvFileReader, is so we can get chancecard descriptions for each chancecard.
    by calling something like: String case0 = csvFileReader.getChancecarddesc()[0];

     */
    CSVFileReader csvFileReader = new CSVFileReader();
    public String chanceCardFunction(int id, Player player) {
        switch (id) {
            case 0: {
                //Oliepriserne er steget og De skal betale 500,- pr hus og 2000,- pr hotel.
                //String case0 = csvFileReader.getChancecarddesc()[0];
                break;
            }
            case 1: {
                //Ejendomsskatten er steget. Ekstraudgifterne er: 800,- pr. hus og 2300,- pr. hotel.
                break;
            }
            case 2: {
                //De har kørt overfor "rødt lys". Betal 1000 kroner i bøde.
                gameActions.changePlayerBalance(player, -1000);
                break;
            }
            case 3: {
                //Betal for vognvask og smøring 300,-
                gameActions.changePlayerBalance(player, -300);
                break;
            }
            case 4: {
                //Betal 200,- for levering af 2 kasser øl.
                gameActions.changePlayerBalance(player, -200);
                break;
            }
            case 5: {
                //Betal 3000,- for reparation af deres vogn.
                gameActions.changePlayerBalance(player, -3000);
                break;
            }
            case 6: {
                //Betal 3000,- for reparation af deres vogn.
                gameActions.changePlayerBalance(player, -3000);
                break;
            }
            case 7: {
                //De har købt 4 nye dæk til Deres vogn. Betal 1000,-.
                gameActions.changePlayerBalance(player, -1000);
                break;
            }
            case 8: {
                //De har fået en parkeringsbøde. Betal 200,- i bøde.
                gameActions.changePlayerBalance(player, -200);
                break;
            }
            case 9: {
                //Betal deres bilforsikring 1000,-
                gameActions.changePlayerBalance(player, -1000);
                break;
            }
            case 10: {
                //De har været udenlands og købt for mange Cult Shaker bedre kendt som "Son of a Bitch".  Betal 200,- i told.
                gameActions.changePlayerBalance(player, -200);
                break;
            }
            case 11: {
                //Tandlægeregning. Betal 2000,-
                gameActions.changePlayerBalance(player, -2000);
                break;
            }
            case 12:
            case 13: {
                //De har vundet i klasselotteriet. Modtag 500,-.
                gameActions.changePlayerBalance(player, 500);
                break;
            }
            case 14:
            case 15:
            case 16: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                gameActions.changePlayerBalance(player, 1000);
                break;
            }
            case 17: {
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000,-.
                gameActions.changePlayerBalance(player, 3000);
                break;
            }
            case 18: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                gameActions.changePlayerBalance(player, 1000);
                break;
            }
            case 19: {
                //Grundet en veloverstået lønsamtale har De fået lønforhøjelse. Modtag 1000,-.
                gameActions.changePlayerBalance(player, 1000);
                break;
            }
            case 20:
            case 21: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                gameActions.changePlayerBalance(player, 1000);
                break;
            }
            case 22: {
                //De har solgt nogle gamle møbler på auktion. Modtag 1000,- af banken.
                gameActions.changePlayerBalance(player, 1000);
                break;
            }
            case 23: {
                //Værdien af egen avl fra nyttehaven udgør 200,- som de modtager af banken.
                gameActions.changePlayerBalance(player, 200);
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
                gameActions.movePlayerChanceCard(player, 0);
                break;
            }
            case 29: {
                //Ryk frem til START
                gameActions.movePlayerChanceCard(player, 0);
                break;
            }
            case 30: {
                //Ryk tre felter frem
                playerHandler.movePlayer(player, 3);
            }
            case 31: {
                //Ryk tre felter tilbage
                playerHandler.movePlayer(player, -3);
                break;
            }
            case 32: {
                ////Ryk tre felter tilbage
                playerHandler.movePlayer(player, -3);
                break;
            }
            case 33: {
                //Ryk frem til Frederiksberg Allé. Hvis De passere START  indkasser da 4000 kr.
                playerHandler.movePlayer(player, 11);
                break;
            }
            case 34: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                gameActions.nearestFerry(player);
                break;
            }
            case 35: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                gameActions.nearestFerry(player);
                break;
            }
            case 36: {
                //Tag med Mols-Linien flyt brikken frem og hvis De passerer START indkassér da 4000,-.
                gameActions.movePlayerChanceCard(player, 15);
                break;
            }
            case 37: {
                //Ryk frem til Grønningen hvis De passerer START indkasser da 4000,-.
                gameActions.movePlayerChanceCard(player, 24);
                break;
            }
            case 38: {
                //Ryk frem til Vimmelskaftet hvis de passerer START indkasser da 4000,-.
                gameActions.movePlayerChanceCard(player, 32);
                break;
            }
            case 39: {
                //Tag med den nærmeste færge. Hvis de passerer START indkasser da 4000,-.
                gameActions.nearestFerry(player);
                break;
            }
            case 40: {
                //Ryk frem til Strandvejen. Hvis De passere START  indkasser da 4000,-.
                gameActions.movePlayerChanceCard(player, 19);
                break;
            }
            case 41: {
                //Tag til Rådhuspladsen
                gameActions.movePlayerChanceCard(player, 39);
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
        return "test";
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


