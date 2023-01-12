package dtu.SaveAndLoad;

import dtu.controllers.ControllerHandler;
import dtu.filereader.CSVFileReader;

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
            for(int i = 0; i < saves.size(); i++){
                if(saves.get(i).equals(name)){
                    exists = true;
                }
                System.out.println("Saved game " + i + ": " + saves.get(i));
            }
            if(exists){
                sendText("Overskriver gemte spil med navnet " + name);
            }
            else{
                sendText("Gemmer nyt spil ved navnet " + name);
            }
            return saveGame(name);
        }
        else{
            sendText("Kunne ikke finde nogen gemte spil");
            return false;
        }
    }
    public boolean delete(String name){
        if(csvFileReader.deleteSave(name)){
            sendText("Deleted Save " + name);
            return true;
        }
        else{
            sendText("Could not find save to delete");
            return false;
        }
    }
    public boolean saveGame(String name){


        return true;
    }
    public boolean load(String name){
        ArrayList<String[]> gameData = csvFileReader.getSavedGame(name);
        return true;
    }
}
