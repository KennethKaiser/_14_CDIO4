package com.example._14_cdio4;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BoardController {

    //region names
    @FXML
    Text p1Name;
    @FXML
    Text p2Name;
    @FXML
    Text p3Name;
    @FXML
    Text p4Name;

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
            default:
                System.out.println("Error: could not find player with number {" + player + "} while trying to setInJailIcon");
                break;
        }
    }
    //endregion




}
