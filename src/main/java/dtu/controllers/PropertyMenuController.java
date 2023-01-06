package dtu.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    VBox color1;
    @FXML
    VBox color2;
    @FXML
    VBox color3;
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

    ImageView[] cardImages;
    Image[] houseIcons;
    Text[] names;

    //Methods
    //---------------------------------------------------

    @FXML
    public void initialize(){
        names = new Text[9];
        names[0] = propertyName1;
        names[1] = propertyName2;
        names[2] = propertyName3;
        names[3] = ferryName1;
        names[4] = ferryName2;
        names[5] = ferryName3;
        names[6] = ferryName4;
        names[7] = sodaName1;
        names[8] = sodaName2;

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
        sodaImage1.setImage(image("src/textures/cola_card.png"));
        sodaImage1.setImage(image("src/textures/squash_card.png"));
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
