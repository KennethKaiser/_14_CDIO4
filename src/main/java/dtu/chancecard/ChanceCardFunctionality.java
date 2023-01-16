package dtu.chancecard;

import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.Jackpot;
import dtu.players.Player;
import dtu.players.PlayerHandler;

import java.util.ArrayList;

public class ChanceCardFunctionality {
    PlayerHandler playerHandler;

    private Jackpot jackpot;

    private boolean didPlayerMove = false;

    public String chanceCardFunction(int id, Player player) {
        switch (id) {
            case 0: {
                //Oliepriserne er steget og De skal betale 500,- pr hus og 2000,- pr hotel.
                int houses = playerHandler.amountOfHouses(playerHandler.getPlayers()[player.getId()]);
                int hotels = playerHandler.amountOfHotels(playerHandler.getPlayers()[player.getId()]);
                playerHandler.changePlayerBalance(playerHandler.getPlayers()[player.getId()], -(houses*500));
                playerHandler.changePlayerBalance(playerHandler.getPlayers()[player.getId()], -(hotels*2000));
                break;
            }
            case 27: {
                //Ejendomsskatten er steget. Ekstraudgifterne er: 800,- pr. hus og 2300,- pr. hotel.
                int houses = playerHandler.amountOfHouses(playerHandler.getPlayers()[player.getId()]);
                int hotels = playerHandler.amountOfHotels(playerHandler.getPlayers()[player.getId()]);
                playerHandler.changePlayerBalance(playerHandler.getPlayers()[player.getId()], -(houses*800));
                playerHandler.changePlayerBalance(playerHandler.getPlayers()[player.getId()], -(hotels*2300));
                break;
            }
            case 1: {
                //De har kørt overfor "rødt lys". Betal 1000 kroner i bøde.
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 2: {
                //Betal for vognvask og smøring 300,-
                playerHandler.changePlayerBalance(player, -300);
                break;
            }
            case 3: {
                //Betal 200,- for levering af 2 kasser øl.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 4: {
                //Betal 3000,- for reparation af deres vogn.
                playerHandler.changePlayerBalance(player, -3000);
                break;
            }
            case 5: {
                //Betal 3000,- for reparation af deres vogn.
                playerHandler.changePlayerBalance(player, -3000);
                break;
            }
            case 6: {
                //De har købt 4 nye dæk til Deres vogn. Betal 1000,-.
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 7: {
                //De har fået en parkeringsbøde. Betal 200,- i bøde.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 8: {
                //Betal deres bilforsikring 1000,-
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 9: {
                //De har været udenlands og købt for mange Cult Shaker bedre kendt som "Son of a Bitch".  Betal 200,- i told.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 10: {
                //Tandlægeregning. Betal 2000,-
                playerHandler.changePlayerBalance(player, -2000);
                break;
            }
            case 11:
            case 12: {
                //De har vundet i klasselotteriet. Modtag 500,-.
                playerHandler.changePlayerBalance(player, 500);
                break;
            }
            case 13:
            case 14:
            case 15: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 16: {
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000,-.
                playerHandler.changePlayerBalance(player, 3000);
                break;
            }
            case 17: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 18: {
                //Grundet en veloverstået lønsamtale har De fået lønforhøjelse. Modtag 1000,-.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 19:
            case 20: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 21: {
                //De har solgt nogle gamle møbler på auktion. Modtag 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 22: {
                //Værdien af egen avl fra nyttehaven udgør 200,- som de modtager af banken.
                playerHandler.changePlayerBalance(player, 200);
                break;
            }
            case 26: {
                //De modtager “Matador-legatet” på 40.000,-  men kun hvis værdier ikke overstiger 15.000,-
                if (playerHandler.valueOfAllAssets(player)<15000){
                    playerHandler.changePlayerBalance(player, 40000);
                }
                break;
            }
            case 23: {
                //Det er deres fødselsdag. Modtag af hver medspiller 200,-.
                playerHandler.getMoneyFromOtherPlayers(player, 200);
                break;
            }
            case 24: {
                //De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.
                playerHandler.getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 25: {
                //De skal holde familiefest og får et tilskud fra hver medspiller på 500,-.
                playerHandler.getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 28: {
                //Ryk frem til START
                playerHandler.movePlayerChanceCard(player, 0);
                didPlayerMove = true;
                break;
            }
            case 29: {
                //Ryk frem til START
                playerHandler.movePlayerChanceCard(player, 0);
                didPlayerMove = true;
                break;
            }
            case 30: {
                //Ryk tre felter frem
                playerHandler.movePlayer(player, 3);
                didPlayerMove = true;
                break;
            }
            case 31: {
                //Ryk tre felter tilbage
                playerHandler.movePlayer(player, -3);
                didPlayerMove = true;
                break;
            }
            case 32: {
                ////Ryk tre felter tilbage
                playerHandler.movePlayer(player, -3);
                didPlayerMove = true;
                break;
            }
            case 33: {
                //Ryk frem til Frederiksberg Allé. Hvis De passere START  indkasser da 4000 kr.
                playerHandler.movePlayerChanceCard(player, 11);
                didPlayerMove = true;
                break;
            }
            case 42: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                playerHandler.nearestFerry(player);
                didPlayerMove = true;
                break;
            }
            case 43: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                playerHandler.nearestFerry(player);
                didPlayerMove = true;
                break;
            }
            case 34: {
                //Tag med Mols-Linien flyt brikken frem og hvis De passerer START indkassér da 4000,-.
                playerHandler.movePlayerChanceCard(player, 15);
                didPlayerMove = true;
                break;
            }
            case 35: {
                //Ryk frem til Grønningen hvis De passerer START indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 24);
                didPlayerMove = true;
                break;
            }
            case 36: {
                //Ryk frem til Vimmelskaftet hvis de passerer START indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 32);
                didPlayerMove = true;
                break;
            }
            case 37: {
                //Tag med den nærmeste færge. Hvis de passerer START indkasser da 4000,-.
                playerHandler.nearestFerry(player);
                didPlayerMove = true;
                break;
            }
            case 38: {
                //Ryk frem til Strandvejen. Hvis De passere START  indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 19);
                didPlayerMove = true;
                break;
            }
            case 39: {
                //Tag til Rådhuspladsen
                playerHandler.movePlayerChanceCard(player, 39);
                didPlayerMove = true;
                break;
            }
            case 40: {
                //I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det  eller De kan sælge det.
                player.setGetOutOfJailCard(true);
                break;
            }
            case 41: {
                //I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det  eller De kan sælge det.
                player.setGetOutOfJailCard(true);
                break;
            }
            case 44: {
                playerHandler.moveToPrison(player);
                didPlayerMove = true;
                break;
            }
            case 45: {
                playerHandler.moveToPrison(player);
                didPlayerMove = true;
                break;
            }
        }
        return "test";
    }


    public void setPlayerHandler(PlayerHandler playerHandler) {
        this.playerHandler = playerHandler;
    }

    public boolean isDidPlayerMove() {
        return didPlayerMove;
    }

    public void setDidPlayerMove(boolean didPlayerMove) {
        this.didPlayerMove = didPlayerMove;
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public Jackpot getJackpot() {
        return jackpot;
    }

    public void setJackpot(Jackpot jackpot) {
        this.jackpot = jackpot;
    }
}



