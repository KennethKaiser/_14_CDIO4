package dtu.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class PlayerViewController {
    //region Player Name Tekst
    //tekst elementerne der indeholder navnene på spillerne
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
    //region player money images
    //pX  =  player nr X, the number following is the amount fx p25000 is player 2's 5000 stack.


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



    //Methods
    //________________________________________________________

    //region Get out of jail free card ICON
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
    //region Is in jail ICON
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
}
