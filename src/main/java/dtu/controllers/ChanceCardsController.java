package dtu.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ChanceCardsController {




    //region FXML
    @FXML
    Button pileButton;
    @FXML
    Text chanceCardText;
    @FXML
    Text chanceCardTitle;
    @FXML
    VBox chanceCardShown;
    //endregion

    @FXML
    public void initialize(){
        pileButton.setOnAction(e -> pullCard());
    }

    public void showChanceCard(String title, String text){
        chanceCardText.setText(text);
        chanceCardTitle.setText(title);
        chanceCardShown.setOpacity(1);
    }
    public void hideChanceCard(){
        chanceCardShown.setOpacity(0);
    }
    public void pullCard(){

    }
}
