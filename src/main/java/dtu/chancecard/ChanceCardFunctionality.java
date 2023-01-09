package dtu.chancecard;

import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.players.Player;
import dtu.players.PlayerHandler;

import java.util.ArrayList;

public class ChanceCardFunctionality {
    PlayerHandler playerHandler = new PlayerHandler();

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
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 3: {
                //Betal for vognvask og smøring 300,-
                playerHandler.changePlayerBalance(player, -300);
                break;
            }
            case 4: {
                //Betal 200,- for levering af 2 kasser øl.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 5: {
                //Betal 3000,- for reparation af deres vogn.
                playerHandler.changePlayerBalance(player, -3000);
                break;
            }
            case 6: {
                //Betal 3000,- for reparation af deres vogn.
                playerHandler.changePlayerBalance(player, -3000);
                break;
            }
            case 7: {
                //De har købt 4 nye dæk til Deres vogn. Betal 1000,-.
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 8: {
                //De har fået en parkeringsbøde. Betal 200,- i bøde.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 9: {
                //Betal deres bilforsikring 1000,-
                playerHandler.changePlayerBalance(player, -1000);
                break;
            }
            case 10: {
                //De har været udenlands og købt for mange Cult Shaker bedre kendt som "Son of a Bitch".  Betal 200,- i told.
                playerHandler.changePlayerBalance(player, -200);
                break;
            }
            case 11: {
                //Tandlægeregning. Betal 2000,-
                playerHandler.changePlayerBalance(player, -2000);
                break;
            }
            case 12:
            case 13: {
                //De har vundet i klasselotteriet. Modtag 500,-.
                playerHandler.changePlayerBalance(player, 500);
                break;
            }
            case 14:
            case 15:
            case 16: {
                //De modtager Deres aktieudbytte. Modtag 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 17: {
                //Kommunen har eftergivet et kvartals skat. Hæv i banken 3000,-.
                playerHandler.changePlayerBalance(player, 3000);
                break;
            }
            case 18: {
                //De have en række med elleve rigtige i tipning. Modtag 1000,-.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 19: {
                //Grundet en veloverstået lønsamtale har De fået lønforhøjelse. Modtag 1000,-.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 20:
            case 21: {
                //Deres præmieobligation er udtrykket. De modtager 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 22: {
                //De har solgt nogle gamle møbler på auktion. Modtag 1000,- af banken.
                playerHandler.changePlayerBalance(player, 1000);
                break;
            }
            case 23: {
                //Værdien af egen avl fra nyttehaven udgør 200,- som de modtager af banken.
                playerHandler.changePlayerBalance(player, 200);
                break;
            }
            case 24: {
                //De modtager “Matador-legatet” på 40.000,-  men kun hvis værdier ikke overstiger 15.000,-
                //getValueOfAllAsssets(player);
            }
            case 25: {
                //Det er deres fødselsdag. Modtag af hver medspiller 200,-.
                playerHandler.getMoneyFromOtherPlayers(player, 200);
                break;
            }
            case 26: {
                //De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.
                playerHandler.getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 27: {
                //De skal holde familiefest og får et tilskud fra hver medspiller på 500,-.
                playerHandler.getMoneyFromOtherPlayers(player, 500);
                break;
            }
            case 28: {
                //Ryk frem til START
                playerHandler.movePlayerChanceCard(player, 0);
                break;
            }
            case 29: {
                //Ryk frem til START
                playerHandler.movePlayerChanceCard(player, 0);
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
                playerHandler.nearestFerry(player);
                break;
            }
            case 35: {
                //Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til. Hvis selskabet ikke ejes af nogen kan De købe det af banken.
                playerHandler.nearestFerry(player);
                break;
            }
            case 36: {
                //Tag med Mols-Linien flyt brikken frem og hvis De passerer START indkassér da 4000,-.
                playerHandler.movePlayerChanceCard(player, 15);
                break;
            }
            case 37: {
                //Ryk frem til Grønningen hvis De passerer START indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 24);
                break;
            }
            case 38: {
                //Ryk frem til Vimmelskaftet hvis de passerer START indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 32);
                break;
            }
            case 39: {
                //Tag med den nærmeste færge. Hvis de passerer START indkasser da 4000,-.
                playerHandler.nearestFerry(player);
                break;
            }
            case 40: {
                //Ryk frem til Strandvejen. Hvis De passere START  indkasser da 4000,-.
                playerHandler.movePlayerChanceCard(player, 19);
                break;
            }
            case 41: {
                //Tag til Rådhuspladsen
                playerHandler.movePlayerChanceCard(player, 39);
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
            case 45: {
                player.setJail(true);
                break;
            }
        }
        return "test";
    }

    /**
     * Takes the getPlayers[].getProperties size (arrayList), and for the player asking on ex. player[0], calculates the value of all properties.
     * This is one of two methods for calculating the total asset of a player if they draw the chanceCard with ID: 24
     * @param player
     * @return
     */
    public int getValueOfPlayersProperties(Player player) {
        int valueOfProperties = 0;
        int priceOfProperties = ((FieldProperty)playerHandler.getPlayers()[player.getId()].getProperties().get(player.getId())).getProperty().getPrice();
        if (playerHandler.getPlayers() != null) {
            for (int i = 0; i < playerHandler.getPlayers()[player.getId()].getProperties().size(); i++) {
                valueOfProperties += priceOfProperties;
            }
        }
        return valueOfProperties;
    }

    public int getValueOfPlayersBuildings(Player player){
        int valueOfBuildings = 0;
        int familie1 = 0;
        int familie1HousePrice = 1000;
        int familie2 = 0;
        int familie2HusPris = 1000;
        int familie3 = 0;
        int familie3HusPris= 2000;
        int familie4 = 0;
        int familie4HusPris;
        ArrayList<Field> playerProperties = playerHandler.getPlayers()[player.getId()].getProperties();
        if (playerHandler.getPlayers() != null){
            for (int i = 0; i < playerProperties.size(); i++){
                if (((FieldProperty)playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getProperty().getFamilie() == 1 ){
                    familie1 = ((FieldProperty) playerHandler.getPlayers()[player.getId()].getProperties().get(i)).getBuildings()*familie1HousePrice;

                }

            }
        }
        return valueOfBuildings;
    }
}



