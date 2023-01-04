package com.example._14_cdio4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.net.URL;

public class BoardController {

    public void instantiateBoard(){
        System.out.println("Instantiated");
    }
    public void test(){
        System.out.println("Button Pressed");
    }
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
        switch (player){
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
        switch (player){
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


        switch (player){
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
        switch (player){
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
     /*
    Note til Kenneth til bilerne

    Bilen skal flyttes til det stackpane. Det vil automatisk sætte den til toppen af feltet.
    Når der kommer en bil til, vil de blive sat på præcis samme spot.
    Derfor hvis der er mere end en bil, vil de næste biler skulle rykkes på lidt.
    Jeg har målt og der vil være plads til 6 spillere på samme felt hvis dette er med 8 pixels.
    Derfor skal første bil der lander have en top margin på 0.
    bil 2 top margin 8
    bil 3 top margin 16
    bil 4 top margin 24
    bil 5 top margin 32
    bil 6 top margin 40

    Hvis en spiller rykker sig fra feltet, vil de andre ikke rykke op,
    så der skal enten være en update hvor de alle får -8 top margin.
    Ellers skal hver spiller have en konstant top margin på deres bil og stå forskellige steder på brættet.
     */

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
    public StackPane[] getFields(){
        if(fields == null){
            fields = new StackPane[40];
            initFields();
        }
        return fields;
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

    public void buttonPress(int id){

    }


    //endregion




}
