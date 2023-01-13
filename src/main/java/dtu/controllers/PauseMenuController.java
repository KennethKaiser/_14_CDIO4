package dtu.controllers;

import dtu.SaveAndLoad.SaveAndLoad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PauseMenuController {

    @FXML
    Button deleteButton;
    @FXML
    Button saveAsButton;
    @FXML
    Button loadButton;
    @FXML
    TextArea saveInput;
    @FXML
    TextArea loadInput;
    @FXML
    TextArea deleteInput;
    @FXML
    Button exitSaveButton;
    @FXML
    Button exitNoSaveButton;
    @FXML
    Button resumeButton;

    SaveAndLoad saveAndLoad = new SaveAndLoad();

    @FXML
    public void initialize(){
        resumeButton.setOnAction(e -> resumeGame());
        exitNoSaveButton.setOnAction(e -> exitWithoutSaving());
        deleteButton.setOnAction(e -> deleteSave());
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
    public void deleteSave(){
        if(!deleteInput.getText().equals("")){
            saveAndLoad.delete(deleteInput.getText());
        }
        else sendText("Du skal skrive et navn til dit save");
    }
    private void sendText(String text){
        ControllerHandler.getInstance().getCommunicationController().showOkBox(text);
    }
    public void exitWithoutSaving(){
        System.exit(0);
    }
    public void resumeGame(){
        ControllerHandler.getInstance().getSceneSwitch().removePauseMenu();
    }
}
