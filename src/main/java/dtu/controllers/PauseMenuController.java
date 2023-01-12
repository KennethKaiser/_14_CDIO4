package dtu.controllers;

import dtu.filereader.SaveAndLoad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PauseMenuController {

    @FXML
    Button saveButton;
    @FXML
    Button saveAsButton;
    @FXML
    Button loadButton;
    @FXML
    TextField saveInput;
    @FXML
    TextField loadInput;
    @FXML
    TextField exitSaveButton;
    @FXML
    TextField exitNoSaveButton;
    @FXML
    Button resumeButton;

    SaveAndLoad saveAndLoad = new SaveAndLoad();
    String save = "";

    @FXML
    public void initialize(){
        resumeButton.setOnAction(e -> resumeGame());
        exitNoSaveButton.setOnAction(e -> exitWithoutSaving());
        exitSaveButton.setOnAction(e -> saveAndExit());
        saveButton.setOnAction(e -> save());
        saveAsButton.setOnAction(e -> saveAs());
        loadButton.setOnAction(e -> load());
    }
    public void load(){
        if(!loadInput.getText().equals("")){
            saveAndLoad.load(loadInput.getText());
        }
        else sendText("Du skal skrive et navn til dit load");
    }
    public void saveAs(){
        if(!saveInput.getText().equals("")){
            saveAndLoad.saveAs(saveInput.getText());
        }
        else sendText("Du skal skrive et navn til dit save");
    }
    public void save(){
        if(saveAndLoad.save(save)){
            sendText("Succesfully saved game: " + save);
        }
    }
    private void sendText(String text){
        ControllerHandler.getInstance().getCommunicationController().showOkBox(text);
    }

    public void saveAndExit(){
        if(saveAndLoad.save(save)){
            System.exit(0);
        }
    }
    public void exitWithoutSaving(){
        System.exit(0);
    }
    public void resumeGame(){
        ControllerHandler.getInstance().getSceneSwitch().removePauseMenu();
    }
}
