package dtu.controllers;

import dtu.SaveAndLoad.SaveAndLoad;
import dtu.players.Player;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


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
    @FXML
    Button changeTheme;
    @FXML
    Button color1;
    @FXML
    Button color2;
    @FXML
    Button color3;
    @FXML
    Button color4;

    String currentLoad = "";

    Button[] colors;
    Button currentColor;

    SaveAndLoad saveAndLoad = new SaveAndLoad();
    Player playerCheck = null;

    @FXML
    public void initialize(){
        initColors();
        resumeButton.setOnAction(e -> resumeGame());
        exitNoSaveButton.setOnAction(e -> exitWithoutSaving());
        saveAsButton.setOnAction(e -> saveAs());
        changeTheme.setOnAction(e -> changeTheme());
    }
    public void initColors(){
        colors = new Button[4];
        colors[0] = color1;
        colors[1] = color2;
        colors[2] = color3;
        colors[3] = color4;
        currentColor = colors[0];
        currentColor.setStyle(currentColor.getStyle() + "; -fx-border-color: yellow");
        colors[0].setStyle(colors[0].getStyle() + "; -fx-background-color: #fffee2");
        colors[1].setStyle(colors[1].getStyle() + "; -fx-background-color: #d4ffbd");
        colors[2].setStyle(colors[2].getStyle() + "; -fx-background-color: #91eeff");
        colors[3].setStyle(colors[3].getStyle() + "; -fx-background-color: #ffb1b1");
        colors[0].setOnAction(e -> changeToMe(colors[0]));
        colors[1].setOnAction(e -> changeToMe(colors[1]));
        colors[2].setOnAction(e -> changeToMe(colors[2]));
        colors[3].setOnAction(e -> changeToMe(colors[3]));
    }
    public void changeToMe(Button button){
        currentColor.setStyle(currentColor.getStyle() + "; -fx-border-color: #aaaaaa");
        currentColor = button;
        currentColor.setStyle(currentColor.getStyle() + "; -fx-border-color: yellow");
        setColorOfNode(ControllerHandler.getInstance().getSceneSwitch().getRoot());
    }

    public void changeTheme(){
        currentColor.setStyle(currentColor.getStyle() + "; -fx-border-color: #aaaaaa");
        if (colors[0] == currentColor) {
            currentColor = colors[1];
        }
        else if (colors[1] == currentColor) {
            currentColor = colors[2];

        }
        else if (colors[2] == currentColor) {
            currentColor = colors[3];

        }
        else if (colors[3] == currentColor) {
            currentColor = colors[0];
        }
        currentColor.setStyle(currentColor.getStyle() + "; -fx-border-color: yellow");
        setColorOfNode(ControllerHandler.getInstance().getSceneSwitch().getRoot());
    }

    public void setColorOfNode(Node node){
        if (colors[0] == currentColor) {
            node.setStyle(node.getStyle() + ";-fx-background-color: #fffee2");
        }
        else if (colors[1] == currentColor) {
            node.setStyle(node.getStyle() + ";-fx-background-color: #d4ffbd");
        }
        else if (colors[2] == currentColor) {
            node.setStyle(node.getStyle() + ";-fx-background-color: #91eeff");
        }
        else if (colors[3] == currentColor) {
            node.setStyle(node.getStyle() + ";-fx-background-color: #ffb1b1");
        }
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
            Player playerToGiveUp = ControllerHandler.getInstance().getBoardController().playerHandler.getCurrentPlayer();

            giveUpButton.setText("Giv op for " + playerToGiveUp.getName());
            giveUpButton.setOnAction(e -> giveUpPlayer(playerToGiveUp));
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
