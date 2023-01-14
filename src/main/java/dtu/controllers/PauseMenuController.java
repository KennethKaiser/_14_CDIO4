package dtu.controllers;

import dtu.SaveAndLoad.SaveAndLoad;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class PauseMenuController {

    @FXML
    Button saveAsButton;
    @FXML
    TextArea saveInput;
    @FXML
    Button exitNoSaveButton;
    @FXML
    Button resumeButton;

    SaveAndLoad saveAndLoad = new SaveAndLoad();

    @FXML
    public void initialize(){
        resumeButton.setOnAction(e -> resumeGame());
        exitNoSaveButton.setOnAction(e -> exitWithoutSaving());
        saveAsButton.setOnAction(e -> saveAs());
    }
    public void saveAs(){
        if(!saveInput.getText().equals("")){
            if(saveInput.getText().equals("CHEAT")){
                ControllerHandler.getInstance().getMenuScreenController().setIsCheating(true);
                ControllerHandler.getInstance().getBoardController().initCheating();
            }
            else saveAndLoad.saveAs(saveInput.getText());
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
