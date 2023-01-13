package dtu.SaveAndLoad;

import dtu.board.*;
import dtu.controllers.ControllerHandler;
import dtu.filereader.CSVFileReader;
import dtu.players.PlayerHandler;

import java.util.ArrayList;

public class SaveAndLoad {


    CSVFileReader csvFileReader = new CSVFileReader();

    private void sendText(String text){
        ControllerHandler.getInstance().getCommunicationController().showOkBox(text);
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
            String[] player = new String[9];
            player[0] = "" + ph.getPlayers()[i].getId();
            player[1] = ph.getPlayers()[i].getName();
            player[2] = "" + ph.getPlayers()[i].getMoney();
            player[3] = ph.getPlayers()[i].getColor();
            player[4] = "" + ph.getPlayers()[i].getPosition();
            player[5] = "" + ph.getPlayers()[i].getJailTurns();
            if(ph.getPlayers()[i].isGetOutOfJailCard()) player[6] = "true";
            else player[6] = "false";
            if(ph.getPlayers()[i].isJail()) player[7] = "true";
            else player[7] = "false";
            if(ph.getPlayers()[i].isBankrupt()) player[8] = "true";
            else player[8] = "false";
            saveData.add(player);
        }
        stopper(saveData, "PLAYERS_END");
        stopper(saveData, "FIELDS_START");
        Field[] fields = ControllerHandler.getInstance().getBoard().getCurrentBoard();
        for(int i = 0; i < fields.length; i++){
            String[] field = new String[4];
            switch (fields[i].type()){
                case "buyablefield":
                    field[0] = "0";
                    if(((FieldProperty)fields[i]).isOwned()) field[1] = "" + ((FieldProperty)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((FieldProperty)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    field[3] = "" + ((FieldProperty)fields[i]).getBuildings();
                    break;
                case "ferry":
                    field[0] = "1";
                    if(((FerryField)fields[i]).getOwned()) field[1] = "" + ((FerryField)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((FerryField)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    break;
                case "brewery":
                    field[0] = "2";
                    if(((BreweryField)fields[i]).getOwned()) field[1] = "" + ((BreweryField)fields[i]).getOwner().getId();
                    else field[1] = "null";
                    if(((BreweryField)fields[i]).isPledgeState()) field[2] = "true";
                    else field[2] = "false";
                    break;
            }
            saveData.add(field);
        }
        stopper(saveData, "FIELDS_END");
        stopper(saveData, "OTHER_START");
        String[] other = new String[1];
        //Free parking Jackpot
        PlayerHandler playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
        other[0] = "" + playerHandler.getCurrentPlayer();
        saveData.add(other);
        stopper(saveData, "OTHER_END");
        csvFileReader.saveGame(saveData, name);
        return true;
    }
    public boolean load(String name){
        ArrayList<String[]> gameData = csvFileReader.getSavedGame(name);
        PlayerHandler playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
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
        for(int i = 0; i < players.size(); i++){
            

        }
        for(int i = 0; i < fields.size(); i++){

        }
        for(int i = 0; i < other.size(); i++){

        }







        return true;
    }
    private void stopper(ArrayList<String[]> list, String text){
        String[] info = new String[1];
        info[0] = text;
        list.add(info);
    }
}
