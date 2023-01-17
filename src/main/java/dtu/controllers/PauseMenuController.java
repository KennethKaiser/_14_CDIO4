package dtu.controllers;

import dtu.SaveAndLoad.SaveAndLoad;
import dtu.players.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;

public class PauseMenuController {

    @FXML
    Button saveAsButton;
    @FXML
    TextArea saveInput;
    @FXML
    Button exitNoSaveButton;
    @FXML
    Button resumeButton;
    @FXML
    Button giveUpButton;
    String currentLoad = "";


    SaveAndLoad saveAndLoad = new SaveAndLoad();
    Player playerCheck = null;

    @FXML
    public void initialize(){
        resumeButton.setOnAction(e -> resumeGame());
        exitNoSaveButton.setOnAction(e -> exitWithoutSaving());
        saveAsButton.setOnAction(e -> saveAs());
    }

    public String getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(String currentLoad) {
        this.currentLoad = currentLoad;
    }

    public void open(){
        Player playerToGiveUp = ControllerHandler.getInstance().getBoardController().playerHandler.getCurrentPlayer();
        if(!currentLoad.equals("")){
            saveInput.setText(currentLoad);
        }
        giveUpButton.setText("Giv op for " + playerToGiveUp.getName());
        giveUpButton.setOnAction(e -> giveUpPlayer(playerToGiveUp));
    }
    private void giveUpPlayer(Player player){
        if(playerCheck == null){
            playerCheck = player;
            sendText("Er du sikker på at du vil opgive " + player.getName());
        }
        else if(playerCheck == player){
            sendText("Gav alle " + player.getName() + "'s grunde tilbage til banken");
            player.setBankrupt(true);
            ControllerHandler.getInstance().getBoardController().playerHandler.playerIsBankrupt(player);
            ControllerHandler.getInstance().getBoardController().endTurnAfterBankrupt();
        }
    }
    public void saveAs(){
        if(!saveInput.getText().equals("")){
            if(saveInput.getText().equals("CHEAT")){
                ControllerHandler.getInstance().getMenuScreenController().setIsCheating(true);
                ControllerHandler.getInstance().getBoardController().initCheating();
            }
            else {
                saveAndLoad.saveAs(saveInput.getText());
                currentLoad = saveInput.getText();
            }
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
