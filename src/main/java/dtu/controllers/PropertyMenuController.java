package dtu.controllers;

import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.players.PlayerHandler;
import javafx.css.Style;
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
import java.util.ArrayList;

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
    Text pant1;

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
    Text pant2;

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
    @FXML
    Text pant3;
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
    Text[] pledgeValue;
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
        pledgeValue = new Text[3];
        pledgeValue[0] = pant1;
        pledgeValue[1] = pant2;
        pledgeValue[2] = pant3;
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
        ferryImage1.setImage(image("src/textures/ferry_card.png"));
        ferryImage2.setImage(image("src/textures/ferry_card.png"));
        ferryImage3.setImage(image("src/textures/ferry_card.png"));
        ferryImage4.setImage(image("src/textures/ferry_card.png"));
        sodaImage1.setImage(image("src/textures/colaflaske.png"));
        sodaImage1.setImage(image("src/textures/squash_card.png"));
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
        parent.getChildren().clear();
        hideButtons();
        for(int i = 0; i < properties.length; i++){
            FieldProperty fieldProperty = (FieldProperty)properties[i];
            parent.getChildren().add(cards[i]);
            names[i].setText(fieldProperty.getProperty().getName());
            normalRent[i].setText(numbersToString(fieldProperty.getProperty().getRentNormal()));
            house1Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent1House()));
            house2Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent2House()));
            house3Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent3House()));
            house4Rent[i].setText(numbersToString(fieldProperty.getProperty().getRent4House()));
            housePrice[i].setText(numbersToString(fieldProperty.getProperty().getHousePrice()));
            pledgeValue[i].setText(numbersToString(fieldProperty.getProperty().getPledge()));
            setColorOf(colors[i], fieldProperty.getProperty().getFamilie());
            setHouseIcon(i, fieldProperty.getBuildings());
            if(checkForHasAllOfFamily(fieldProperty, player)){
                if(player != -1){
                    if(fieldProperty.getBuildings()<5){
                        plusStackPanes[i].setOpacity(1);
                        plusButtons[i].setDisable(false);
                        int index = i;
                        plusButtons[i].setOnAction(e -> buildOrRemoveHouse(fieldProperty, 1, player, properties));
                    }
                    if(fieldProperty.getBuildings()>0){
                        minusStackPanes[i].setOpacity(1);
                        minusButtons[i].setDisable(false);
                        int index = i;
                        minusButtons[i].setOnAction(e -> buildOrRemoveHouse(fieldProperty, -1, player, properties));
                    }
                }
            }

            if(fieldProperty.isPledgeState())pledgeValueIcons[i].setOpacity(84);
            else pledgeValueIcons[i].setOpacity(0);
        }
    }
    public boolean checkForHasAllOfFamily(FieldProperty property, int player){
        if(playerHandler == null) playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
        ArrayList<Field> playerProperties = playerHandler.getPlayers()[player].getProperties();
        Field[] allProperties = ControllerHandler.getInstance().getBoard().getCurrentBoard();
        switch (property.getProperty().getFamilie()){
            case 1: //Blå (de starter fra 1)
                if(playerProperties.contains(allProperties[1]) && playerProperties.contains(allProperties[3])){
                    return true;
                }
                else return false;
            case 2:
                if(playerProperties.contains(allProperties[6]) && playerProperties.contains(allProperties[8]) && playerProperties.contains(allProperties[9])){
                    return true;
                }
                else return false;
            case 3:
                if(playerProperties.contains(allProperties[11]) && playerProperties.contains(allProperties[13]) && playerProperties.contains(allProperties[14])){
                    return true;
                }
                else return false;
            case 4:
                if(playerProperties.contains(allProperties[16]) && playerProperties.contains(allProperties[18]) && playerProperties.contains(allProperties[19])){
                    return true;
                }
                else return false;
            case 5:
                if(playerProperties.contains(allProperties[21]) && playerProperties.contains(allProperties[23]) && playerProperties.contains(allProperties[24])){
                    return true;
                }
                else return false;
            case 6:
                if(playerProperties.contains(allProperties[26]) && playerProperties.contains(allProperties[27]) && playerProperties.contains(allProperties[29])){
                    return true;
                }
                else return false;
            case 7:
                if(playerProperties.contains(allProperties[31]) && playerProperties.contains(allProperties[32]) && playerProperties.contains(allProperties[34])){
                    return true;
                }
                else return false;
            case 8:
                if(playerProperties.contains(allProperties[37]) && playerProperties.contains(allProperties[39])){
                    return true;
                }
                else return false;
            default:
                System.out.println("Family of building does not exists (0 is ignored, starts at 1)");
                return false;
        }
    }
    private void buildOrRemoveHouse(FieldProperty property, int amountOfHouses, int player, Field[] initialProperties){
        property.setBuildings(property.getBuildings()+amountOfHouses);
        showProperties(initialProperties, player);
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

}
