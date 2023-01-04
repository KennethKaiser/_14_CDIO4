package dtu._14_cdio4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;

public class BoardController {

    public void instantiateBoard() {
        initHouses();
        startCars();
        initPics();
        System.out.println("Board Instantiated");
    }
    public void test(){
        System.out.println("Button Pressed");
    }


    //region pictures on board
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
    @FXML
    ImageView carBlack;
    @FXML
    ImageView carBlue;
    @FXML
    ImageView carOrange;
    @FXML
    ImageView carRed;
    @FXML
    ImageView carYellow;
    @FXML
    ImageView carGreen;

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
            carBlue.setImage(image("src/textures/blueCar.png"));
            carBlack.setImage(image("src/textures/blackCar.png"));
            carOrange.setImage(image("src/textures/orangeCar.png"));
            carYellow.setImage(image("src/textures/yellowCar.png"));
            carRed.setImage(image("src/textures/redCar.png"));
            carGreen.setImage(image("src/textures/greenCar.png"));

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
    //region names

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
    //region get out of jail free icon
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

    public boolean isGetOutOfJailFreeCard(int player){
        switch (player){
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


        switch (player){
            case 1:
                p1KeyIcon.setOpacity(toSet);
                break;
            case 2:
                p2KeyIcon.setOpacity(toSet);
                break;
            case 3:
                p3KeyIcon.setOpacity(toSet);
                break;
            case 4:
                p4KeyIcon.setOpacity(toSet);
                break;
            case 5:
                p5KeyIcon.setOpacity(toSet);
                break;
            case 6:
                p6KeyIcon.setOpacity(toSet);
                break;
            default:
                System.out.println("Error: could not find player with number {" + player + "} while trying to setGetOutOfJailFreeCard");
                break;
        }
    }
    //endregion
    //region is in jail icon
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

    public boolean isInJail(int player){
        switch (player-1){
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


        switch (player-1){
            case 1:
                p1JailIcon.setOpacity(toSet);
                break;
            case 2:
                p2JailIcon.setOpacity(toSet);
                break;
            case 3:
                p3JailIcon.setOpacity(toSet);
                break;
            case 4:
                p4JailIcon.setOpacity(toSet);
                break;
            case 5:
                p5JailIcon.setOpacity(toSet);
                break;
            case 6:
                p6JailIcon.setOpacity(toSet);
                break;
            default:
                System.out.println("Error: could not find player with number {" + player + "} while trying to setInJailIcon");
                break;
        }
    }
    //endregion
    //region money
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
    //region biler i stackpanes

    public void TestMove(){
        movePLayer(0, 39);
    }


    ImageView[] cars;
    private void setCars(){
        cars = new ImageView[6];
        cars[0] = carBlue;
        cars[1] = carGreen;
        cars[2] = carRed;
        cars[3] = carYellow;
        cars[4] = carOrange;
        cars[5] = carBlack;
    }

    public void carMoveOne(int player){
        if(cars == null) setCars();
        if(fields == null) initFields();
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getChildren().contains(cars[player])){
                fields[i].getChildren().remove(cars[player]);
                if(i == 39){
                    multipleCars(player, 0);
                    fields[0].getChildren().add(cars[player]);

                }
                else {
                    multipleCars(player, i+1);
                    fields[i+1].getChildren().add(cars[player]);
                }

            }
        }
    }
    public void carMoveOneBackwards(int player){
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getChildren().contains(cars[player])){
                fields[i].getChildren().remove(cars[player]);
                if(i == 0){
                    multipleCars(player, 39);
                    fields[1].getChildren().add(cars[player]);

                }
                else {
                    multipleCars(player, i-1);
                    fields[i+1].getChildren().add(cars[player]);
                }
                break;
            }
        }
    }
    public void movePLayer(int player, int amount){
        for(int i = amount; i > 0; i--){
            carMoveOne(player);
        }
    }
    public void movePLayerBackward(int player, int amount){
        for(int i = amount; i > 0; i--){
            carMoveOneBackwards(player);
        }
    }
    public void startCars(){
        if(cars == null) setCars();
        if(fields == null) initFields();

        for(int car = 0; car < cars.length; car++){
            for(int i = 0; i < fields.length; i++){
                if(fields[i].getChildren().contains(cars[car])){
                    fields[i].getChildren().remove(cars[car]);
                    break;
                }
            }
            fields[39].getChildren().add(cars[car]);
        }

        carMoveOne(0);
        carMoveOne(1);
        carMoveOne(2);
        carMoveOne(3);
        carMoveOne(4);
        carMoveOne(5);

    }
    public void multipleCars(int player, int position){
        if(fields == null) initFields();
        int total = 0;
        if(fields[position].getChildren().contains(cars[0])) total++;
        if(fields[position].getChildren().contains(cars[1])) total++;
        if(fields[position].getChildren().contains(cars[2])) total++;
        if(fields[position].getChildren().contains(cars[3])) total++;
        if(fields[position].getChildren().contains(cars[4])) total++;
        if(fields[position].getChildren().contains(cars[5])) total++;

        cars[player].setTranslateY(total*8);
    }
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

    private StackPane[] fields;
    private void initFields(){
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

    //endregion
    //region fieldPresses

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

    private Button[] fieldButtons;
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
    //region dice

    @FXML
    ImageView dice1;
    @FXML
    ImageView dice2;

    public void roll(){
        Random rnd = new Random();

        int first;
        int second;

        first = rnd.nextInt(1, 7);
        second = rnd.nextInt(1, 7);
        rollDice(first, second);
    }

    public void rollDice(int result1, int result2) {
        String[] dice = new String[6];
        dice[0] = "src/textures/d1.png";
        dice[1] = "src/textures/d2.png";
        dice[2] = "src/textures/d3.png";
        dice[3] = "src/textures/d4.png";
        dice[4] = "src/textures/d5.png";
        dice[5] = "src/textures/d6.png";
        try {
            dice1.setImage(image(dice[result1 -1]));
            dice2.setImage(image(dice[result2 -1]));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Random rnd = new Random();
        //Position of dice can be between 10 and 500


        double x1 = rnd.nextDouble(10, 500);
        double y1 = rnd.nextDouble(10, 500);
        double x2 = rnd.nextDouble(10, 500);
        double y2 = rnd.nextDouble(10, 500);



        boolean touchingOther = true;
        boolean touchingMiddle = false;
        while(touchingMiddle || touchingOther){
             x1 = rnd.nextDouble(10, 500);
             y1 = rnd.nextDouble(10, 500);
             x2 = rnd.nextDouble(10, 500);
             y2 = rnd.nextDouble(10, 500);
            if(x1 < y1+30 && x1 > y1-30){
                touchingOther = true;
            }
            touchingOther = false;


        }

        dice1.setLayoutX(rnd.nextDouble(x1));
        dice1.setLayoutY(rnd.nextDouble(y1));
        dice1.setRotate(rnd.nextDouble(0, 360));
        dice2.setLayoutX(rnd.nextDouble(x2));
        dice2.setLayoutY(rnd.nextDouble(y2));
        dice2.setRotate(rnd.nextDouble(0, 360));

    }


    //endregion
    //region player property cards

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
    //region player money
    @FXML
    StackPane p15000;
    @FXML
    StackPane p12000;
    @FXML
    StackPane p11000;
    @FXML
    StackPane p1500;
    @FXML
    StackPane p1100;
    @FXML
    StackPane p150;
    @FXML
    StackPane p25000;
    @FXML
    StackPane p22000;
    @FXML
    StackPane p21000;
    @FXML
    StackPane p2500;
    @FXML
    StackPane p2100;
    @FXML
    StackPane p250;
    @FXML
    StackPane p35000;
    @FXML
    StackPane p32000;
    @FXML
    StackPane p31000;
    @FXML
    StackPane p3500;
    @FXML
    StackPane p3100;
    @FXML
    StackPane p350;
    @FXML
    StackPane p45000;
    @FXML
    StackPane p42000;
    @FXML
    StackPane p41000;
    @FXML
    StackPane p4500;
    @FXML
    StackPane p4100;
    @FXML
    StackPane p450;
    @FXML
    StackPane p55000;
    @FXML
    StackPane p52000;
    @FXML
    StackPane p51000;
    @FXML
    StackPane p5500;
    @FXML
    StackPane p5100;
    @FXML
    StackPane p550;
    @FXML
    StackPane p65000;
    @FXML
    StackPane p62000;
    @FXML
    StackPane p61000;
    @FXML
    StackPane p6500;
    @FXML
    StackPane p6100;
    @FXML
    StackPane p650;

    //endregion


    //region houses

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
    public void initHouses(){
        propHouses = new ImageView[22];
        propHouses[0] = houseBlue1;
        propHouses[1] = houseBlue2;
        propHouses[2] = houseOrange1;
        propHouses[3] = houseOrange2;
        propHouses[4] = houseOrange3;
        propHouses[5] = houseGreen1;
        propHouses[6] = houseGreen2;
        propHouses[7] = houseGreen3;
        propHouses[8] = houseGrey1;
        propHouses[9] = houseGrey2;
        propHouses[10] = houseGrey3;
        propHouses[11] = houseRed1;
        propHouses[12] = houseRed2;
        propHouses[13] = houseRed3;
        propHouses[14] = houseWhite1;
        propHouses[15] = houseWhite2;
        propHouses[16] = houseWhite3;
        propHouses[17] = houseYellow1;
        propHouses[18] = houseYellow2;
        propHouses[19] = houseYellow3;
        propHouses[20] = housePurple1;
        propHouses[21] = housePurple2;
        for(int i = 0; i < propHouses.length; i++){
            try{
                propHouses[i].setImage(image("src/textures/houseNulIcon.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }





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


}
