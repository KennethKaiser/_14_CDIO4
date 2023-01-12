package dtu.controllers;

import dtu.board.BreweryField;
import dtu.board.FerryField;
import dtu.board.Field;

import dtu.board.FieldProperty;

import dtu.dice.RaffleCup;
import dtu.players.Player;
import dtu.players.PlayerHandler;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class BoardController {

    //Controllers
    PlayerViewController playerViewController = ControllerHandler.getInstance().getPlayerViewController();
    CommunicationController communicationController;


    //Model variables
    RaffleCup dice = new RaffleCup();
    PlayerHandler playerHandler = new PlayerHandler();

    //GUI variables
    private ImageView[] cars; //car Icons that move on the field
    private StackPane[] fields; //The Stackpanes that a car is placed in on each field
    private Button[] fieldButtons;


    //region Images on the board
    //All pictures needs instantiating on start
    @FXML
    ImageView prisonImage;
    @FXML
    ImageView policeImage;
    @FXML
    ImageView parkingImage;
    @FXML
    ImageView squashImage;
    @FXML
    ImageView colaImage;
    @FXML
    ImageView ferry1;
    @FXML
    ImageView ferry2;
    @FXML
    ImageView ferry3;
    @FXML
    ImageView ferry4;


    //endregion
    //region Cars Imageview that Moves Across the fields
    @FXML
    ImageView car1;
    @FXML
    ImageView car2;
    @FXML
    ImageView car3;
    @FXML
    ImageView car4;
    @FXML
    ImageView car5;
    @FXML
    ImageView car6;

    ImageView[] playerCars;
    //endregion
    //region Field StackPanes
    @FXML
    StackPane field0;
    @FXML
    StackPane field1;
    @FXML
    StackPane field2;
    @FXML
    StackPane field3;
    @FXML
    StackPane field4;
    @FXML
    StackPane field5;
    @FXML
    StackPane field6;
    @FXML
    StackPane field7;
    @FXML
    StackPane field8;
    @FXML
    StackPane field9;
    @FXML
    StackPane field10;
    @FXML
    StackPane field11;
    @FXML
    StackPane field12;
    @FXML
    StackPane field13;
    @FXML
    StackPane field14;
    @FXML
    StackPane field15;
    @FXML
    StackPane field16;
    @FXML
    StackPane field17;
    @FXML
    StackPane field18;
    @FXML
    StackPane field19;
    @FXML
    StackPane field20;
    @FXML
    StackPane field21;
    @FXML
    StackPane field22;
    @FXML
    StackPane field23;
    @FXML
    StackPane field24;
    @FXML
    StackPane field25;
    @FXML
    StackPane field26;
    @FXML
    StackPane field27;
    @FXML
    StackPane field28;
    @FXML
    StackPane field29;
    @FXML
    StackPane field30;
    @FXML
    StackPane field31;
    @FXML
    StackPane field32;
    @FXML
    StackPane field33;
    @FXML
    StackPane field34;
    @FXML
    StackPane field35;
    @FXML
    StackPane field36;
    @FXML
    StackPane field37;
    @FXML
    StackPane field38;
    @FXML
    StackPane field39;
    //endregion
    //region Field Buttons
    @FXML
    Button backgroundButton;
    @FXML
    Button bField0;
    @FXML
    Button bField1;
    @FXML
    Button bField2;
    @FXML
    Button bField3;
    @FXML
    Button bField4;
    @FXML
    Button bField5;
    @FXML
    Button bField6;
    @FXML
    Button bField7;
    @FXML
    Button bField8;
    @FXML
    Button bField9;
    @FXML
    Button bField10;
    @FXML
    Button bField11;
    @FXML
    Button bField12;
    @FXML
    Button bField13;
    @FXML
    Button bField14;
    @FXML
    Button bField15;
    @FXML
    Button bField16;
    @FXML
    Button bField17;
    @FXML
    Button bField18;
    @FXML
    Button bField19;
    @FXML
    Button bField20;
    @FXML
    Button bField21;
    @FXML
    Button bField22;
    @FXML
    Button bField23;
    @FXML
    Button bField24;
    @FXML
    Button bField25;
    @FXML
    Button bField26;
    @FXML
    Button bField27;
    @FXML
    Button bField28;
    @FXML
    Button bField29;
    @FXML
    Button bField30;
    @FXML
    Button bField31;
    @FXML
    Button bField32;
    @FXML
    Button bField33;
    @FXML
    Button bField34;
    @FXML
    Button bField35;
    @FXML
    Button bField36;
    @FXML
    Button bField37;
    @FXML
    Button bField38;
    @FXML
    Button bField39;

    //endregion
    //region Dice

    @FXML
    ImageView dice1;
    @FXML
    ImageView dice2;



    @FXML
    AnchorPane diceBox;
    //endregion
    //region HouseImages

    @FXML
    ImageView houseBlue1;
    @FXML
    ImageView houseBlue2;
    @FXML
    ImageView houseOrange1;
    @FXML
    ImageView houseOrange2;
    @FXML
    ImageView houseOrange3;
    @FXML
    ImageView houseGreen1;
    @FXML
    ImageView houseGreen2;
    @FXML
    ImageView houseGreen3;
    @FXML
    ImageView houseGrey1;
    @FXML
    ImageView houseGrey2;
    @FXML
    ImageView houseGrey3;
    @FXML
    ImageView houseRed1;
    @FXML
    ImageView houseRed2;
    @FXML
    ImageView houseRed3;
    @FXML
    ImageView houseWhite1;
    @FXML
    ImageView houseWhite2;
    @FXML
    ImageView houseWhite3;
    @FXML
    ImageView houseYellow1;
    @FXML
    ImageView houseYellow2;
    @FXML
    ImageView houseYellow3;
    @FXML
    ImageView housePurple1;
    @FXML
    ImageView housePurple2;
    //endregion

    //region VBOX that needs access because we need to put chancecards and the property menu inside it.
    @FXML
    VBox middleVBOX;



    @FXML
    StackPane middleParent;
    //endregion
    //region cheats and testing
    @FXML
    HBox cheatBox;
    @FXML
    ComboBox cheatDropDown;
    @FXML
    TextField cheatInput;

    @FXML
    Button cheatFieldButton;
    @FXML
    Button cheatMoneyButton;
    @FXML
    Button cheatMoveButton;
    //endregion

    //Methods:
    //------------------------------------------------------------------------------

    //Initializes on start
    @FXML
    public void initialize() {
        initPics();
        setCars();
        initFields();
        initHouses();
        initFieldButtons();
        initializePlayerHandlerPlayerViewController();
    }

    //region delegate model objects to other controller


    public void initializePlayerHandlerPlayerViewController(){

        playerViewController.initializePlayerHandler(this.playerHandler);

    }

    //endregion

    //region Initialize Fields and buttons to fields
    private void initFields(){
        backgroundButton.setOnAction(e -> removeOnScreen());
        fields = new StackPane[40];
        fields[0] = field0;
        fields[1] = field1;
        fields[2] = field2;
        fields[3] = field3;
        fields[4] = field4;
        fields[5] = field5;
        fields[6] = field6;
        fields[7] = field7;
        fields[8] = field8;
        fields[9] = field9;
        fields[10] = field10;
        fields[11] = field11;
        fields[12] = field12;
        fields[13] = field13;
        fields[14] = field14;
        fields[15] = field15;
        fields[16] = field16;
        fields[17] = field17;
        fields[18] = field18;
        fields[19] = field19;
        fields[20] = field20;
        fields[21] = field21;
        fields[22] = field22;
        fields[23] = field23;
        fields[24] = field24;
        fields[25] = field25;
        fields[26] = field26;
        fields[27] = field27;
        fields[28] = field28;
        fields[29] = field29;
        fields[30] = field30;
        fields[31] = field31;
        fields[32] = field32;
        fields[33] = field33;
        fields[34] = field34;
        fields[35] = field35;
        fields[36] = field36;
        fields[37] = field37;
        fields[38] = field38;
        fields[39] = field39;
    }
    private void initFieldButtons(){
        fieldButtons = new Button[40];
        fieldButtons[0] = bField0;
        fieldButtons[1] = bField1;
        fieldButtons[2] = bField2;
        fieldButtons[3] = bField3;
        fieldButtons[4] = bField4;
        fieldButtons[5] = bField5;
        fieldButtons[6] = bField6;
        fieldButtons[7] = bField7;
        fieldButtons[8] = bField8;
        fieldButtons[9] = bField9;
        fieldButtons[10] = bField10;
        fieldButtons[11] = bField11;
        fieldButtons[12] = bField12;
        fieldButtons[13] = bField13;
        fieldButtons[14] = bField14;
        fieldButtons[15] = bField15;
        fieldButtons[16] = bField16;
        fieldButtons[17] = bField17;
        fieldButtons[18] = bField18;
        fieldButtons[19] = bField19;
        fieldButtons[20] = bField20;
        fieldButtons[21] = bField21;
        fieldButtons[22] = bField22;
        fieldButtons[23] = bField23;
        fieldButtons[24] = bField24;
        fieldButtons[25] = bField25;
        fieldButtons[26] = bField26;
        fieldButtons[27] = bField27;
        fieldButtons[28] = bField28;
        fieldButtons[29] = bField29;
        fieldButtons[30] = bField30;
        fieldButtons[31] = bField31;
        fieldButtons[32] = bField32;
        fieldButtons[33] = bField33;
        fieldButtons[34] = bField34;
        fieldButtons[35] = bField35;
        fieldButtons[36] = bField36;
        fieldButtons[37] = bField37;
        fieldButtons[38] = bField38;
        fieldButtons[39] = bField39;
    }
    public Button[] getFieldButtons(){
        if(fieldButtons == null) initFieldButtons();
        return fieldButtons;
    }
    //endregion

    //region Initialize pictures on board
    //set the pictures on the board along with cars.
    public void initPics() {
        try{
            ferry1.setImage(image("src/textures/ferry_card.png"));
            ferry2.setImage(image("src/textures/ferry_card.png"));
            ferry3.setImage(image("src/textures/ferry_card.png"));
            ferry4.setImage(image("src/textures/ferry_card.png"));
            colaImage.setImage(image("src/textures/colaflaske.png"));
            squashImage.setImage(image("src/textures/squash_card.png"));
            policeImage.setImage(image("src/textures/police_man_card.png"));
            prisonImage.setImage(image("src/textures/jail_card.png"));
            parkingImage.setImage(image("src/textures/parking_field.png"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public Image image(String url) throws FileNotFoundException {
        InputStream stream = new FileInputStream(url);
        Image image = new Image(stream);
        return image;
    }


    //endregion

    //region Initialize Cars
    private void setCars(){
        cars = new ImageView[6];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        cars[4] = car5;
        cars[5] = car6;
    }
    public void startCars(){
        int amount = ControllerHandler.getInstance().getMenuScreenController().getMenuAmountOfPlayers();
        Image[] carImages = ControllerHandler.getInstance().getMenuScreenController().getMenuCarColorImages();
        playerCars = new ImageView[amount];
        for(int car = 0; car < cars.length; car++){
            for(int i = 0; i < fields.length; i++){
                if(fields[i].getChildren().contains(cars[car])){
                    fields[i].getChildren().remove(cars[car]);
                    break;
                }
            }
        }
        for(int i = 0; i < playerCars.length; i++){
            playerCars[i] = cars[i];
            playerCars[i].setImage(carImages[i]);
            ControllerHandler.getInstance().getPlayerViewController().setColorOfPlayer(carImages[i], i);
            fields[0].getChildren().add(cars[i]);
            multipleCars(i, 0);
        }
    }
    //endregion

    //region Initialize houses
    public void initHouses(){
        propHouses = new ImageView[40];
        propHouses[1] = houseBlue1;
        propHouses[3] = houseBlue2;
        propHouses[6] = houseOrange1;
        propHouses[8] = houseOrange2;
        propHouses[9] = houseOrange3;
        propHouses[11] = houseGreen1;
        propHouses[13] = houseGreen2;
        propHouses[14] = houseGreen3;
        propHouses[16] = houseGrey1;
        propHouses[18] = houseGrey2;
        propHouses[19] = houseGrey3;
        propHouses[21] = houseRed1;
        propHouses[23] = houseRed2;
        propHouses[24] = houseRed3;
        propHouses[26] = houseWhite1;
        propHouses[27] = houseWhite2;
        propHouses[29] = houseWhite3;
        propHouses[31] = houseYellow1;
        propHouses[32] = houseYellow2;
        propHouses[34] = houseYellow3;
        propHouses[37] = housePurple1;
        propHouses[39] = housePurple2;
        for(int i = 0; i < propHouses.length; i++){
            try{
                if(propHouses[i] != null){
                    propHouses[i].setImage(image("src/textures/houseNulIcon.png"));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //endregion

    /**
     * Initializing 4 players in "players" array. Start GUI should do this later. Also calling currentPlayer method.
     */
    public void initializingPlayers(int playersAdded, String names[], String[] colorNames){

        playerHandler.initializePlayers(playersAdded);

        for(int i = 0; i < playersAdded; i++){
            playerHandler.initializePlayerInPlayers(i, names[i],30000,colorNames[i]);
        }
        playerHandler.currentPlayer();
        ControllerHandler.getInstance().getPlayerViewController().updatePlayerTurn();


    }
    //region game loop actions


    public void roll(){
        int[] playerRoll = dice.roll();


        //If you want to hit double roll everytime
        //playerRoll[0] = 1;
        //playerRoll[1] = 1;

        dice.rolledDouble();


        Player currentPlayer = playerHandler.getCurrentPlayer();

        playerHandler.movePlayer(currentPlayer, playerRoll[0]+playerRoll[1]);
        rollDiceAnimation(playerRoll[0],playerRoll[1]);

        System.out.println("Number of roles: " + dice.getNumberOfDoubles());

        thirdTimeRolledToPrisonOrNot(playerRoll, currentPlayer);


    }

    public void thirdTimeRolledToPrisonOrNot(int[] playerRoll, Player currentPlayer){
        if(dice.getNumberOfDoubles() == 3){
            dice.setNumberOfDoubles(0);
            dice.setRolledDouble(false);
            dice.setOurRolls(null);
            playerHandler.movePlayerChanceCard(playerHandler.getCurrentPlayer(), 10);
            movePLayerOnGUI(playerHandler.getCurrentPlayer().getId(), 10);
            communicationController.thirdDoublePrison(playerHandler.getCurrentPlayer().getName());
        }else{
            communicationController.whatRolled(playerRoll, currentPlayer);
        }
    }

    public void turnMove(){
        int playerId = playerHandler.getCurrentPlayer().getId();
        int playerPosition = playerHandler.getCurrentPlayer().getPosition();

        movePLayerOnGUI(playerId, playerPosition);
        multipleCars(playerId, playerPosition);

        whatField();
    }

    public void moveAfterDoubleInPrison(){

        int[] playerRoll = dice.getOurRolls();
        Player currentPlayer = playerHandler.getCurrentPlayer();

        playerHandler.movePlayer(currentPlayer, playerRoll[0]+playerRoll[1]);

        int playerId = playerHandler.getCurrentPlayer().getId();
        int playerPosition = playerHandler.getCurrentPlayer().getPosition();

        movePLayerOnGUI(playerId, playerPosition);
        multipleCars(playerId, playerPosition);

        whatField();
    }


    public void whatField(){
        String landedLabel = ControllerHandler.getInstance().getBoard().getCurrentBoard()[playerHandler.getCurrentPlayer().getPosition()].landedLabel();
        communicationController.whatLandedOn(landedLabel);
    }

    public void whatType(){
        Field field;
        field = ControllerHandler.getInstance().getBoard().getCurrentBoard()[playerHandler.getCurrentPlayer().getPosition()];
        String type = field.type();

        if(type.equals("buyablefield")){
            buyOrRentCheckerProperty(field);
        }
        else if(type.equals("ferry")){
            buyOrRentCheckerFerry(field);
        }
        else if(type.equals("brewery")){
            buyOrRentCheckerBrewery(field);
        }
        else if(type.equals("dummy")){
            endTurn();
        }
        else if(type.equals("chance")){
            endTurn();
        }
        else if(type.equals("tax")){
            endTurn();
        }
        else if(type.equals("jail")){
            goToJail();
        }


    }

    public void goToJail(){
        Player currentPlayer = playerHandler.getCurrentPlayer();
        playerHandler.moveToPrison(currentPlayer);
        int playerID = currentPlayer.getId();
        int playerPosition = currentPlayer.getPosition();
        movePLayerOnGUI(playerID, playerPosition);
        multipleCars(playerID, playerPosition);
        endTurn();
    }

    public void buyProperty(FieldProperty fieldProperty){
        Player currentPlayer = playerHandler.getCurrentPlayer();

        if(fieldProperty.buy(currentPlayer)){

            int temp = fieldProperty.getProperty().getFamilie();

            playerViewController.addCard(temp, currentPlayer.getId());
            communicationController.playerBoughtProperty(fieldProperty, currentPlayer);
        }
        else{
            communicationController.playerNotEnoughMoney();
        }


    }

    public void buyFerry(FerryField ferryField){
        Player currentPlayer = playerHandler.getCurrentPlayer();

        if(ferryField.buy(currentPlayer)){

            int temp = ferryField.getFerry().getFamilie();

            playerViewController.updatePlayerMoney();
            playerViewController.addCard(temp, currentPlayer.getId());
            communicationController.playerBoughtFerry(ferryField, currentPlayer);
        }
        else{
            communicationController.playerNotEnoughMoney();
        }

    }

    public void buyBrewery(BreweryField breweryField){
        Player currentPlayer = playerHandler.getCurrentPlayer();

        if(breweryField.buy(currentPlayer)){

            int temp = breweryField.getBrewery().getFamily();

            playerViewController.updatePlayerMoney();
            playerViewController.addCard(temp, currentPlayer.getId());
            communicationController.playerBoughtBrewery(breweryField, currentPlayer);
        }
        else{
            communicationController.playerNotEnoughMoney();
        }


    }

    //region prison

    public void rollDoublePrison(){
        int[] ourRoll = dice.roll();
        rollDiceAnimation(ourRoll[0], ourRoll[1]);
        playerHandler.getCurrentPlayer().setJailTurns(playerHandler.getCurrentPlayer().getJailTurns()+1);

        if(dice.isRolledDouble()){
            playerHandler.getCurrentPlayer().setJail(false);
            playerHandler.getCurrentPlayer().setJailTurns(0);
            communicationController.luckInJail();
        }
        else if(playerHandler.getCurrentPlayer().getJailTurns() == 3){
            playerHandler.getCurrentPlayer().setJailTurns(0);
            communicationController.forcedToPay();
        }
        else{
            communicationController.noLuckJail();
        }
    }

    public void payForPrison(){
        Player currentPlayer = playerHandler.getCurrentPlayer();
        currentPlayer.setJail(false);
        playerHandler.changePlayerBalance(currentPlayer, -1000);
        playerViewController.updatePlayerMoney();
        communicationController.payedForPrison();

    }

    public void payForPrisonDouble(){
        Player currentPlayer = playerHandler.getCurrentPlayer();
        currentPlayer.setJail(false);
        playerHandler.changePlayerBalance(currentPlayer, -1000);
        playerViewController.updatePlayerMoney();
        communicationController.payedForPrisonDouble();

    }



    public void useGetOutOfJailCard(){

    }


    //endregion

    public void endTurn(){

        playerHandler.isPlayerBankrupt(playerHandler.getCurrentPlayer());

        if(playerHandler.getCurrentPlayer().isBankrupt()){
            communicationController.playerIsBankrupt(playerHandler.getCurrentPlayer());
        }
        else if(dice.isRolledDouble() && !playerHandler.getCurrentPlayer().isJail()){
                communicationController.extraTurn(playerHandler.getCurrentPlayer().getName());
        }
        else {
            //Ensure double rolls is 0
            dice.setNumberOfDoubles(0);
            //Gets next player and if next player is bankrupt get next player again
            playerHandler.currentPlayer();
            while(playerHandler.getCurrentPlayer().isBankrupt()){
                playerHandler.currentPlayer();
            }

            String playerName = playerHandler.getCurrentPlayer().getName();
            playerViewController.updatePlayerTurn();

            if(playerHandler.checkForChickenDinner()){
                communicationController.endGameTextBox(playerName);
            }else{
                if(playerHandler.getCurrentPlayer().isJail()){
                    communicationController.playerTurnInJail(playerName);
                }
                else{
                    communicationController.playerTurnStart(playerName);
                }

            }

        }

    }

    public void endTurnAfterBankrupt(){

        int temp = playerHandler.getCurrentPlayer().getId();


        //playerHandler.changePlayerArray();

        playerViewController.removePlayerFromPlayerView(temp);
        removeCarPlayer(temp);

        playerHandler.currentPlayer();
        while(playerHandler.getCurrentPlayer().isBankrupt()){
            playerHandler.currentPlayer();
        }
        String playerName = playerHandler.getCurrentPlayer().getName();
        playerViewController.updatePlayerTurn();

        if(playerHandler.checkForChickenDinner()){
            communicationController.endGameTextBox(playerName);
        }else{
            communicationController.playerTurnStart(playerName);
        }




    }


    public void buyOrRentCheckerProperty(Field field){
        FieldProperty fieldProperty = (FieldProperty) field;
        if(fieldProperty.isOwned()){
            if(fieldProperty.getOwner().isJail()){
                communicationController.ownerIsInPrison(fieldProperty.getOwner().getName());
            }
            else {
                if(fieldProperty.getOwner() == playerHandler.getCurrentPlayer()){
                    communicationController.playerAlreadyOwn(fieldProperty.getProperty().getName(), playerHandler.getCurrentPlayer().getName());
                }
                else if(fieldProperty.isPledgeState()){
                    communicationController.fieldIsPledged(fieldProperty.getProperty().getName());
                }
                else {
                    communicationController.payRentProperty(fieldProperty, playerHandler.getCurrentPlayer());
                }

            }

        }
        else{
            communicationController.wantToBuyProperty(fieldProperty);
        }
    }

    public void buyOrRentCheckerFerry(Field field){
        FerryField ferryField = (FerryField) field;
        if(ferryField.getOwned()){
            if(ferryField.getOwner().isJail()){
                communicationController.ownerIsInPrison(ferryField.getOwner().getName());
            }
            else {
                if(ferryField.getOwner() == playerHandler.getCurrentPlayer()){
                    communicationController.playerAlreadyOwn(ferryField.getFerry().getName(), playerHandler.getCurrentPlayer().getName());
                }
                else if(ferryField.isPledgeState()){
                    communicationController.fieldIsPledged(ferryField.getFerry().getName());
                }
                else {
                    communicationController.payRentFerry(ferryField, playerHandler.getCurrentPlayer());
                }
            }

        }
        else{
            communicationController.wantToBuyFerry(ferryField);
        }
    }

    public void buyOrRentCheckerBrewery(Field field){
        BreweryField breweryField = (BreweryField) field;
        if(breweryField.getOwned()){
            if(breweryField.getOwner().isJail()){
                communicationController.ownerIsInPrison(breweryField.getOwner().getName());
            }
            else {
                if(breweryField.getOwner() == playerHandler.getCurrentPlayer()){
                    communicationController.playerAlreadyOwn(breweryField.getBrewery().getName(), playerHandler.getCurrentPlayer().getName());
                }
                else if(breweryField.isPledgeState()){
                    communicationController.fieldIsPledged(breweryField.getBrewery().getName());
                }
                else {
                    communicationController.payRentBrewery(breweryField, playerHandler.getCurrentPlayer());
                }
            }
        }
        else{
            communicationController.wantToBuyBrewery(breweryField);
        }
    }

    public void initializeStartPlayerTurn(){
        communicationController = ControllerHandler.getInstance().getCommunicationController();
        communicationController.playerTurnStart(playerHandler.getCurrentPlayer().getName());

    }



    //endregion

    //region car gui methods
    public void movePLayerOnGUI(int player, int fieldPlacement){
        //Just a cheat implementation
        cheatRemoveCarFromBoard(player);

        fields[fieldPlacement].getChildren().add(playerCars[player]);
    }

    public void multipleCars(int player, int position){
        if(fields == null) initFields();
        int total = 0;
        for(int i = 0; i < cars.length; i++){
            if(fields[position].getChildren().contains(cars[i])) total++;
        }
        if(total < 3){
            cars[player].setTranslateY((total+2)*8);
        }
        else{
            int newTotal = 1;
            for(int n = 0; n < cars.length; n++){
                if(fields[position].getChildren().contains(cars[n])) {
                    cars[n].setTranslateY(newTotal*8+(6-total)*4);
                    newTotal++;
                }
            }

        }



    }
    //endregion

    //region Set house images on board
    private ImageView[] propHouses;
    public void setHousesOn(int totalAmount, int propertyID){
        String[] houseURLS = new String[6];
        houseURLS[0] = "src/textures/houseNulIcon.png";
        houseURLS[1] = "src/textures/house1Icon.png";
        houseURLS[2] = "src/textures/house2Icon.png";
        houseURLS[3] = "src/textures/house3Icon.png";
        houseURLS[4] = "src/textures/house4Icon.png";
        houseURLS[5] = "src/textures/hotelIcon.png";
        try{
            propHouses[propertyID].setImage(image(houseURLS[totalAmount]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    //endregion

    //region Animations
        public void rollDiceAnimation(int die1, int die2) {
        String[] dice = new String[6];
        dice[0] = "src/textures/d1.png";
        dice[1] = "src/textures/d2.png";
        dice[2] = "src/textures/d3.png";
        dice[3] = "src/textures/d4.png";
        dice[4] = "src/textures/d5.png";
        dice[5] = "src/textures/d6.png";
        try {
            dice1.setImage(image(dice[die1-1]));
            dice2.setImage(image(dice[die2-1]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Random rnd = new Random();
        //Position of dice can be between 10 and 500
        setRandomPosition(dice1);
        setRandomPosition(dice2);
        while((dice1.getTranslateX() - dice2.getTranslateX()) < 80 && -80 <(dice1.getTranslateX() - dice2.getTranslateX())){
            setRandomPosition(dice2);
        }
        dice1.setRotate(rnd.nextDouble(0, 360));
        dice2.setRotate(rnd.nextDouble(0, 360));
    }
    public AnchorPane getDiceBox() {
        return diceBox;
    }
    private void setRandomPosition(ImageView dice){
        Random rnd = new Random();
        int cases = rnd.nextInt(1, 4);
        double x = 0;
        double y = 0;
        switch (cases){
            case 1:
                x = rnd.nextDouble(10, 160);
                y = rnd.nextDouble(10, 380);
                break;
            case 2:
                x = rnd.nextDouble(10, 560);
                y = rnd.nextDouble(10, 100);
                break;
            case 3:
                x = rnd.nextDouble(410, 560);
                y = rnd.nextDouble(10, 380);
                break;
        }
        dice.setTranslateX(x);
        dice.setTranslateY(y);
    }
    //endregion

    //region get VBOX to put other fxml files into
    public VBox getMiddleMenuVBox(){
        return this.middleVBOX;
    }
    public StackPane getMiddleParent() {
        return middleParent;
    }
    //endregion

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    //region Buttons on board
    public void giveButtonsFunctions(){
        for(int i = 0; i < fieldButtons.length; i++){
            if(ControllerHandler.getInstance().getBoard().getCurrentBoard()[i] != null){
                int temp = i;
                fieldButtons[i].setOnAction(e -> openCard(temp));
            }
        }
    }

    private void openCard(int i){
        Field[] property = new Field[1];
        property[0] = ControllerHandler.getInstance().getBoard().getCurrentBoard()[i];
        ControllerHandler.getInstance().showCardOnBoard(property, -1);
    }


    private void lineOn(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #ffffff;");
    }
    private void lineOff(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #000000;");
    }

    public void removeOnScreen(){
        ControllerHandler.getInstance().getSceneSwitch().showChanceCardPileInMiddle();
    }
    //endregion

    //region cheating
    public void initCheating(){
        if(ControllerHandler.getInstance().getMenuScreenController().getIsCheating()){
            cheatDropDown.getItems().addAll("Spiller 1", "Spiller 2", "Spiller 3", "Spiller 4", "Spiller 5", "Spiller 6");
            cheatFieldButton.setOnAction(e -> cheatAddField());
            cheatMoneyButton.setOnAction(e -> cheatAddMoney());
            cheatMoveButton.setOnAction(e -> cheatMovePlayer());
            System.out.println("Cheating Engaged");
        }
        else{
            cheatBox.getChildren().clear();
        }
    }
    public void cheatAddField(){
        System.out.println("Cheating for field");
        if(cheatDropDown.getValue() != null){
            String player = cheatDropDown.getValue().toString();
            int playerIndex = 0;
            for(int i = 0; i < 6; i++){
                if(player.equals(("Spiller " + (i+1)))) playerIndex = i;
            }
            String fieldStringID = cheatInput.getText();
            int fieldID = parseInt(fieldStringID);

            Field field = ControllerHandler.getInstance().getBoard().getCurrentBoard()[fieldID];
            boolean playerAlreadyOwns = false;
            for(int i = 0; i < playerHandler.getPlayers().length;i++){
                if(playerHandler.getPlayers()[i].getProperties().contains(field)) playerAlreadyOwns = true;
                if(playerHandler.getPlayers()[i].getFerries().contains(field)) playerAlreadyOwns = true;
                if(playerHandler.getPlayers()[i].getBreweries().contains(field)) playerAlreadyOwns = true;
            }
            if(playerAlreadyOwns){
                System.out.println("Cannot add field [" + fieldID + "] because it is already owned by a player");
            }
            else{
                String type = field.type();
                if(type.equals("buyablefield")) {
                    FieldProperty fieldProperty = (FieldProperty)field;
                    Player cheatPlayer = playerHandler.getPlayers()[playerIndex];
                    if(fieldProperty.buy(cheatPlayer)){
                        int temp = fieldProperty.getProperty().getFamilie();
                        playerViewController.updatePlayerMoney();
                        playerViewController.addCard(temp, cheatPlayer.getId());
                        communicationController.playerBoughtProperty(fieldProperty, cheatPlayer);
                    }
                }
                if(type.equals("ferry")) {
                    FerryField ferryField = (FerryField)field;
                    Player cheatPlayer = playerHandler.getPlayers()[playerIndex];
                    if(ferryField.buy(cheatPlayer)){
                        int temp = ferryField.getFerry().getFamilie();
                        playerViewController.updatePlayerMoney();
                        playerViewController.addCard(temp, cheatPlayer.getId());
                        communicationController.playerBoughtFerry(ferryField, cheatPlayer);
                    }
                }
                if(type.equals("brewery")) {
                    BreweryField breweryField = (BreweryField)field;
                    Player cheatPlayer = playerHandler.getPlayers()[playerIndex];
                    if(breweryField.buy(cheatPlayer)){
                        int temp = breweryField.getBrewery().getFamily();
                        playerViewController.updatePlayerMoney();
                        playerViewController.addCard(temp, cheatPlayer.getId());
                        communicationController.playerBoughtBrewery(breweryField, cheatPlayer);
                    }
                }
            }
        }
        else System.out.println("No player selected");
    }
    public void cheatAddMoney(){
        System.out.println("Cheating for money");
        if(cheatDropDown.getValue() != null){
            String player = cheatDropDown.getValue().toString();
            int playerIndex = 0;
            for(int i = 0; i < 6; i++){
                if(player.equals(("Spiller " + (i+1)))) playerIndex = i;
            }
            String moneyString = cheatInput.getText();
            int money = parseInt(moneyString);
            System.out.println(money);
            Player cheatPlayer = playerHandler.getPlayers()[playerIndex];
            playerHandler.changePlayerBalance(cheatPlayer, money);
            playerViewController.updatePlayerMoney();
            System.out.println(cheatPlayer.getMoney());
        }
        else System.out.println("No player selected");


    }
    public void cheatMovePlayer(){
        System.out.println("Cheating for movement");

        /*
        //You can test for double roll but if you want to test for third double roll to prison you need to test in roll() instead
        int[] cheatRoll = new int[2];

        cheatRoll[0] = 2;
        cheatRoll[1] = 2;

        dice.setOurRolls(cheatRoll);
        dice.rolledDouble();

        System.out.println("n:" + dice.getNumberOfDoubles());

        */
        if(cheatDropDown.getValue() != null){
            String player = cheatDropDown.getValue().toString();
            int playerIndex = 0;
            for(int i = 0; i < 6; i++){
                if(player.equals(("Spiller " + (i+1)))) playerIndex = i;
            }
            String stepsString = cheatInput.getText();
            int steps = parseInt(stepsString);

            //setting the dice sum, not possible to set individual dice with cheats
            dice.setSum(steps);

            System.out.println(steps);


            Player cheatPlayer = playerHandler.getPlayers()[playerIndex];
            playerHandler.movePlayer(cheatPlayer, steps);

            int playerId = cheatPlayer.getId();
            int playerPosition = cheatPlayer.getPosition();

            movePLayerOnGUI(playerId, playerPosition);
            multipleCars(playerId, playerPosition);
            int[] toIntArray = new int[1];
            toIntArray[0] = steps;
            //Switch decision box
            communicationController.whatRolled(toIntArray, playerHandler.getCurrentPlayer());
        }
        else System.out.println("No player selected");

    }
    //endregion

    //region remove car
    public void removeCarPlayer(int playerID){
        StackPane parent;
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getChildren().contains(playerCars[playerID])){
                fields[i].getChildren().remove(playerCars[playerID]);
            }
        }
    }
    //endregion

    public void cheatRemoveCarFromBoard(int player){
        for(int n = 0; n < fields.length; n++){
            fields[n].getChildren().remove(playerCars[player]);
        }
    }


    //Getter dice
    public RaffleCup getDice() {
        return dice;
    }
}
