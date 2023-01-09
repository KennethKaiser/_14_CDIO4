package dtu.controllers;

import dtu.board.*;
import dtu.players.Player;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CommunicationController {


    //Controllers
    BoardController boardController = ControllerHandler.controllerHandler.getBoardController();

    //region FXML
    @FXML
    Button choice1;
    @FXML
    Button choice2;
    @FXML
    Button choice3;
    @FXML
    Text text;
    @FXML
    HBox parent;
    @FXML
    VBox buttonVBox;
    Button[] choices;

    //endregion

    @FXML
    public void initialize(){
        initButtons();
    }

    private void initButtons(){
        choices = new Button[3];
        choices[0] = choice1;
        choices[1] = choice2;
        choices[2] = choice3;
    }
    public void showCommunicationBox(String text, String[] options){
        this.text.setText(text);
        buttonVBox.getChildren().clear();
        parent.setOpacity(1);
        for(int i = 0; i < options.length; i++){
            buttonVBox.getChildren().add(choices[i]);
            choices[i].setText(options[i]);
        }
    }
    public void choiceBuyField(String field, int price, String player){
        String[] choiceOptions = new String[2];
        String textField = (player + " er landet på " + field);
        choiceOptions[0] = ("køb for " + price);
        choiceOptions[1] = ("køb ikke grund");
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> buyField());
        choices[1].setOnAction(e -> doNotBuy());

    }
    public void playerTurnStart(String playerName){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Rul terning";
        String textField = "Det er spiller " + playerName + "'s tur";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.moveAndRoll());


    }

    public void whatRolled(int[] roll){
        String[] choiceOptions = new String[1];

        int total;
        if(roll.length>1) total = roll[0] + roll[1];
        else total = roll[0];
        choiceOptions[0] = "Okay";
        String textField = "Du slog " + total + ". Tryk 'Okay' for at rykke " + total + " felter.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.whatField());

    }

    public void whatLandedOn(String label){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        //String label = boardController.getPlayerHandler().currentPlayer();

        String textField =  label;
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.whatType());
    }

    public void wantToBuyProperty(FieldProperty property){



        String[] choiceOptions = new String[2];

        choiceOptions[0] = "Ja";
        choiceOptions[1] = "Nej";

        String propertyName = property.getProperty().getName();
        int propertyPrice = property.getProperty().getPrice();

        String textField = "Vil du gerne købe " + propertyName + " for " + propertyPrice + "?";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.buyProperty(property));
    }

    public void wantToBuyFerry(FerryField ferry){



        String[] choiceOptions = new String[2];

        choiceOptions[0] = "Ja";
        choiceOptions[1] = "Nej";

        String ferryName = ferry.getFerry().getName();
        int ferryPrice = ferry.getFerry().getPrice();

        String textField = "Vil du gerne købe " + ferryName + " for " + ferryPrice + "?";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.buyFerry(ferry));
    }

    public void wantToBuyBrewery(BreweryField breweryField){



        String[] choiceOptions = new String[2];

        choiceOptions[0] = "Ja";
        choiceOptions[1] = "Nej";

        String breweryName = breweryField.getBrewery().getName();
        int breweryPrice = breweryField.getBrewery().getPrice();

        String textField = "Vil du gerne købe " + breweryName + " for " + breweryPrice + "?";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.buyBrewery(breweryField));
    }



    public void playerBoughtProperty(FieldProperty fieldProperty, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String fieldName = fieldProperty.getProperty().getName();


        String textField = fieldName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerBoughtBrewery(BreweryField breweryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String breweryName = breweryField.getBrewery().getName();


        String textField = breweryName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerBoughtFerry(FerryField ferryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String ferryName = ferryField.getFerry().getName();


        String textField = ferryName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    //region rent
    public void payRentProperty(FieldProperty fieldProperty, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String propertyName = fieldProperty.getProperty().getName();
        String propertyOwner = fieldProperty.getOwner().getName();
        int rent = fieldProperty.getActiveRent();


        String textField = propertyName + " er ejet af " + propertyOwner + ". Betal " + rent + " i leje."  ;
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }
    //endregion




    private void rollDice(){

    }
    private void doNotBuy(){

    }
    private void buyField(){

    }
    public void hideCommunicationBox(){
        parent.setOpacity(0);
    }


}
