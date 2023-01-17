package dtu.controllers;

import dtu.board.*;
import dtu.players.PlayerHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class PropertyMenuController {

    //region cardImages
    @FXML
    ImageView sodaImage1;
    @FXML
    ImageView sodaImage2;
    @FXML
    ImageView ferryImage1;
    @FXML
    ImageView ferryImage2;
    @FXML
    ImageView ferryImage3;
    @FXML
    ImageView ferryImage4;
    @FXML
    ImageView propertyImage1;
    @FXML
    ImageView propertyImage2;
    @FXML
    ImageView propertyImage3;

    //endregion
    //region cardVBoxes
    @FXML
    VBox property1;
    @FXML
    VBox property2;
    @FXML
    VBox property3;
    @FXML
    VBox soda1;
    @FXML
    VBox soda2;
    @FXML
    VBox ferry1;
    @FXML
    VBox ferry2;
    @FXML
    VBox ferry3;
    @FXML
    VBox ferry4;
    //endregion
    //region names
    @FXML
    Text propertyName1;
    @FXML
    Text propertyName2;
    @FXML
    Text propertyName3;
    @FXML
    Text ferryName1;
    @FXML
    Text ferryName2;
    @FXML
    Text ferryName3;
    @FXML
    Text ferryName4;
    @FXML
    Text sodaName1;
    @FXML
    Text sodaName2;
    //endregion
    //region VBoxes for background colours for property cards
    @FXML
    HBox color1;
    @FXML
    HBox color2;
    @FXML
    HBox color3;
    //endregion
    //region info Text som leje for property cards sammen med huse og pantsætningsværdi
    @FXML
    Text leje1;
    @FXML
    Text hus11;
    @FXML
    Text hus21;
    @FXML
    Text hus31;
    @FXML
    Text hus41;
    @FXML
    Text hotel1;
    @FXML
    Text husPris1;

    @FXML
    Text leje2;
    @FXML
    Text hus12;
    @FXML
    Text hus22;
    @FXML
    Text hus32;
    @FXML
    Text hus42;
    @FXML
    Text hotel2;
    @FXML
    Text husPris2;

    @FXML
    Text leje3;
    @FXML
    Text hus13;
    @FXML
    Text hus23;
    @FXML
    Text hus33;
    @FXML
    Text hus43;
    @FXML
    Text hotel3;
    @FXML
    Text husPris3;
    //endregion
    //region pantsætning

    @FXML
    VBox pansatProp1;
    @FXML
    VBox pansatProp2;
    @FXML
    VBox pansatProp3;
    @FXML
    VBox pansatFerry1;
    @FXML
    VBox pansatFerry2;
    @FXML
    VBox pansatFerry3;
    @FXML
    VBox pansatFerry4;
    @FXML
    VBox pansatSoda1;
    @FXML
    VBox pansatSoda2;
    @FXML
    Button pledgeButtonProp1;
    @FXML
    Button pledgeButtonProp2;
    @FXML
    Button pledgeButtonProp3;
    @FXML
    Button pledgeButtonFerry1;
    @FXML
    Button pledgeButtonFerry2;
    @FXML
    Button pledgeButtonFerry3;
    @FXML
    Button pledgeButtonFerry4;
    @FXML
    Button pledgeButtonSoda1;
    @FXML
    Button pledgeButtonSoda2;


    //endregion
    //region plus and minus for housebuilding
    @FXML
    Button minusButton1;
    @FXML
    Button minusButton2;
    @FXML
    Button minusButton3;
    @FXML
    Button plusButton1;
    @FXML
    Button plusButton2;
    @FXML
    Button plusButton3;
    @FXML
    StackPane plus1;
    @FXML
    StackPane plus2;
    @FXML
    StackPane plus3;
    @FXML
    StackPane minus1;
    @FXML
    StackPane minus2;
    @FXML
    StackPane minus3;
    StackPane[] minusStackPanes = new StackPane[3];
    StackPane[] plusStackPanes = new StackPane[3];
    Button[] minusButtons = new Button[3];
    Button[] plusButtons = new Button[3];
    //endregion

    @FXML
    HBox parent;



    ImageView[] cardImages;
    Image[] houseIcons;
    Text[] names;
    Text[] normalRent;
    Text[] house1Rent;
    Text[] house2Rent;
    Text[] house3Rent;
    Text[] house4Rent;
    Text[] hotelRent;
    Text[] housePrice;
    Button[] pledgeButtons;
    HBox[] colors;
    VBox[] pledgeValueIcons;
    VBox[] cards;
    PlayerHandler playerHandler;

    //Methods
    //---------------------------------------------------

    @FXML
    public void initialize(){
        initPics();
        initTextFields();
        initPledgeValueSigns();
        initCards();
        initButtons();
        parent.getChildren().clear();
        parent.getChildren().add(property1);
    }
    private void initButtons(){
        pledgeButtons = new Button[9];
        pledgeButtons[0] = pledgeButtonProp1;
        pledgeButtons[1] = pledgeButtonProp2;
        pledgeButtons[2] = pledgeButtonProp3;
        pledgeButtons[3] = pledgeButtonFerry1;
        pledgeButtons[4] = pledgeButtonFerry2;
        pledgeButtons[5] = pledgeButtonFerry3;
        pledgeButtons[6] = pledgeButtonFerry4;
        pledgeButtons[7] = pledgeButtonSoda1;
        pledgeButtons[8] = pledgeButtonSoda2;
        for(int i = 0; i < pledgeButtons.length; i++){
            int temp = i;
            lineOn(pledgeButtons[temp]);
            pledgeButtons[i].setOnMouseEntered(e -> lineOff(pledgeButtons[temp]));
            pledgeButtons[i].setOnMouseExited(e -> lineOn(pledgeButtons[temp]));

        }
        minusButtons[0] = minusButton1;
        minusButtons[1] = minusButton2;
        minusButtons[2] = minusButton3;
        plusButtons[0] = plusButton1;
        plusButtons[1] = plusButton2;
        plusButtons[2] = plusButton3;
        minusStackPanes[0] = minus1;
        minusStackPanes[1] = minus2;
        minusStackPanes[2] = minus3;
        plusStackPanes[0] = plus1;
        plusStackPanes[1] = plus2;
        plusStackPanes[2] = plus3;
        hideButtons();
    }
    private void initCards(){
        cards = new VBox[9];
        cards[0] = property1;
        cards[1] = property2;
        cards[2] = property3;
        cards[3] = ferry1;
        cards[4] = ferry2;
        cards[5] = ferry3;
        cards[6] = ferry4;
        cards[7] = soda1;
        cards[8] = soda2;
    }
    private void initPledgeValueSigns(){
        pledgeValueIcons = new VBox[9];
        pledgeValueIcons[0] = pansatProp1;
        pledgeValueIcons[1] = pansatProp2;
        pledgeValueIcons[2] = pansatProp3;
        pledgeValueIcons[3] = pansatFerry1;
        pledgeValueIcons[4] = pansatFerry2;
        pledgeValueIcons[5] = pansatFerry3;
        pledgeValueIcons[6] = pansatFerry4;
        pledgeValueIcons[7] = pansatSoda1;
        pledgeValueIcons[8] = pansatSoda2;
        for(int i = 0; i < pledgeValueIcons.length; i++){
            setPledgeValueSign(false,i);
        }
    }
    private void initTextFields(){
        names = new Text[12];
        names[0] = propertyName1;
        names[1] = propertyName2;
        names[2] = propertyName3;
        names[3] = ferryName1;
        names[4] = ferryName2;
        names[5] = ferryName3;
        names[6] = ferryName4;
        names[7] = sodaName1;
        names[8] = sodaName2;
        normalRent = new Text[3];
        normalRent[0] = leje1;
        normalRent[1] = leje2;
        normalRent[2] = leje3;
        house1Rent = new Text[3];
        house1Rent[0] = hus11;
        house1Rent[1] = hus12;
        house1Rent[2] = hus13;
        house2Rent = new Text[3];
        house2Rent[0] = hus21;
        house2Rent[1] = hus22;
        house2Rent[2] = hus23;
        house3Rent = new Text[3];
        house3Rent[0] = hus31;
        house3Rent[1] = hus32;
        house3Rent[2] = hus33;
        house4Rent = new Text[3];
        house4Rent[0] = hus41;
        house4Rent[1] = hus42;
        house4Rent[2] = hus43;
        hotelRent = new Text[3];
        hotelRent[0] = hotel1;
        hotelRent[1] = hotel2;
        hotelRent[2] = hotel3;
        housePrice = new Text[3];
        housePrice[0] = husPris1;
        housePrice[1] = husPris2;
        housePrice[2] = husPris3;
        colors = new HBox[3];
        colors[0] = color1;
        colors[1] = color2;
        colors[2] = color3;
    }
    private void initPics(){
        cardImages = new ImageView[9];
        cardImages[0] = propertyImage1;
        cardImages[1] = propertyImage2;
        cardImages[2] = propertyImage3;
        houseIcons = new Image[6];
        houseIcons[0] = image("src/textures/houseNulIcon.png");
        houseIcons[1] = image("src/textures/house1Icon.png");
        houseIcons[2] = image("src/textures/house2Icon.png");
        houseIcons[3] = image("src/textures/house3Icon.png");
        houseIcons[4] = image("src/textures/house4Icon.png");
        houseIcons[5] = image("src/textures/hotelIcon.png");
        propertyImage1.setImage(houseIcons[0]);
        propertyImage2.setImage(houseIcons[0]);
        propertyImage3.setImage(houseIcons[0]);
        cardImages[3] = ferryImage1;
        cardImages[4] = ferryImage2;
        cardImages[5] = ferryImage3;
        cardImages[6] = ferryImage4;
        cardImages[7] = sodaImage1;
        cardImages[8] = sodaImage2;
        cardImages[3].setImage(image("src/textures/ferry_card.png"));
        cardImages[4].setImage(image("src/textures/ferry_card.png"));
        cardImages[5].setImage(image("src/textures/ferry_card.png"));
        cardImages[6].setImage(image("src/textures/ferry_card.png"));
        cardImages[7].setImage(image("src/textures/squash_card.png"));
        cardImages[8].setImage(image("src/textures/colaflaske.png"));
    }

    private void setPledgeValueSign(boolean isPledgeValue, int spot){
        if(isPledgeValue) pledgeValueIcons[spot].setOpacity(0.84);
        else pledgeValueIcons[spot].setOpacity(0);
    }
    private void hideButtons(){
        for(int i = 0; i < 3; i++){
            minusStackPanes[i].setOpacity(0);
            plusStackPanes[i].setOpacity(0);
            minusButtons[i].setDisable(true);
            plusButtons[i].setDisable(true);
        }
    }
    public void showProperties(Field[] properties, int player){
        if(playerHandler == null) playerHandler = ControllerHandler.getInstance().getBoardController().playerHandler;
        parent.getChildren().clear();
        hideButtons();
        Field field;
        field = properties[0];
        String type = field.type();
        if(type.equals("buyablefield")){
            HousingLogic houseLogic = ControllerHandler.getInstance().getHousingLogic();
            for(int i = 0; i < properties.length; i++){
                FieldProperty fieldProperty = (FieldProperty)properties[i];
                parent.getChildren().add(cards[i]);
                names[i].setText(fieldProperty.getProperty().getName());
                normalRent[i].setText(numbersToString(fieldProperty.getProperty().getRentNormal()));
                house1Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent1House()));
                house2Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent2House()));
                house3Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent3House()));
                house4Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent4House()));
                hotelRent[i].setText(numbersToString(fieldProperty.getProperty().getRentHotel()));
                housePrice[i].setText(numbersToString(fieldProperty.getProperty().getHousePrice()));
                setPledgeValueSign(fieldProperty.isPledgeState(), i);
                setColorOf(colors[i], fieldProperty.getProperty().getFamilie());
                setHouseIcon(i, fieldProperty.getBuildings());
                if(player != -1){
                    pledgeButtons[i].setDisable(false);
                    pledgeButtons[i].setOpacity(1);
                    if(fieldProperty.isPledgeState()) {
                        pledgeButtons[i].setText("Åben for: " + numbersToString(fieldProperty.getProperty().getPrice()/2 + playerHandler.nonPledgeTax(fieldProperty.getProperty().getPrice()/2)));
                    }
                    else {
                        pledgeButtons[i].setText("Pantsæt og få: " + numbersToString(fieldProperty.getProperty().getPrice()/2));
                    }
                    pledgeButtons[i].setOnAction(e -> doPledge(fieldProperty, !fieldProperty.isPledgeState(), player, properties));

                    if(houseLogic.checkForHasAllOfFamily(fieldProperty, player)){
                        if(houseLogic.canBuild(fieldProperty, player) && houseLogic.familyIsPledge(fieldProperty, player)){
                            if(fieldProperty.getBuildings()<5){
                                plusStackPanes[i].setOpacity(1);
                                plusButtons[i].setDisable(false);
                                int index = i;
                                plusButtons[i].setOnAction(e -> buildOrRemoveHouse(fieldProperty, 1, player, properties));
                            }
                        }
                        if(houseLogic.canRemove(fieldProperty, player)){
                            if(fieldProperty.getBuildings()>0){
                                minusStackPanes[i].setOpacity(1);
                                minusButtons[i].setDisable(false);
                                int index = i;
                                minusButtons[i].setOnAction(e -> buildOrRemoveHouse(fieldProperty, -1, player, properties));
                            }
                        }
                    }
                }
                else{
                    pledgeButtons[i].setDisable(true);
                    pledgeButtons[i].setOpacity(0);
                }

                if(fieldProperty.isPledgeState())pledgeValueIcons[i].setOpacity(84);
                else pledgeValueIcons[i].setOpacity(0);
            }
        }
        if(type.equals("ferry")){
            for(int i = 0; i < properties.length; i++) {
                FerryField ferry = (FerryField) properties[i];
                parent.getChildren().add(cards[i+3]);
                System.out.println(i);
                names[i+3].setText(ferry.getFerry().getName());
                setPledgeValueSign(ferry.isPledgeState(), i+3);
                if(player != -1) {
                    if (ferry.isPledgeState()) {
                        pledgeButtons[i+3].setText("Åben for: " + numbersToString(ferry.getFerry().getPrice()/2 + playerHandler.nonPledgeTax(ferry.getFerry().getPrice()/2)));
                    } else {
                        pledgeButtons[i+3].setText("Pantsæt og få: " + numbersToString(ferry.getFerry().getPrice()/2));
                    }
                    pledgeButtons[i+3].setOnAction(e -> doPledge(ferry, !ferry.isPledgeState(), player, properties));
                }
            }
        }
        if(type.equals("brewery")){
            for(int i = 0; i < properties.length; i++) {
                BreweryField breweryField = (BreweryField) properties[i];
                parent.getChildren().add(cards[i+7]);
                setPledgeValueSign(breweryField.isPledgeState(), i+7);
                if(breweryField.getBrewery().getName().equals("Coca Cola")){

                    cardImages[i+7].setImage(image("src/textures/colaflaske.png"));
                }
                else{
                    cardImages[i+7].setImage(image("src/textures/squash_card.png"));
                }
                names[i+7].setText(breweryField.getBrewery().getName());
                if(player != -1) {
                    if (breweryField.isPledgeState()) {
                        pledgeButtons[i+7].setText("Åben for: " + numbersToString(breweryField.getBrewery().getPrice()/2 + playerHandler.nonPledgeTax(breweryField.getBrewery().getPrice()/2)));
                    } else {
                        pledgeButtons[i+7].setText("Pantsæt og få: " + numbersToString(breweryField.getBrewery().getPrice()/2));
                    }
                    pledgeButtons[i+7].setOnAction(e -> doPledge(breweryField, !breweryField.isPledgeState(), player, properties));
                }
            }
        }
        //working
    }

    private void buildOrRemoveHouse(FieldProperty property, int amountOfHouses, int player, Field[] initialProperties){
        if(playerHandler == null) playerHandler = ControllerHandler.getInstance().getBoardController().playerHandler;
        if(amountOfHouses<0){ //Sells a house
            playerHandler.changePlayerBalance(playerHandler.getPlayers()[player], property.getProperty().getHousePrice()/2);
            property.setBuildings(property.getBuildings() + amountOfHouses);
            showProperties(initialProperties, player);
            ControllerHandler.getInstance().getBoardController().setHousesOn(property.getBuildings(), property.getProperty().getID());
        } //checks if they can buy a house
        else if(ControllerHandler.getInstance().getHousingLogic().canAfford(property, player)) {
            property.setBuildings(property.getBuildings() + amountOfHouses);
            showProperties(initialProperties, player);
            ControllerHandler.getInstance().getBoardController().setHousesOn(property.getBuildings(), property.getProperty().getID());
            playerHandler.changePlayerBalance(playerHandler.getPlayers()[player], -property.getProperty().getHousePrice());
        } //Cannot afford to buy the house
        else{
            System.out.println(playerHandler.getPlayers()[player].getName() + " cannot afford to build on this property");
        }
        ControllerHandler.getInstance().getPlayerViewController().updatePlayerMoney();

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
    private void setColorOf(Node node, int family){
        switch (family-1){
            case 0: //Blue
                node.setStyle(node.getStyle() + "-fx-background-color: #0000ff;");
                break;
            case 1: //Orange
                node.setStyle(node.getStyle() +"-fx-background-color: #FFA500;");
                break;
            case 2: //Green
                node.setStyle(node.getStyle() +"-fx-background-color:  #32cd32;");
                break;
            case 3: //Grey
                node.setStyle(node.getStyle() +"-fx-background-color:  #aaaaaa;");
                break;
            case 4: //Red
                node.setStyle(node.getStyle() +"-fx-background-color: #ff0000;");
                break;
            case 5: //White
                node.setStyle(node.getStyle() +"-fx-background-color: #ffffff;");
                break;
            case 6: //Yellow
                node.setStyle(node.getStyle() +"-fx-background-color: #FFFF00;");
                break;
            case 7: //Purple
                node.setStyle(node.getStyle() +"-fx-background-color:  #BF40BF;");
                break;
            default:
                System.out.println("family is outside of known cases");
                break;
        }


    }
    private void setHouseIcon(int card, int amount){
        cardImages[card].setImage(houseIcons[amount]);
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

    //region pantsætning
    public void doPledge(Field property, boolean toState, int player, Field[] initialProperties){
        int moneyToChange = 0;
        CommunicationController coms = ControllerHandler.getInstance().getCommunicationController();
        HousingLogic housingLogic = new HousingLogic();
        switch(property.type()){
            case "buyablefield":

                if(toState){
                    //Resieve Money
                    if(((FieldProperty)property).getBuildings() > 0){
                        //Du kan ikke pantsætte da der er bygninger på grunden.
                        coms.showOkBox("Du kan ikke pantsætte da der er bygninger på grunden");
                    }
                    else if(housingLogic.doesFamilyHaveHouses((FieldProperty) property, player)){
                        //Du kan ikke pantsætte da der er bygninger på grunden.
                        coms.showOkBox("Du kan ikke pantsætte da der er bygninger på andre grunde af samme familie");
                    }
                    else{
                        moneyToChange = ((FieldProperty)property).getProperty().getPrice()/2;
                        ((FieldProperty)property).setPledgeState(true);
                        coms.showOkBox("Du pantsatte " + ((FieldProperty)property).getProperty().getName());
                    }
                }
                else{
                    //Use Money
                    moneyToChange = -((FieldProperty)property).getProperty().getPrice()/2;
                    moneyToChange -= playerHandler.nonPledgeTax(((FieldProperty)property).getProperty().getPrice()/2);
                    if(playerHandler.getPlayers()[player].getMoney() < -moneyToChange){
                        moneyToChange = 0;
                        //Du har ikke råd
                        coms.showOkBox("Du har ikke råd til at åbne " + ((FieldProperty)property).getProperty().getName());
                    }
                    else{
                        ((FieldProperty)property).setPledgeState(false); //du havde råd
                        coms.showOkBox("Du har åbnet " + ((FieldProperty)property).getProperty().getName());
                    }
                }
                break;
            case "ferry":

                if(toState){
                    //Resieve Money
                    moneyToChange = ((FerryField)property).getFerry().getPrice()/2;
                    ((FerryField)property).setPledgeState(true);
                    coms.showOkBox("Du pantsatte " + ((FerryField)property).getFerry().getName());

                }
                else{
                    //Use Money
                    moneyToChange = -((FerryField)property).getFerry().getPrice()/2;
                    moneyToChange -= playerHandler.nonPledgeTax(((FerryField)property).getFerry().getPrice()/2);
                    if(playerHandler.getPlayers()[player].getMoney() < -moneyToChange){
                        moneyToChange = 0;
                        //Du har ikke råd
                        coms.showOkBox("Du har ikke råd til at åbne " + ((FerryField)property).getFerry().getName());

                    }
                    else {
                        ((FerryField)property).setPledgeState(false); //du havde råd
                        coms.showOkBox("Du har åbnet " + ((FerryField)property).getFerry().getName());

                    }
                }
                break;
            case "brewery":

                if(toState){
                    //Resieve Money
                    moneyToChange = ((BreweryField)property).getBrewery().getPrice()/2;
                    ((BreweryField)property).setPledgeState(true);
                    coms.showOkBox("Du pantsatte " + ((BreweryField)property).getBrewery().getName());
                }
                else{
                    //Use Money
                    moneyToChange = -((BreweryField)property).getBrewery().getPrice()/2;
                    moneyToChange -= playerHandler.nonPledgeTax(((BreweryField)property).getBrewery().getPrice()/2);
                    if(playerHandler.getPlayers()[player].getMoney() < -moneyToChange){
                        moneyToChange = 0;
                        //Du har ikke råd
                        coms.showOkBox("Du har ikke råd til at åbne " + ((BreweryField)property).getBrewery().getName());

                    }
                    else {
                        ((BreweryField)property).setPledgeState(false); //du havde råd
                        coms.showOkBox("Du har åbnet " + ((BreweryField)property).getBrewery().getName());

                    }
                }
                break;
        }
        playerHandler.changePlayerBalance(playerHandler.getPlayers()[player], moneyToChange);
        ControllerHandler.getInstance().getPlayerViewController().updatePlayerMoney();
        showProperties(initialProperties, player);
    }
    private void lineOn(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #ffffff; -fx-border-radius: 3; -fx-background-radius: 4;");
    }
    private void lineOff(Node node){
        node.setStyle(node.getStyle() + ";-fx-border-color: #707070;-fx-border-radius: 3; -fx-background-radius: 4;");
    }
    //endregion

}
