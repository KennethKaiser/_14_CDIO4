package dtu.controllers;

import dtu.board.*;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CommunicationController {


    //Controllers
    BoardController boardController = ControllerHandler.controllerHandler.getBoardController();
    PlayerViewController playerViewController = ControllerHandler.getInstance().getPlayerViewController();

    ChanceCardsController chanceCardsController = ControllerHandler.getInstance().getChanceCardsController();

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
    @FXML
    StackPane holder;
    @FXML
    Text text2;
    @FXML
    Button okButton;
    @FXML
    VBox okBox;
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
        okButton.setOnAction(e -> holder.getChildren().remove(okBox));
        holder.getChildren().remove(okBox);
    }
    public void showOkBox(String text){
        holder.getChildren().remove(okBox);
        holder.getChildren().add(1, okBox);
        text2.setText(text);
    }
    public void showCommunicationBox(String text, String[] options){
        this.text.setText(text);
        buttonVBox.getChildren().clear();
        parent.setOpacity(1);
        if(options != null) {
            for (int i = 0; i < options.length; i++) {

                buttonVBox.getChildren().add(choices[i]);
                choices[i].setText(options[i]);


            }
        }
    }

    public void playerTurnStart(String playerName){

        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Rul terning";
        String textField = "Det er spiller " + playerName + "'s tur";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.roll());


    }

    public void extraTurn(String playerName){

        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";
        String textField = playerName + " slog et dobbeltslag og får derfor en ekstra tur!";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> playerTurnStart(playerName));

    }

    public void thirdDoublePrison(String playerName){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";
        String textField = playerName + " slog et dobbeltslag for 3. gang i træk og ryger derfor i fængsel";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerTurnInJail(String playerName){
        String[] choiceOptions = new String[2];
        choiceOptions[0] = "Betal 1000 kr";
        choiceOptions[1] = "Prøv at slå dobbeltslag";


        String textField = playerName + "er i fængsel. Du har nu følgende valgmuligheder.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.payForPrison());
        choices[1].setOnAction(e -> boardController.rollDoublePrison());
    }

    public void playerTurnInJailCard(String playerName){
        String[] choiceOptions = new String[3];
        choiceOptions[0] = "Betal 1000 kr";
        choiceOptions[1] = "Prøv at slå dobbeltslag";
        choiceOptions[2] = "Brug 'get out a jail card'";

        String textField = playerName + "er i fængsel. Du har nu følgende valgmuligheder.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.payForPrison());
        choices[1].setOnAction(e -> boardController.rollDoublePrison());
        choices[2].setOnAction(e -> boardController.useGetOutOfJailCard());
    }



    public void payedForPrisonDouble(){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du har nu betalt 1000 kr. Tryk okay for at rykke det antal felter du har slået";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.moveAfterDoubleInPrison());
    }

    public void payedForPrison(){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du har nu betalt for fængsel.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.roll());
    }

    public void usedCardForPrison(){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du har nu brugt dit get out of jail freecard.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.roll());
    }

    public void noLuckJail(){

        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du slog desværre ikke et dobbeltslag.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.endTurn());

    }

    public void luckInJail(){

        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du slog et dobbeltslag og ryger ud af fængslet. Du rykker det antal felter du har slået";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.moveAfterDoubleInPrison());

    }

    public void forcedToPay(){

        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = "Du slog desværre ikke dobbelt. Du har nu brugt 3 forsøg og skal nu betale 1000 kr";

        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.payForPrisonDouble());

    }

    public void ownerIsInPrison(String owner){
        String[] choiceOptions = new String[1];
        choiceOptions[0] = "Okay";

        String textField = owner + " er i fængsel og der skal derfor ikke betales leje";

        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void endGameTextBox(String playerName){

        String[] choiceOptions = null;
        String textField = "TILLYKKE!!! " + playerName + " har vundet spillet!";
        showCommunicationBox(textField, choiceOptions);

    }

    public void whatRolled(int[] roll, Player currentPlayer){
        String[] choiceOptions = new String[1];

        int total;
        if(roll.length>1) total = roll[0] + roll[1];
        else total = roll[0];
        choiceOptions[0] = "Okay";
        String textField = "Du slog " + total + ". Tryk 'Okay' for at rykke " + total + " felter.";
        showCommunicationBox(textField, choiceOptions);
        choices[0].setOnAction(e -> boardController.turnMove());



    }

    public void moneyOverStart(String name){

        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";
        String textField = name + " rykkede over start og modtager 4000 kr.";
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
        choices[1].setOnAction(e-> boardController.endTurn());
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
        choices[1].setOnAction(e-> boardController.endTurn());
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
        choices[1].setOnAction(e-> boardController.endTurn());
    }

    public void youWonJackpot(String playerName, int prize){

        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String textField = playerName + " vandt jackpotten på " + prize + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.addJackpotToPlayer(prize));
    }

    public void addedJackpot(String playerName, int prize){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String textField = prize + " er blevet tilføjet til " + playerName + " balance.";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerBoughtProperty(FieldProperty fieldProperty, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String fieldName = fieldProperty.getProperty().getName();


        playerViewController.updatePlayerMoney();

        String textField = fieldName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerBoughtBrewery(BreweryField breweryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String breweryName = breweryField.getBrewery().getName();

        playerViewController.updatePlayerMoney();

        String textField = breweryName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerBoughtFerry(FerryField ferryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String ferryName = ferryField.getFerry().getName();

        playerViewController.updatePlayerMoney();

        String textField = ferryName + " er købt af " + playerName + ".";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }

    public void playerNotEnoughMoney(){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String textField = "Du har desværre ikke nok penge til at købe.";
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
        int rent = fieldProperty.findActiveRent();
        PlayerHandler ph = ControllerHandler.getInstance().getBoardController().playerHandler;
        player.setLastPlayerPaid(fieldProperty.getOwner().getId());

        if(ph.canAffordTotal(player, rent)){
            fieldProperty.rent(player, rent);
        }
        else{
            ph.changePlayerBalance(fieldProperty.getOwner(), ph.valueOfAllAssets(player)/2 + player.getMoney()/2);
            ph.changePlayerBalance(player, -rent);
        }
        playerViewController.updatePlayerMoney();


        String textField = propertyName + " er ejet af " + propertyOwner + ". Betal " + rent + " i leje."  ;
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }
    public void payRentFerry(FerryField ferryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String ferryName = ferryField.getFerry().getName();
        String ferryOwner = ferryField.getOwner().getName();
        int rent = ferryField.findActiveRent();

        PlayerHandler ph = ControllerHandler.getInstance().getBoardController().playerHandler;
        player.setLastPlayerPaid(ferryField.getOwner().getId());
        if(ph.canAffordTotal(player, rent)){
            ferryField.rent(player, rent);
        }
        else{
            ph.changePlayerBalance(ferryField.getOwner(), ph.valueOfAllAssets(player)/2 + player.getMoney()/2);
            ph.changePlayerBalance(player, -rent);
        }

        playerViewController.updatePlayerMoney();


        String textField = ferryName + " er ejet af " + ferryOwner + ". Betal " + rent + " i leje."  ;
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());

    }

    public void payRentBrewery(BreweryField breweryField, Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();
        String breweryName = breweryField.getBrewery().getName();
        String breweryOwner = breweryField.getOwner().getName();

        int turnRollSum = boardController.getDice().getSum();

        int rent = breweryField.findActiveRent(turnRollSum);

        PlayerHandler ph = ControllerHandler.getInstance().getBoardController().playerHandler;
        player.setLastPlayerPaid(breweryField.getOwner().getId());
        if(ph.canAffordTotal(player, rent)){
            breweryField.rent(player, rent);
        }
        else{
            ph.changePlayerBalance(breweryField.getOwner(), ph.valueOfAllAssets(player)/2 + player.getMoney()/2);
            ph.changePlayerBalance(player, -rent);
        }
        playerViewController.updatePlayerMoney();


        String textField = breweryName + " er ejet af " + breweryOwner + ". Betal " + rent + " i leje.";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());

    }
    public void playerAlreadyOwn(String fieldName, String playerName){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String textField = playerName + " ejer allerede " + fieldName;
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }
    public void fieldIsPledged(String fieldName){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String textField = fieldName + " er pantsat og der skal derfor ikke betales leje";
        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurn());
    }


    //endregion

    public void playerIsBankrupt(Player player){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";

        String playerName = player.getName();

        String textField = playerName + " er gået bankerot og er nu ude af spillet!";

        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.endTurnAfterBankrupt());
    }

    //region tax
    public void taxChoice(TaxField taxField){
        String[] choiceOptions = new String[2];

        choiceOptions[0] = "4000";
        choiceOptions[1] = "10%";

        String textField = "Vil du betale 4000 eller 10% i skat?";

        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.payYourTaxes(taxField, true));
        choices[1].setOnAction(e -> boardController.payYourTaxes(taxField, false));
    }

    public void payTenPercentTax(TaxField taxField){
        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";


        String textField = "Du skal betale 2000 kr i skat";

        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> boardController.payYourExtraTax(taxField));
    }


    //endregion

    //region
    public void chanceCardTurn(String cardText){

        String[] choiceOptions = new String[1];

        choiceOptions[0] = "Okay";


        String textField = cardText;

        chanceCardsController.showChanceCard("Prøv lykken", cardText);

        showCommunicationBox(textField, choiceOptions);

        choices[0].setOnAction(e -> removerOfChanceCard());

    }

    public void removerOfChanceCard(){

        chanceCardsController.hideChanceCard();
        boardController.updateAfterChanceCard();

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
