package dtu.SaveAndLoad;

import dtu.board.*;
import dtu.controllers.ControllerHandler;
import dtu.filereader.CSVFileReader;
import dtu.players.Player;
import dtu.players.PlayerHandler;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class SaveAndLoad {


    CSVFileReader csvFileReader = new CSVFileReader();

    private void sendText(String text){
        ControllerHandler.getInstance().getCommunicationController().showOkBox(text);
    }
    public ArrayList<String> getSaves(){
        ArrayList<String> saves = csvFileReader.getSaves();
        return saves;
    }
    public boolean saveAs(String name){
        ArrayList<String> saves = csvFileReader.getSaves();
        if(saves != null){
            boolean exists = false;
            System.out.println("--------------------------------------------------");
            System.out.println("|                  Saved Games                   |");
            System.out.println("--------------------------------------------------");
            for(int i = 0; i < saves.size(); i++){
                if(saves.get(i).equals(name)){
                    exists = true;
                }
                System.out.println("Saved game " + i + ": " + saves.get(i));
            }
            System.out.println("--------------------------------------------------");

            if(exists){
                sendText("Overskriver gemte spil med navnet " + name);
                return saveGame(name);
            }
            else{
                sendText("Gemmer nyt spil ved navnet " + name);
            }
            return saveGame(name);
        }
        else{
            sendText("Gemmer nyt spil ved navnet " + name);
            return saveGame(name);
        }
    }
    public boolean delete(String name){
        if(csvFileReader.deleteSave(name)){
            sendText("Deleted Save " + name);
            return true;
        }
        else{
            sendText("Could not find the save " + name + " to delete");
            return false;
        }
    }
    public boolean saveGame(String name){
        ArrayList<String[]> saveData = new ArrayList<>();
        PlayerHandler ph = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
        stopper(saveData, "PLAYERS_START");
        for(int i = 0; i < ph.getPlayers().length; i++){
            String[] player = new String[8];
            player[0] = ph.getPlayers()[i].getName();
            player[1] = "" + ph.getPlayers()[i].getMoney();
            player[2] = ph.getPlayers()[i].getColor();
            player[3] = "" + ph.getPlayers()[i].getPosition();
            player[4] = "" + ph.getPlayers()[i].getJailTurns();
            if(ph.getPlayers()[i].isGetOutOfJailCard()) player[5] = "true";
            else player[5] = "false";
            if(ph.getPlayers()[i].isJail()) player[6] = "true";
            else player[6] = "false";
            if(ph.getPlayers()[i].isBankrupt()) player[7] = "true";
            else player[7] = "false";
            saveData.add(player);
        }
        stopper(saveData, "PLAYERS_END");
        stopper(saveData, "FIELDS_START");
        Field[] fields = ControllerHandler.getInstance().getBoard().getCurrentBoard();
        for(int i = 0; i < fields.length; i++){
            String[] field = new String[4];
            switch (fields[i].type()){
                case "buyablefield":
                    field[0] = "1";
                    if(((FieldProperty)fields[i]).isOwned()) field[1] = "" + ((FieldProperty)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((FieldProperty)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    field[3] = "" + ((FieldProperty)fields[i]).getBuildings();
                    break;
                case "ferry":
                    field[0] = "2";
                    if(((FerryField)fields[i]).getOwned()) field[1] = "" + ((FerryField)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((FerryField)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    break;
                case "brewery":
                    field[0] = "3";
                    if(((BreweryField)fields[i]).getOwned()) field[1] = "" + ((BreweryField)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((BreweryField)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    break;
                default:
                    field[0] = "0";
                    break;
            }
            saveData.add(field);
        }
        stopper(saveData, "FIELDS_END");
        stopper(saveData, "OTHER_START");
        String[] other = new String[1];
        //Free parking Jackpot
        PlayerHandler playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
        other[0] = "" + playerHandler.getCurrentPlayer().getId();
        saveData.add(other);
        stopper(saveData, "OTHER_END");
        csvFileReader.saveGame(saveData, name);
        return true;
    }
    public boolean load(String name){
        ArrayList<String[]> gameData = csvFileReader.getSavedGame(name);
        ArrayList<String[]> players = new ArrayList<>();
        ArrayList<String[]> fields = new ArrayList<>();
        ArrayList<String[]> other = new ArrayList<>();
        for(int i = 0; i < gameData.size(); i++){
            if(gameData.get(i)[0].equals("PLAYERS_START")){
                for(int n = i+1; n < gameData.size(); n++){
                    if(gameData.get(n)[0].equals("PLAYERS_END")) break;
                    else players.add(gameData.get(n));
                }
            }
            if(gameData.get(i)[0].equals("FIELDS_START")){
                for(int n = i+1; n < gameData.size(); n++){
                    if(gameData.get(n)[0].equals("FIELDS_END")) break;
                    else fields.add(gameData.get(n));
                }
            }
            if(gameData.get(i)[0].equals("OTHER_START")){
                for(int n = i+1; n < gameData.size(); n++){
                    if(gameData.get(n)[0].equals("OTHER_END")) break;
                    else other.add(gameData.get(n));
                }
            }
        } //Splits data into lists
        int amount = players.size();
        String[] names = new String[amount];
        int[] money = new int[amount];
        String[] colors = new String[amount];
        int[] position = new int[amount];
        int[] jailTurn = new int[amount];
        boolean[] isGetOutOfJailFreeCard = new boolean[amount];
        boolean[] isInJail = new boolean[amount];
        boolean[] isBankrupt = new boolean[amount];
        for(int i = 0; i < amount; i++){
            names[i] = players.get(i)[0]; //names
            money[i] = parseInt(players.get(i)[1]); //money
            colors[i] = players.get(i)[2]; //color names
            position[i] = parseInt(players.get(i)[3]); //position
            jailTurn[i] = parseInt(players.get(i)[4]); //jailturns
            if(players.get(i)[5].equals("true")) isGetOutOfJailFreeCard[i] = true; //has get out of jail card
            else isGetOutOfJailFreeCard[i] = false;
            if(players.get(i)[6].equals("true")) isInJail[i] = true; //Is in jail
            else isGetOutOfJailFreeCard[i] = false;
            if(players.get(i)[7].equals("true")) isBankrupt[i] = true; //Is bankrupt
            else isGetOutOfJailFreeCard[i] = false;
        }
        Board board = new Board();
        ControllerHandler.getInstance().getMenuScreenController().loadInfo(colors, names, amount);
        ControllerHandler.getInstance().setBoard(board);
        ControllerHandler.getInstance().switchToBoard(true);
        PlayerHandler playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();

        for(int i = 0; i < fields.size(); i++){
            switch (fields.get(i)[0]){
                case "0": //Not an actual field

                    break;
                case "1": //buyablefield
                    if(!fields.get(i)[1].equals("null")) {
                        Player playerToBuy = playerHandler.getPlayers()[parseInt(fields.get(i)[1])];
                        FieldProperty propertyToBuy = ((FieldProperty)board.getCurrentBoard()[i]);

                        playerHandler.changePlayerBalance(playerToBuy, propertyToBuy.getProperty().getPrice());
                        ControllerHandler.getInstance().getBoardController().buyPropertyTrade(propertyToBuy, playerToBuy); //Player get's property if they had it.
                    }
                    if(fields.get(i)[2].equals("true")) ((FieldProperty)board.getCurrentBoard()[i]).setPledgeState(true); //PledgeState
                    else if(fields.get(i)[2].equals("false")) ((FieldProperty)board.getCurrentBoard()[i]).setPledgeState(false);
                    ((FieldProperty)board.getCurrentBoard()[i]).setBuildings(parseInt(fields.get(i)[3])); //Amount of buildings
                    ControllerHandler.getInstance().getBoardController().setHousesOn(parseInt(fields.get(i)[3]), i);
                    break;
                case "2": //ferry
                    if(!fields.get(i)[1].equals("null")) {
                        Player playerToBuy = playerHandler.getPlayers()[parseInt(fields.get(i)[1])];
                        FerryField propertyToBuy = ((FerryField)board.getCurrentBoard()[i]);

                        playerHandler.changePlayerBalance(playerToBuy, propertyToBuy.getFerry().getPrice());
                        ControllerHandler.getInstance().getBoardController().buyFerryTrade(propertyToBuy, playerToBuy); //Player get's property if they had it.
                    }
                    if(fields.get(i)[2].equals("true")) ((FerryField)board.getCurrentBoard()[i]).setPledgeState(true); //PledgeState
                    else if(fields.get(i)[2].equals("false")) ((FerryField)board.getCurrentBoard()[i]).setPledgeState(false);
                    break;
                case "3": //brewery
                    if(!fields.get(i)[1].equals("null")) {
                        Player playerToBuy = playerHandler.getPlayers()[parseInt(fields.get(i)[1])];
                        BreweryField propertyToBuy = ((BreweryField)board.getCurrentBoard()[i]);

                        playerHandler.changePlayerBalance(playerToBuy, propertyToBuy.getBrewery().getPrice());
                        ControllerHandler.getInstance().getBoardController().buyBreweryTrade(propertyToBuy, playerToBuy); //Player get's property if they had it.
                    }
                    if(fields.get(i)[2].equals("true")) ((BreweryField)board.getCurrentBoard()[i]).setPledgeState(true); //PledgeState
                    else if(fields.get(i)[2].equals("false")) ((BreweryField)board.getCurrentBoard()[i]).setPledgeState(false);
                    break;
            }
        }
        for(int i = 0; i < other.size(); i++){

            int currentPlayerID = parseInt(other.get(i)[0]); //sets the turn to the turn it was when saved.
            System.out.println("Current player turn: " + currentPlayerID);
            while(playerHandler.getCurrentPlayer().getId() != currentPlayerID){
                playerHandler.currentPlayer();
            }
        }
        for(int i = 0; i < amount; i++){
            int current = playerHandler.getPlayers()[i].getMoney();
            int change = current - money[i];
            playerHandler.changePlayerBalance(playerHandler.getPlayers()[i] ,-change);
            playerHandler.getPlayers()[i].setPosition(position[i]);
            ControllerHandler.getInstance().getBoardController().loadCarPosition(playerHandler.getPlayers()[i].getId(), position[i]);
            playerHandler.getPlayers()[i].setGetOutOfJailCard(isGetOutOfJailFreeCard[i]);
            playerHandler.getPlayers()[i].setJail(isInJail[i]);
            playerHandler.getPlayers()[i].setBankrupt(isBankrupt[i]);

        }
        ControllerHandler.getInstance().getPlayerViewController().updatePlayerMoney();
        ControllerHandler.getInstance().getPlayerViewController().removePlayerBankruptOnLoad();
        ControllerHandler.getInstance().getPlayerViewController().updatePlayerTurn();
        ControllerHandler.getInstance().getCommunicationController().playerTurnStart(playerHandler.getCurrentPlayer().getName());

        return true;
    }
    private void stopper(ArrayList<String[]> list, String text){
        String[] info = new String[1];
        info[0] = text;
        list.add(info);
    }
}
