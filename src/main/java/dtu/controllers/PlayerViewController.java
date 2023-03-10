package dtu.controllers;

import dtu.board.*;
import dtu.players.PlayerHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PlayerViewController {

    //Model variables
    PlayerHandler playerHandler;



    //region Player Name Tekst
    //tekst elementerne der indeholder navnene på spillerne

    Text[] allPNames;

    @FXML
    Text p1Name;
    @FXML
    Text p2Name;
    @FXML
    Text p3Name;
    @FXML
    Text p4Name;
    @FXML
    Text p5Name;
    @FXML
    Text p6Name;
    //endregion
    //region Player Got "Get out of Jail free card" Icon
    @FXML
    ImageView p1KeyIcon;
    @FXML
    ImageView p2KeyIcon;
    @FXML
    ImageView p3KeyIcon;
    @FXML
    ImageView p4KeyIcon;
    @FXML
    ImageView p5KeyIcon;
    @FXML
    ImageView p6KeyIcon;

    //endregion
    //region Is in Jail Icons
    @FXML
    ImageView p1JailIcon;
    @FXML
    ImageView p2JailIcon;
    @FXML
    ImageView p3JailIcon;
    @FXML
    ImageView p4JailIcon;
    @FXML
    ImageView p5JailIcon;
    @FXML
    ImageView p6JailIcon;
    //endregion
    //region Player Money Text

    Text[] allPMoney;

    @FXML
    Text p1Money;
    @FXML
    Text p2Money;
    @FXML
    Text p3Money;
    @FXML
    Text p4Money;
    @FXML
    Text p5Money;
    @FXML
    Text p6Money;
    //endregion
    //region Propertie card stacks
    //Colour type - Number
    @FXML
    StackPane blueProp1;
    @FXML
    StackPane orangeProp1;
    @FXML
    StackPane greenProp1;
    @FXML
    StackPane greyProp1;
    @FXML
    StackPane redProp1;
    @FXML
    StackPane whiteProp1;
    @FXML
    StackPane yellowProp1;
    @FXML
    StackPane purpleProp1;
    @FXML
    StackPane ferryProp1;
    @FXML
    StackPane sodaProp1;
    @FXML
    StackPane blueProp2;
    @FXML
    StackPane orangeProp2;
    @FXML
    StackPane greenProp2;
    @FXML
    StackPane greyProp2;
    @FXML
    StackPane redProp2;
    @FXML
    StackPane whiteProp2;
    @FXML
    StackPane yellowProp2;
    @FXML
    StackPane purpleProp2;
    @FXML
    StackPane ferryProp2;
    @FXML
    StackPane sodaProp2;
    @FXML
    StackPane blueProp3;
    @FXML
    StackPane orangeProp3;
    @FXML
    StackPane greenProp3;
    @FXML
    StackPane greyProp3;
    @FXML
    StackPane redProp3;
    @FXML
    StackPane whiteProp3;
    @FXML
    StackPane yellowProp3;
    @FXML
    StackPane purpleProp3;
    @FXML
    StackPane ferryProp3;
    @FXML
    StackPane sodaProp3;
    @FXML
    StackPane blueProp4;
    @FXML
    StackPane orangeProp4;
    @FXML
    StackPane greenProp4;
    @FXML
    StackPane greyProp4;
    @FXML
    StackPane redProp4;
    @FXML
    StackPane whiteProp4;
    @FXML
    StackPane yellowProp4;
    @FXML
    StackPane purpleProp4;
    @FXML
    StackPane ferryProp4;
    @FXML
    StackPane sodaProp4;
    @FXML
    StackPane blueProp5;
    @FXML
    StackPane orangeProp5;
    @FXML
    StackPane greenProp5;
    @FXML
    StackPane greyProp5;
    @FXML
    StackPane redProp5;
    @FXML
    StackPane whiteProp5;
    @FXML
    StackPane yellowProp5;
    @FXML
    StackPane purpleProp5;
    @FXML
    StackPane ferryProp5;
    @FXML
    StackPane sodaProp5;
    @FXML
    StackPane blueProp6;
    @FXML
    StackPane orangeProp6;
    @FXML
    StackPane greenProp6;
    @FXML
    StackPane greyProp6;
    @FXML
    StackPane redProp6;
    @FXML
    StackPane whiteProp6;
    @FXML
    StackPane yellowProp6;
    @FXML
    StackPane purpleProp6;
    @FXML
    StackPane ferryProp6;
    @FXML
    StackPane sodaProp6;

    //endregion
    //region Player Info Areas
    VBox[] areas;
    VBox[] parts;
    @FXML
    HBox wholeArea;
    @FXML
    VBox part1;
    @FXML
    VBox part2;
    @FXML
    VBox area1;
    @FXML
    VBox area2;
    @FXML
    VBox area3;
    @FXML
    VBox area4;
    @FXML
    VBox area5;
    @FXML
    VBox area6;

    //endregion
    //region Player property area
    FlowPane[] propAreas;
    StackPane propertyStackPanes[][];
    @FXML
    FlowPane propAreaP1;
    @FXML
    FlowPane propAreaP2;
    @FXML
    FlowPane propAreaP3;
    @FXML
    FlowPane propAreaP4;
    @FXML
    FlowPane propAreaP5;
    @FXML
    FlowPane propAreaP6;

    //endregion
    //region Player Money Area
    FlowPane[] moneyAreas;
    StackPane[][] playerCashAreas;
    Image[] moneyPictures;
    @FXML
    FlowPane moneyAreaP1;
    @FXML
    FlowPane moneyAreaP2;
    @FXML
    FlowPane moneyAreaP3;
    @FXML
    FlowPane moneyAreaP4;
    @FXML
    FlowPane moneyAreaP5;
    @FXML
    FlowPane moneyAreaP6;

    //endregion
    //region car images
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
    ImageView[] cars;
    ImageView[] keyIcons;
    ImageView[] jailIcons;
    //endregion



    //Methods
    //________________________________________________________

    @FXML
    public void initialize(){
        initializeCash();
        initializePropertyCards();
        initializePlayerNameTextArray();
        initializePlayerMoneyTextArray();
        initializePlayerAreaArray();
        initCarImages();
        initIcons();

    }


    /**
     * Initializes a player info area array at start
     */
    public void initIcons(){
        keyIcons = new ImageView[6];
        keyIcons[0] = p1KeyIcon;
        keyIcons[1] = p2KeyIcon;
        keyIcons[2] = p3KeyIcon;
        keyIcons[3] = p4KeyIcon;
        keyIcons[4] = p5KeyIcon;
        keyIcons[5] = p6KeyIcon;
        jailIcons = new ImageView[6];
        jailIcons[0] = p1JailIcon;
        jailIcons[1] = p2JailIcon;
        jailIcons[2] = p3JailIcon;
        jailIcons[3] = p4JailIcon;
        jailIcons[4] = p5JailIcon;
        jailIcons[5] = p6JailIcon;

        for(int i = 0; i < 6; i++){
            setInJailIcon(false, i);
            setGetOutOfJailFreeCard(false, i);
            keyIcons[i].setImage(image("src/textures/key.png"));
            jailIcons[i].setImage(image("src/textures/inJailIcon.png"));
        }
    }
    public void initializePlayerAreaArray(){
        areas = new VBox[6];
        areas[0] = area1;
        areas[1] = area2;
        areas[2] = area3;
        areas[3] = area4;
        areas[4] = area5;
        areas[5] = area6;
        parts = new VBox[2];
        parts[0] = part1;
        parts[1] = part2;


        part1.getChildren().clear();
        part2.getChildren().clear();
    }

    /**
     * Initializes a player name text array at start
     */
    public void initializePlayerNameTextArray(){

        Text[] playerNameText = {p1Name,p2Name,p3Name,p4Name,p5Name,p6Name};

        allPNames = playerNameText;

    }

    /**
     * Initializes a player money text array at start
     */
    public void initializePlayerMoneyTextArray(){

        Text[] playerMoneyText = {p1Money,p2Money,p3Money,p4Money,p5Money,p6Money};
        allPMoney = playerMoneyText;
    }

    /*
    makes the Stackpanes where the cards should be at every player spot and puts them in a Stackpane Array Array,
    this makes it easy to acces from whereever in this controller
     */
    private void initializePropertyCards(){
        propAreas = new FlowPane[6];
        propAreas[0] = propAreaP1;
        propAreas[1] = propAreaP2;
        propAreas[2] = propAreaP3;
        propAreas[3] = propAreaP4;
        propAreas[4] = propAreaP5;
        propAreas[5] = propAreaP6;
        propertyStackPanes = new StackPane[6][];
        for(int i = 0; i < propertyStackPanes.length; i++){
            propAreas[i].getChildren().clear();
            propertyStackPanes[i] = new StackPane[10];
            for(int n = 0; n < propertyStackPanes[i].length; n++){
                propertyStackPanes[i][n] = new StackPane();
                propertyStackPanes[i][n].setLayoutX(1);
                propertyStackPanes[i][n].setLayoutY(50);
                propAreas[i].getChildren().add(propertyStackPanes[i][n]);
            }
        }
    }
    /*
    initializes the cash on screen for every player, by saving the pictures of money along with
     */
    private void initializeCash(){
        moneyPictures = new Image[6];
        moneyPictures[0] = image("src/textures/5000_v2.png");
        moneyPictures[1] = image("src/textures/2000_v2.png");
        moneyPictures[2] = image("src/textures/1000_v2.png");
        moneyPictures[3] = image("src/textures/500_v2.png");
        moneyPictures[4] = image("src/textures/100_v2.png");
        moneyPictures[5] = image("src/textures/50_v2.png");
        moneyAreas = new FlowPane[6];
        moneyAreas[0] = moneyAreaP1;
        moneyAreas[1] = moneyAreaP2;
        moneyAreas[2] = moneyAreaP3;
        moneyAreas[3] = moneyAreaP4;
        moneyAreas[4] = moneyAreaP5;
        moneyAreas[5] = moneyAreaP6;


        playerCashAreas = new StackPane[6][];
        for(int i = 0; i < playerCashAreas.length; i++){
            moneyAreas[i].getChildren().clear();
            playerCashAreas[i] = new StackPane[6];
            for(int n = 0; n < playerCashAreas[i].length; n++){
                playerCashAreas[i][n] = new StackPane();
                playerCashAreas[i][n].setLayoutX(1);
                playerCashAreas[i][n].setLayoutY(50);
                moneyAreas[i].getChildren().add(playerCashAreas[i][n]);
            }
        }
    }


    /*
    's the amount of cash for a singular player, this is called in the update money method, but can be set without it if need be.'
     */
    public void setPlayerShownCash(int player, int moneyAmount){
        int[] cashAmount = new int[6]; //0 = 5000,  5 = 50
        while(moneyAmount > 5000*2){
            moneyAmount -= 5000;
            cashAmount[0] += 1;
        }
        while(moneyAmount > 2000*2){
            moneyAmount -= 2000;
            cashAmount[1] += 1;
        }
        while(moneyAmount > 1000*2){
            moneyAmount -= 1000;
            cashAmount[2] += 1;
        }
        while(moneyAmount > 500*2){
            moneyAmount -= 500;
            cashAmount[3] += 1;
        }
        while(moneyAmount > 100){
            moneyAmount -= 100;
            cashAmount[4] += 1;
        }
        while(moneyAmount >= 50){
            moneyAmount -= 50;
            cashAmount[5] += 1;
        }
        if(moneyAmount > 0){
            System.out.println("Error: There are " + moneyAmount + " extra90");
        }
        for(int i = 0; i < 6; i++){
            playerCashAreas[player][i].getChildren().clear();
            for(int n = 0; n < cashAmount[i]; n++){
                ImageView cash = new ImageView(moneyPictures[i]);
                cash.setFitWidth(45);
                cash.setFitHeight(30);
                if(cashAmount[i] < 4)
                {
                    cash.setTranslateY(n*8);
                    cash.setTranslateX(n*4);
                }
                else {
                    cash.setTranslateY(n * (Math.round((24 / cashAmount[i]))));
                    cash.setTranslateX(n * (Math.round((12 / cashAmount[i]))));
                }
                playerCashAreas[player][i].getChildren().add(cash);
            }
        }

    }
    /**
     * updatePlayerName method updates all players names. It's getting called from BoardController at the moment,
     * but should be called from StartGameController.
     */
    public void updatePlayerName(){
        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            addPlayerInfoArea(areas[i], i);
            String playerName = playerHandler.getPlayers()[i].getName();
            allPNames[i].setText(playerName);
        }

    }
    private void addPlayerInfoArea(VBox player, int number){
        if(number % 2 == 0){
            parts[0].getChildren().add(player);
        }
        else{
            parts[1].getChildren().add(player);
        }
    }

    /**
     * updatePlayerMoney method updates all players Money. It's getting called from BoardController at the moment,
     * but should be called from StartGameController.
     */
    public void updatePlayerMoney(){
        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            int playerMoney = playerHandler.getPlayers()[i].getMoney();
            String s = String.valueOf(playerMoney);
            allPMoney[i].setText(s);
            setPlayerShownCash(i, playerMoney);
        }
    }


    public void initializePlayerHandler(PlayerHandler playerHandler){
        this.playerHandler = playerHandler;
    }
    //region show turn
    public void updatePlayerTurn(){
        if(playerHandler != null){



            int player = playerHandler.getCurrentPlayer().getId();
            for(int i = 0; i < areas.length; i++){
                System.out.println(i);
                if(i == player) areas[i].setStyle(areas[i].getStyle() + ";-fx-border-color: #00aa00; -fx-border-width: 3");
                else areas[i].setStyle(areas[i].getStyle() + ";-fx-border-color: grey;-fx-border-width: 3");
            }
        }
        else System.out.println("No playerhandler instantiated yet");
    }

    //endregion
    //region adding, removing and functions of cards

    /*
    openOwnedCard is the function that happens when a card given to a player is clicked,
    it should open a card on the middle platform,
    but if that specific player has two of the same family it should open both.
     */
    public void openOwnedCard(int family, int player){
        if(playerHandler.getPlayers()[player].getProperties() != null){
            if(family < 9){
                int size = propertyStackPanes[player][family-1].getChildren().size();
                Field[] properties = new Field[size];
                Field[] gameCards = ControllerHandler.getInstance().getBoard().getCurrentBoard();
                for(int i = 0; i < properties.length; i++){
                    switch (family){
                        case 1:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[1])){
                                if(!Arrays.asList(properties).contains(gameCards[1])){
                                    properties[i] = gameCards[1];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[3])){
                                if(!Arrays.asList(properties).contains(gameCards[3])){
                                    properties[i] = gameCards[3];
                                    break;
                                }
                            }
                            break;
                        case 2:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[6])){
                                if(!Arrays.asList(properties).contains(gameCards[6])){
                                    properties[i] = gameCards[6];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[8])){
                                if(!Arrays.asList(properties).contains(gameCards[8])){
                                    properties[i] = gameCards[8];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[9])){
                                if(!Arrays.asList(properties).contains(gameCards[9])){
                                    properties[i] = gameCards[9];
                                    break;
                                }
                            }
                            break;
                        case 3:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[11])){
                                if(!Arrays.asList(properties).contains(gameCards[11])){
                                    properties[i] = gameCards[11];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[13])){
                                if(!Arrays.asList(properties).contains(gameCards[13])){
                                    properties[i] = gameCards[13];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[14])){
                                if(!Arrays.asList(properties).contains(gameCards[14])){
                                    properties[i] = gameCards[14];
                                    break;
                                }
                            }
                            break;
                        case 4:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[16])){
                                if(!Arrays.asList(properties).contains(gameCards[16])){
                                    properties[i] = gameCards[16];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[18])){
                                if(!Arrays.asList(properties).contains(gameCards[18])){
                                    properties[i] = gameCards[18];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[19])){
                                if(!Arrays.asList(properties).contains(gameCards[19])){
                                    properties[i] = gameCards[19];
                                    break;
                                }
                            }
                            break;
                        case 5:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[21])){
                                if(!Arrays.asList(properties).contains(gameCards[21])){
                                    properties[i] = gameCards[21];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[23])){
                                if(!Arrays.asList(properties).contains(gameCards[23])){
                                    properties[i] = gameCards[23];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[24])){
                                if(!Arrays.asList(properties).contains(gameCards[24])){
                                    properties[i] = gameCards[24];
                                    break;
                                }
                            }
                            break;
                        case 6:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[26])){
                                if(!Arrays.asList(properties).contains(gameCards[26])){
                                    properties[i] = gameCards[26];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[27])){
                                if(!Arrays.asList(properties).contains(gameCards[27])){
                                    properties[i] = gameCards[27];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[29])){
                                if(!Arrays.asList(properties).contains(gameCards[29])){
                                    properties[i] = gameCards[29];
                                    break;
                                }
                            }
                            break;
                        case 7:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[31])){
                                if(!Arrays.asList(properties).contains(gameCards[31])){
                                    properties[i] = gameCards[31];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[32])){
                                if(!Arrays.asList(properties).contains(gameCards[32])){
                                    properties[i] = gameCards[32];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[34])){
                                if(!Arrays.asList(properties).contains(gameCards[34])){
                                    properties[i] = gameCards[34];
                                    break;
                                }
                            }
                            break;
                        case 8:
                            //if player owns any of these properties add property
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[37])){
                                if(!Arrays.asList(properties).contains(gameCards[37])){
                                    properties[i] = gameCards[37];
                                    break;
                                }
                            }
                            if(hasProperty(playerHandler.getPlayers()[player].getProperties(), gameCards[39])){
                                if(!Arrays.asList(properties).contains(gameCards[39])){
                                    properties[i] = gameCards[39];
                                    break;
                                }
                            }
                            break;
                    }
                }

                if(properties[0] != null) ControllerHandler.getInstance().showCardOnBoard(properties, player);
            }
            if(family == 9){
                //ferry
                int size = propertyStackPanes[player][family-1].getChildren().size();
                Field[] properties = new Field[size];
                Field[] gameCards = ControllerHandler.getInstance().getBoard().getCurrentBoard();
                for(int i = 0; i < size; i++){
                    //if player owns any of these properties add property
                    if(hasProperty(playerHandler.getPlayers()[player].getFerries(), gameCards[5])){
                        if(!Arrays.asList(properties).contains(gameCards[5])){
                            properties[i] = gameCards[5];
                            i++;
                        }
                    }
                    if(hasProperty(playerHandler.getPlayers()[player].getFerries(), gameCards[15])){
                        if(!Arrays.asList(properties).contains(gameCards[15])){
                            properties[i] = gameCards[15];
                            i++;
                        }
                    }
                    if(hasProperty(playerHandler.getPlayers()[player].getFerries(), gameCards[25])){
                        if(!Arrays.asList(properties).contains(gameCards[25])){
                            properties[i] = gameCards[25];
                            i++;
                        }
                    }
                    if(hasProperty(playerHandler.getPlayers()[player].getFerries(), gameCards[35])){
                        if(!Arrays.asList(properties).contains(gameCards[35])){
                            properties[i] = gameCards[35];
                            i++;
                        }
                    }
                    System.out.println(properties[0] == null);
                }
                if(properties[0] != null) ControllerHandler.getInstance().showCardOnBoard(properties, player);
            }
            if(family == 10){
                //soda
                int size = propertyStackPanes[player][family-1].getChildren().size();
                Field[] properties = new Field[size];
                Field[] gameCards = ControllerHandler.getInstance().getBoard().getCurrentBoard();
                for(int i = 0; i < properties.length; i++){
                    //if player owns any of these properties add property
                    if(hasProperty(playerHandler.getPlayers()[player].getBreweries(), gameCards[12])){
                        if(!Arrays.asList(properties).contains(gameCards[12])){
                            properties[i] = gameCards[12];
                            i++;
                        }
                    }
                    if(hasProperty(playerHandler.getPlayers()[player].getBreweries(), gameCards[28])){
                        if(!Arrays.asList(properties).contains(gameCards[28])){
                            properties[i] = gameCards[28];
                            i++;
                        }
                    }
                    System.out.println(properties[0] == null);

                }
                if(properties[0] != null) ControllerHandler.getInstance().showCardOnBoard(properties, player);
            }
        }
        else System.out.println("player doesn't own any properties");
    }
    private boolean hasProperty(ArrayList<Field> ownedProperties, Field field){

        boolean toReturn = false;
        for(int i = 0; i < ownedProperties.size(); i++){
            if(ownedProperties.contains(field)) toReturn = true;
        }
        if(field.type().equals("buyablefield")){
            if(!toReturn) System.out.println("Player did not have " + ((FieldProperty)field).getProperty().getName());
            return toReturn;
        }
        else if(field.type().equals("ferry")){
            if(!toReturn) System.out.println("Player did not have " + ((FerryField)field).getFerry().getName());
            return toReturn;
        }
        else if(field.type().equals("brewery")){
            if(!toReturn) System.out.println("Player did not have " + ((BreweryField)field).getBrewery().getName());
            return toReturn;
        }
        else return  false;

    }

    /*
    adding and removing a card is pretty much what these two next methods does.
    They only do this on screen, not in the player handler.
     */
    public void addCard(int family, int player){
        Button button = new Button("");
        button.setOnAction(e -> openOwnedCard(family, player));
        setBackgroundColorOf(button, family);
        String style = button.getStyle() + ";-fx-border-width: 1; -fx-border-radius: 3; -fx-background-radius: 3; -fx-border-color: #000000;";
        button.setStyle(style);
        int size = propertyStackPanes[player][family-1].getChildren().size();
        button.setTranslateY(size*8);
        button.setTranslateX(size*4);
        button.setOnMouseEntered(e -> lineOn(button));
        button.setOnMouseExited(e -> lineOff(button));
        propertyStackPanes[player][family-1].getChildren().add(button);
    }
    public void removeCard(Field field){
        int family = 0;
        int player = 0;
        switch (field.type()){
            case "buyablefield":
                ((FieldProperty)field).setOwner(null);
                ((FieldProperty)field).setOwned(false);
                family = ((FieldProperty)field).getProperty().getFamilie();
                for(int i = 0; i < playerHandler.getPlayers().length; i++){
                    if(playerHandler.getPlayers()[i].getProperties().contains(field)){
                        playerHandler.getPlayers()[i].getProperties().remove(field);
                        player = playerHandler.getPlayers()[i].getId();
                    }
                }
                break;
            case "ferry":
                ((FerryField)field).setOwner(null);
                ((FerryField)field).setOwned(false);
                family = ((FerryField)field).getFerry().getFamilie();
                for(int i = 0; i < playerHandler.getPlayers().length; i++){
                    if(playerHandler.getPlayers()[i].getFerries().contains(field)){
                        playerHandler.getPlayers()[i].getFerries().remove(field);
                        player = playerHandler.getPlayers()[i].getId();
                    }
                }
                break;
            case "brewery":
                ((BreweryField)field).setOwner(null);
                ((BreweryField)field).setOwned(false);
                family = ((BreweryField)field).getBrewery().getFamily();
                for(int i = 0; i < playerHandler.getPlayers().length; i++){
                    if(playerHandler.getPlayers()[i].getBreweries().contains(field)){
                        playerHandler.getPlayers()[i].getBreweries().remove(field);
                        player = playerHandler.getPlayers()[i].getId();
                    }
                }
                break;
        }

        int size = propertyStackPanes[player][family-1].getChildren().size();
        if(size > 0) propertyStackPanes[player][family-1].getChildren().remove(size-1);
        else System.out.println("no card to remove");
    }

    /*
    line on and line off is a white outline, it can be chanced later if we want.
    but mostly it works as a highlighter for when the mouse is over an object. (card in these instances)
     */
    private void lineOn(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #ffffff;");
    }
    private void lineOff(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #000000;");
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
    private void setBackgroundColorOf(Node node, int family) {

        family--;
        switch (family) {
            case 0: //Blue
                node.setStyle("-fx-background-color: #0000ff;");
                break;
            case 1: //Orange
                node.setStyle("-fx-background-color: #FFA500;");
                break;
            case 2: //Green
                node.setStyle("-fx-background-color:  #32cd32;");
                break;
            case 3: //Grey
                node.setStyle("-fx-background-color:  #aaaaaa;");
                break;
            case 4: //Red
                node.setStyle("-fx-background-color: #ff0000;");
                break;
            case 5: //White
                node.setStyle("-fx-background-color: #ffffff;");
                break;
            case 6: //Yellow
                node.setStyle("-fx-background-color: #FFFF00;");
                break;
            case 7: //Purple
                node.setStyle("-fx-background-color:  #BF40BF;");
                break;
            case 8: //Ferry
                node.setStyle("-fx-background-color:   #00ffff;");
                break;
            case 9: //Soda
                node.setStyle("-fx-background-color:  #FF69B4;");
                break;
            default:
                System.out.println("family is outside of known cases");
                break;
        }
    }
    //endregion
    //region Get out of jail free card ICON
    public boolean isGetOutOfJailFreeCard(int player){
        switch (player+1){
            case 1:
                if(p1KeyIcon.getOpacity() > 0) return true;
                else return false;
            case 2:
                if(p2KeyIcon.getOpacity() > 0) return true;
                else return false;
            case 3:
                if(p3KeyIcon.getOpacity() > 0) return true;
                else return false;
            case 4:
                if(p4KeyIcon.getOpacity() > 0) return true;
                else return false;
            case 5:
                if(p5KeyIcon.getOpacity() > 0) return true;
                else return false;
            case 6:
                if(p6KeyIcon.getOpacity() > 0) return true;
                else return false;
            default:
                System.out.println("Error: could not find isGetOutOfJailFreeCard with player number {" + player + "}");
                break;
        }
        return false;
    }
    public void setGetOutOfJailFreeCard(boolean state, int player){
        int toSet;
        if(state) toSet = 1;
        else toSet = 0;

        keyIcons[player].setOpacity(toSet);
    }


    //endregion
    //region Is in jail ICON
    public boolean isInJail(int player){
        switch (player+1){
            case 1:
                if(p1JailIcon.getOpacity() > 0) return true;
                else return false;
            case 2:
                if(p2JailIcon.getOpacity() > 0) return true;
                else return false;
            case 3:
                if(p3JailIcon.getOpacity() > 0) return true;
                else return false;
            case 4:
                if(p4JailIcon.getOpacity() > 0) return true;
                else return false;
            case 5:
                if(p5JailIcon.getOpacity() > 0) return true;
                else return false;
            case 6:
                if(p6JailIcon.getOpacity() > 0) return true;
                else return false;
            default:
                System.out.println("Error: could not find isInJail with player number {" + player + "}");
                break;
        }
        return false;
    }
    public void setInJailIcon(boolean state, int player){
        int toSet;
        if(state) toSet = 1;
        else toSet = 0;

        jailIcons[player].setOpacity(toSet);
    }
    //endregion
    //region Set Player Name
    public void setName(String name, int player){
        switch (player-1){

            case 1:
                p1Name.setText(name);
                break;
            case 2:
                p2Name.setText(name);
                break;
            case 3:
                p3Name.setText(name);
                break;
            case 4:
                p4Name.setText(name);
                break;
            case 5:
                p5Name.setText(name);
                break;
            case 6:
                p6Name.setText(name);
                break;
            default:
                System.out.println("Error: Cannot set player name as player number {"+ player + "} does not exist");
                break;
        }
    }
    //endregion
    //region Set Money
    public void setMoney(int amount, int player){
        switch (player-1){
            case 1:
                p1Money.setText(amount + "");
                break;
            case 2:
                p2Money.setText(amount + "");
                break;
            case 3:
                p3Money.setText(amount + "");
                break;
            case 4:
                p4Money.setText(amount + "");
                break;
            case 5:
                p5Money.setText(amount + "");
                break;
            case 6:
                p6Money.setText(amount + "");
                break;
            default:
                System.out.println("Error: can't set player " + player + "'s money, because the player doesn't exist.");
                break;
        }
    }
    //endregion
    //region set the color icon

    public void setColorOfPlayer(Image image, int player){
        cars[player].setImage(image);
    }
    private void initCarImages(){
        cars = new ImageView[6];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        cars[4] = car5;
        cars[5] = car6;
    }
    //end region

    //region remove player
    public void removePlayerFromPlayerView(int player){
        if(parts[0].getChildren().contains(areas[player]) || parts[1].getChildren().contains(areas[player])){
            switch (player){
                case 0:
                case 2:
                case 4:{
                    parts[0].getChildren().remove(areas[player]);
                    System.out.println("Removed player nr: " + player);
                    break;
                }
                case 1:
                case 3:
                case 5: {

                    parts[1].getChildren().remove(areas[player]);
                    System.out.println("Removed player nr: " + player);
                    break;
                }

            }
        }
        else System.out.println("Player is already removed");
    }

    public HBox getWholeArea() {
        return wholeArea;
    }

    public void removePlayerBankruptOnLoad(){
        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            if(playerHandler.getPlayers()[i].getMoney() < 0){
                removePlayerFromPlayerView(i);
            }
        }
    }

    //endregion
}
