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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class TradingMenuController {

    //region FXML
    @FXML
    Button closeMenuButton;
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
    ImageView arrowRight;
    @FXML
    ImageView arrowLeft;
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
    ArrayList<Field> addedToTrade1 = new ArrayList<>();
    ArrayList<Field> addedToTrade2 = new ArrayList<>();

    //endregion

    //region initialize
    @FXML
    public void initialize(){
        player1DropDown.setOnAction(e -> updatePlayer());
        player2DropDown.setOnAction(e -> updatePlayer());
        closeMenuButton.setOnAction(e -> closeMenu());
        makeTradeButton.setOnAction(e -> makeTrade());
        arrowRight.setImage(image("src/textures/arrow.png"));
        arrowLeft.setImage(image("src/textures/arrow.png"));
        moneyInput1.setOnAction(e -> moneyConvert(0));
        moneyInput2.setOnAction(e -> moneyConvert(1));
    }
    public void onSwitched(){
        playerName1.setText("");
        playerName2.setText("");
        playerMoney1.setText("");
        playerMoney2.setText("");
        playerHandler = ControllerHandler.getInstance().getBoardController().playerHandler;
        cardHolder1.getChildren().clear();
        cardHolder2.getChildren().clear();
        player1DropDown.setValue("");
        player2DropDown.setValue("");
        properties1.getChildren().clear();
        properties2.getChildren().clear();
        tradeProps1.getChildren().clear();
        tradeProps2.getChildren().clear();
        moneyInput1.setText("");
        moneyInput2.setText("");
        moneyInput1.setPromptText("Penge");
        moneyInput2.setPromptText("Penge");
        player1DropDown.setPromptText("Vælg spiller");
        player2DropDown.setPromptText("Vælg spiller");
        player1DropDown.getItems().clear();
        player2DropDown.getItems().clear();
        for(int i = 0; i < playerHandler.getPlayers().length; i++){
            player1DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
            player2DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
        }
    }
    //endregion
    private void updatePlayer(){
        if(player1DropDown.getValue().equals("") || player1DropDown.getValue() == null){
            player1DropDown.setPromptText("Vælg spiller");
            player1DropDown.getItems().clear();
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                player1DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
            }
            playerName1.setText("");
            playerMoney1.setText("");
            cardHolder1.getChildren().clear();
            properties1.getChildren().clear();
            tradeProps1.getChildren().clear();
        }
        else if(player1DropDown.getValue() != null){
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                if(playerHandler.getPlayers()[i].getName().equals(player1DropDown.getValue().toString())){
                    player1 = playerHandler.getPlayers()[i];
                }
            }
            showPlayerInfo(0);
        }
        if(player2DropDown.getValue().equals("") || player2DropDown.getValue() == null){
            player2DropDown.setPromptText("Vælg spiller");
            player2DropDown.getItems().clear();
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                player2DropDown.getItems().add(playerHandler.getPlayers()[i].getName());
            }
            playerName2.setText("");
            playerMoney2.setText("");
            cardHolder2.getChildren().clear();
            properties2.getChildren().clear();
            tradeProps2.getChildren().clear();
        } else if(player2DropDown.getValue() != null && !player2DropDown.getValue().equals("")) {
            for(int i = 0; i < playerHandler.getPlayers().length; i++){
                if(playerHandler.getPlayers()[i].getName().equals(player2DropDown.getValue().toString())){
                    player2 = playerHandler.getPlayers()[i];
                }
            }
            showPlayerInfo(1);
        }
        System.out.println(player1DropDown.getValue().toString());
        System.out.println(player2DropDown.getValue().toString());
        if(!player1DropDown.getValue().equals("") && !player2DropDown.getValue().equals("")){
            if(!player1DropDown.getValue().toString().equals(player2DropDown.getValue().toString())){
                canTrade = true;
            }
            else{
                sendText("Du kan ikke bytte med dig selv");
                canTrade = false;
            }
        }
    }
    private void showPlayerInfo(int player){
        if(player == 0){
            playerName1.setText(player1.getName());
            playerMoney1.setText(numbersToString(player1.getMoney()));
            cards(player1, properties1, 0);
        }
        else{
            playerName2.setText(player2.getName());
            playerMoney2.setText(numbersToString(player2.getMoney()));
            cards(player2, properties2, 1);
        }
    }
    private void cards(Player player, FlowPane properties, int area){
        properties.getChildren().clear();
        ArrayList<Field> propertyFields = player.getProperties();
        ArrayList<Field> ferryFields = player.getFerries();
        ArrayList<Field> breweryFields = player.getBreweries();
        for(int i = 1; i <= 10; i++){
            if(i < 9){
                StackPane family = new StackPane();
                for(int n = 0; n < propertyFields.size(); n++){
                    if(((FieldProperty)propertyFields.get(n)).getProperty().getFamilie() == i){
                        Button button = new Button();
                        button.setText("");
                        button.setStyle("-fx-background-radius: 4; -fx-border-radius: 3; -fx-border-color: #404040");
                        setColorOf(button, i);
                        int temp = n;
                        button.setOnAction(e -> showCard(area ,(propertyFields.get(temp)), true));
                        button.setOnMouseEntered(e -> lineOn(button));
                        button.setOnMouseEntered(e -> lineOff(button));
                        family.getChildren().add(button);
                        button.setTranslateX((family.getChildren().size()-1)*4);
                        button.setTranslateY((family.getChildren().size()-1)*8);
                    }
                }
                if(family.getChildren().size() > 0){
                    properties.getChildren().add(family);
                }
            }
            else if(i == 9){
                StackPane family = new StackPane();
                for(int n = 0; n < ferryFields.size(); n++){
                    if(((FerryField)ferryFields.get(n)).getFerry().getFamilie() == i){
                        Button button = new Button();
                        button.setText("");
                        button.setStyle("-fx-background-radius: 4; -fx-border-radius: 3; -fx-border-color: #404040");
                        setColorOf(button, i);
                        int temp = n;
                        button.setOnAction(e -> showCard(area ,(ferryFields.get(temp)), true));
                        button.setOnMouseEntered(e -> lineOn(button));
                        button.setOnMouseEntered(e -> lineOff(button));
                        family.getChildren().add(button);
                        button.setTranslateX((family.getChildren().size()-1)*4);
                        button.setTranslateY((family.getChildren().size()-1)*8);
                    }
                }
                if(family.getChildren().size() > 0){
                    properties.getChildren().add(family);
                }
            }
            else if(i == 10){
                StackPane family = new StackPane();
                for(int n = 0; n < breweryFields.size(); n++){
                    if(((BreweryField)breweryFields.get(n)).getBrewery().getFamily() == i){
                        Button button = new Button();
                        button.setText("");
                        button.setStyle("-fx-background-radius: 4; -fx-border-radius: 3; -fx-border-color: #404040");
                        setColorOf(button, i);
                        int temp = n;
                        button.setOnAction(e -> showCard(area ,(breweryFields.get(temp)), true));
                        button.setOnMouseEntered(e -> lineOn(button));
                        button.setOnMouseEntered(e -> lineOff(button));
                        family.getChildren().add(button);
                        button.setTranslateX((family.getChildren().size()-1)*4);
                        button.setTranslateY((family.getChildren().size()-1)*8);
                    }
                }
                if(family.getChildren().size() > 0){
                    properties.getChildren().add(family);
                }
            }
        }


    }
    public void showCard(int area, Field field, boolean showTradeButton){
        String name = "";
        int family = 0;
        Image image = image("src/textures/houseNulIcon.png");

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

            if(showTradeButton){
                add1.setOpacity(1);
                add1.setDisable(false);
                add1.setText("Byt kort");
                add1.setOnAction(e -> addCardToTrade(field, area));
            }
            else{
                add1.setOpacity(1);
                add1.setDisable(false);
                add1.setText("Fjern");
                add1.setOnAction(e -> removeCardFromTrade(field, area));
            }
        }
        else if(area == 1){
            cardHolder2.getChildren().clear();
            cardHolder2.getChildren().add(card2);
            name2.setText(name);
            setColorOf(color2, family);
            image2.setImage(image);
            if(showTradeButton){
                add2.setOpacity(1);
                add2.setDisable(false);
                add2.setText("Byt kort");
                add2.setOnAction(e -> addCardToTrade(field, area));
            }
            else{
                add2.setOpacity(1);
                add2.setDisable(false);
                add2.setText("Fjern");
                add2.setOnAction(e -> removeCardFromTrade(field, area));
            }
        }
    }
    private void removeCardFromTrade(Field field, int area){
        if(area == 0){
            for(int i = 0; i < addedToTrade1.size(); i++){
                if(field == addedToTrade1.get(i)){
                    addedToTrade1.remove(i);
                    sendText("Fjernede kort fra byttehandel");
                    tradeProps1.getChildren().remove(i);
                    cardHolder1.getChildren().clear();
                }
            }
        }
        else if(area == 1){
            for(int i = 0; i < addedToTrade2.size(); i++){
                if(field == addedToTrade2.get(i)){
                    addedToTrade2.remove(i);
                    sendText("Fjernede kort fra byttehandel");
                    tradeProps2.getChildren().remove(i);
                    cardHolder2.getChildren().clear();
                }
            }
        }



    }
    private void addCardToTrade(Field field, int playerNumber){
        boolean canAddCard = true;
        switch (field.type()){
            case "buyablefield":
                if(((FieldProperty)field).getBuildings() > 0){
                    canAddCard = false;
                    sendText("Denne grund har bygninger på og kan derfor ikke byttes");
                    break;
                }
                if(((FieldProperty)field).isPledgeState()){
                    canAddCard = false;
                    sendText("Denne grund er pantsat og kan derfor ikke byttes");
                    break;
                }
                break;
            case "ferry":
                if(((FerryField)field).isPledgeState()){
                    canAddCard = false;
                    sendText("Denne grund er pantsat og kan derfor ikke byttes");
                    break;
                }
                break;
            case "brewery":
                if(((BreweryField)field).isPledgeState()){
                    canAddCard = false;
                    sendText("Denne grund er pantsat og kan derfor ikke byttes");
                    break;
                }
                break;
        }
        if(canAddCard){
            if(!addedToTrade1.contains(field) && !addedToTrade2.contains(field)){
                Player player;
                if(playerNumber == 0)  player = player1;
                else if(playerNumber == 1) player = player2;

                Button button = new Button();
                button.setText("");
                button.setStyle("-fx-background-radius: 4; -fx-border-radius: 3; -fx-border-color: #404040");
                String name = "";
                switch (field.type()){
                    case "buyablefield":
                        setColorOf(button, ((FieldProperty)field).getProperty().getFamilie());
                        name = ((FieldProperty)field).getProperty().getName();
                        break;
                    case "ferry":
                        setColorOf(button, ((FerryField)field).getFerry().getFamilie());
                        name = ((FerryField)field).getFerry().getName();

                        break;
                    case "brewery":
                        setColorOf(button, ((BreweryField)field).getBrewery().getFamily());
                        name = ((BreweryField)field).getBrewery().getName();

                        break;
                } //set color of button

                button.setOnAction(e -> showCard(playerNumber , field, false));
                button.setOnMouseEntered(e -> lineOn(button));
                button.setOnMouseEntered(e -> lineOff(button));
                if(playerNumber == 0){
                    tradeProps1.getChildren().add(button);
                    cardHolder1.getChildren().clear();
                    addedToTrade1.add(field);
                }
                else if(playerNumber == 1){
                    tradeProps2.getChildren().add(button);
                    cardHolder2.getChildren().clear();
                    addedToTrade2.add(field);
                }

                sendText("Tilføjede " + name + " til byttehandel");

            }
            else{
                sendText("Du har allerede indsat dette kort.");
            }
        }
    }
    public void moneyConvert(int player){
        if(player == 0 && !moneyInput1.getText().equals("")){
            double value = parseDouble(moneyInput1.getText());
            if(value < 0) value *= -1;
            moneyInput1.setText(Math.round(value/50)*50 + "");
        }
        else if(player == 1 && !moneyInput2.getText().equals("")){
            double value = parseDouble(moneyInput2.getText());
            if(value < 0) value *= -1;
            moneyInput2.setText(Math.round(value/50)*50 + "");
        }
    }
    public void makeTrade(){
        System.out.println("can trade: " + canTrade);
        if(canTrade){
            if(moneyInput1.getText().equals("")){
                moneyInput1.setText("0");
            }
            if(player1.getMoney() > parseInt(moneyInput1.getText()) && !moneyInput1.getText().equals("")){
                System.out.println("player 1 okay");
                if(moneyInput2.getText().equals("")){
                    moneyInput2.setText("0");
                }
                if(player2.getMoney() > parseInt(moneyInput2.getText()) && !moneyInput2.getText().equals("")){
                    System.out.println("player 2 okay");
                    for(int i = 0; i < addedToTrade1.size(); i++){
                        ControllerHandler.getInstance().getPlayerViewController().removeCard(addedToTrade1.get(i));
                        switch (addedToTrade1.get(i).type()){
                            case "buyablefield":
                                playerHandler.changePlayerBalance(player2, ((FieldProperty)addedToTrade1.get(i)).getProperty().getPrice());
                                ControllerHandler.getInstance().getBoardController().buyPropertyTrade(((FieldProperty)addedToTrade1.get(i)), player2);
                                break;
                            case "ferry":
                                playerHandler.changePlayerBalance(player2, ((FerryField)addedToTrade1.get(i)).getFerry().getPrice());
                                ControllerHandler.getInstance().getBoardController().buyFerryTrade(((FerryField)addedToTrade1.get(i)), player2);
                                break;
                            case "brewery":
                                playerHandler.changePlayerBalance(player2, ((BreweryField)addedToTrade1.get(i)).getBrewery().getPrice());
                                ControllerHandler.getInstance().getBoardController().buyBreweryTrade(((BreweryField)addedToTrade1.get(i)), player2);
                                break;
                        }
                    }
                    for(int i = 0; i < addedToTrade2.size(); i++){
                        ControllerHandler.getInstance().getPlayerViewController().removeCard(addedToTrade2.get(i));
                        switch (addedToTrade2.get(i).type()){
                            case "buyablefield":
                                playerHandler.changePlayerBalance(player1, ((FieldProperty)addedToTrade2.get(i)).getProperty().getPrice()); //remove
                                ControllerHandler.getInstance().getBoardController().buyPropertyTrade(((FieldProperty)addedToTrade2.get(i)), player1);
                                break;
                            case "ferry":
                                playerHandler.changePlayerBalance(player1, ((FerryField)addedToTrade2.get(i)).getFerry().getPrice()); //remove
                                ControllerHandler.getInstance().getBoardController().buyFerryTrade(((FerryField)addedToTrade2.get(i)), player1);
                                break;
                            case "brewery":
                                playerHandler.changePlayerBalance(player1, ((BreweryField)addedToTrade2.get(i)).getBrewery().getPrice()); //remove
                                ControllerHandler.getInstance().getBoardController().buyBreweryTrade(((BreweryField)addedToTrade2.get(i)), player1);
                                break;
                        }
                    }
                    playerHandler.changePlayerBalance(player1, -parseInt(moneyInput1.getText())); //remove
                    playerHandler.changePlayerBalance(player1, parseInt(moneyInput2.getText())); //add
                    playerHandler.changePlayerBalance(player2, -parseInt(moneyInput2.getText())); //remove
                    playerHandler.changePlayerBalance(player2, parseInt(moneyInput1.getText())); //add
                    ControllerHandler.getInstance().getPlayerViewController().updatePlayerMoney();
                    addedToTrade1.clear();
                    addedToTrade2.clear();
                    onSwitched();
                    sendText("Byttehandel fuldført");

                }
                else sendText(player2.getName() + " har ikke råd til denne handel");
            }
            else sendText(player1.getName() + " har ikke råd til denne handel");
        }
    }
    public void closeMenu(){
        ControllerHandler.getInstance().getSceneSwitch().showChanceCardPileInMiddle();
    }
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
                node.setStyle(node.getStyle() + ";-fx-background-color: #0000ff;");
                break;
            case 1: //Orange
                node.setStyle(node.getStyle() + ";-fx-background-color: #FFA500;");
                break;
            case 2: //Green
                node.setStyle(node.getStyle() + ";-fx-background-color:  #32cd32;");
                break;
            case 3: //Grey
                node.setStyle(node.getStyle() + ";-fx-background-color:  #aaaaaa;");
                break;
            case 4: //Red
                node.setStyle(node.getStyle() + ";-fx-background-color: #ff0000;");
                break;
            case 5: //White
                node.setStyle(node.getStyle() + ";-fx-background-color: #ffffff;");
                break;
            case 6: //Yellow
                node.setStyle(node.getStyle() + ";-fx-background-color: #FFFF00;");
                break;
            case 7: //Purple
                node.setStyle(node.getStyle() + ";-fx-background-color:  #BF40BF;");
                break;
            case 8: //Ferry
                node.setStyle(node.getStyle() + ";-fx-background-color:   #00ffff;");
                break;
            case 9: //Soda
                node.setStyle(node.getStyle() + ";-fx-background-color:   #FF69B4;");
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
    private void lineOn(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #ffffff;");
    }
    private void lineOff(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #404040;");
    }

    //region methods
}
