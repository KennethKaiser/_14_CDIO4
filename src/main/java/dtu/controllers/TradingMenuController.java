package dtu.controllers;

import dtu.board.BreweryField;
import dtu.board.FerryField;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class TradingMenuController {

    //region FXML
    @FXML
    FlowPane properties1;
    @FXML
    FlowPane properties2;
    @FXML
    Button makeTradeButton;
    @FXML
    ComboBox<String> player1DropDown;
    @FXML
    ComboBox<String> player2DropDown;
    @FXML
    TextField moneyInput1;
    @FXML
    TextField moneyInput2;
    @FXML
    FlowPane tradeProps1;
    @FXML
    FlowPane tradeProps2;

    @FXML
    VBox card1;
    @FXML
    VBox card2;
    @FXML
    Button add1;
    @FXML
    Button add2;
    @FXML
    Text name1;
    @FXML
    Text name2;
    @FXML
    VBox color1;
    @FXML
    VBox color2;
    @FXML
    ImageView image1;
    @FXML
    ImageView image2;
    @FXML
    HBox cardHolder1;
    @FXML
    HBox cardHolder2;
    @FXML
    Text playerName1;
    @FXML
    Text playerName2;
    @FXML
    Text playerMoney1;
    @FXML
    Text playerMoney2;

    //endregion
    //region variables
    PlayerHandler playerHandler;
    boolean canTrade;
    Player player1;
    Player player2;

    //endregion

    //region initialize
    @FXML
    public void initialize(){
        player1DropDown.setOnAction(e -> updatePlayer());
        player2DropDown.setOnAction(e -> updatePlayer());
        add1.setOnAction(e -> addCardToTrade(0));
        add2.setOnAction(e -> addCardToTrade(1));
    }
    public void onSwitched(){
        playerName1.setText("");
        playerName2.setText("");
        playerHandler = ControllerHandler.getInstance().getBoardController().playerHandler;
        cardHolder1.getChildren().remove(card1);
        cardHolder2.getChildren().remove(card2);
        player1DropDown.setPromptText("Vælg spiller");
        player2DropDown.setPromptText("Vælg spiller");
        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            player1DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
            player2DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
        }

    }
    //endregion
    private void updatePlayer(){
        if(player1DropDown.getValue() != null){
            showPlayerInfo(0);
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                if(playerHandler.getPlayers()[i].getName().equals(player1DropDown.getValue().toString())){
                    player1 = playerHandler.getPlayers()[i];
                }
            }
        }
        if(player2DropDown.getValue() != null) {
            showPlayerInfo(1);
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                if(playerHandler.getPlayers()[i].getName().equals(player2DropDown.getValue().toString())){
                    player2 = playerHandler.getPlayers()[i];
                }
            }
        }
        if(player1DropDown.getValue() != null && player2DropDown.getValue() != null){
            if(!player1DropDown.getValue().toString().equals(player2DropDown.getValue().toString())){
                canTrade = true;
            }
            else{
                sendText("Du kan ikke bytte med dig selv");
                canTrade = false;
            }
        }
        canTrade = false;
    }
    private void showPlayerInfo(int player){
        if(player == 0){
            playerName1.setText(player1.getName());
            playerMoney1.setText(numbersToString(player1.getMoney()));
            cards(player1, properties1);
        }
        else{
            playerName2.setText(player2.getName());
            playerMoney2.setText(numbersToString(player2.getMoney()));
            cards(player2, properties2);
        }
    }
    private void cards(Player player, FlowPane properties){

    }
    public void showCard(int area, Field field){
        String name = "";
        int family = 0;
        Image image = new Image();
        switch (field.type()){
            case "buyablefield":
                name = ((FieldProperty)field).getProperty().getName();
                family = ((FieldProperty)field).getProperty().getFamilie();
                image = image("src/textures/houseNulIcon.png");
                break;
            case "ferry":
                name = ((FerryField)field).getFerry().getName();
                family = ((FerryField)field).getFerry().getFamilie();
                image = image("src/textures/ferry_card.png");
                break;
            case "brewery":
                name = ((BreweryField)field).getBrewery().getName();
                family = ((BreweryField)field).getBrewery().getFamily();
                if(!((BreweryField)field).getBrewery().getName().equals("Coca Cola")) image = image("src/textures/colaflaske.png");
                else image = image("src/textures/squash_card.png");
                break;
        }
        if(area == 0){
            cardHolder1.getChildren().clear();
            cardHolder1.getChildren().add(card1);
            name1.setText(name);
            setColorOf(color1, family);
            image1.setImage(image);
            add1.setOnAction(e -> addCardToTrade(field, area);
        }
        else if(area == 1){
            cardHolder2.getChildren().clear();
            cardHolder2.getChildren().add(card2);
            name2.setText(name);
            setColorOf(color2, family);
            image2.setImage(image);
            add2.setOnAction(e -> addCardToTrade(field, area);
        }
    }
    private void addCardToTrade(Field field, int player){

    }

    //region methods



    private void sendText(String text){
        ControllerHandler.getInstance().getCommunicationController().showOkBox(text);
    }
    private String numbersToString(int number){
        String finalNumber = "";
        if(number>=1000){
            char[] numberToCharacter = (number+"").toCharArray();
            char[] newCharacterArray = new char[numberToCharacter.length+1];
            for(int i = newCharacterArray.length-1; i >= 0;i--){

                if(newCharacterArray.length - (i + 4) < 0){
                    newCharacterArray[i] = numberToCharacter[i-1];
                }
                else if(newCharacterArray.length - (i + 4) == 0){
                    newCharacterArray[i] = '.';
                }
                else{
                    newCharacterArray[i] = numberToCharacter[i];
                }
            }
            for(int i = 0; i < newCharacterArray.length; i++){
                finalNumber += newCharacterArray[i];
            }
            finalNumber += " kr.";
        }
        else finalNumber = number +" kr.";

        return finalNumber;
    }
    private void setColorOf(Node node, int family) {
        switch (family - 1) {
            case 0: //Blue
                node.setStyle(node.getStyle() + "-fx-background-color: #0000ff;");
                break;
            case 1: //Orange
                node.setStyle(node.getStyle() + "-fx-background-color: #FFA500;");
                break;
            case 2: //Green
                node.setStyle(node.getStyle() + "-fx-background-color:  #32cd32;");
                break;
            case 3: //Grey
                node.setStyle(node.getStyle() + "-fx-background-color:  #aaaaaa;");
                break;
            case 4: //Red
                node.setStyle(node.getStyle() + "-fx-background-color: #ff0000;");
                break;
            case 5: //White
                node.setStyle(node.getStyle() + "-fx-background-color: #ffffff;");
                break;
            case 6: //Yellow
                node.setStyle(node.getStyle() + "-fx-background-color: #FFFF00;");
                break;
            case 7: //Purple
                node.setStyle(node.getStyle() + "-fx-background-color:  #BF40BF;");
                break;
            case 8: //Ferry
                node.setStyle(node.getStyle() + "-fx-background-color:   #00ffff;");
                break;
            case 9: //Soda
                node.setStyle(node.getStyle() + "-fx-background-color:   #FF69B4;");
                break;
            default:
                System.out.println("family is outside of known cases");
                break;
        }
        //endregion+

    }
    private Image image(String url){
        try{
            InputStream stream = new FileInputStream(url);
            Image newImage = new Image(stream);
            return newImage;
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
