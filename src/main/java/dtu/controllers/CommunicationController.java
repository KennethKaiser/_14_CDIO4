package dtu.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CommunicationController {



    //region FXML
    @FXML
    Button choice1;
    @FXML
    Button choice2;
    @FXML
    Button choice3;
    @FXML
    Text text;
    @FXML
    HBox parent;
    @FXML
    VBox buttonVBox;
    Button[] choices;

    //endregion

    @FXML
    public void initialize(){
        hideCommunicationBox();
    }

    private void initButtons(){
        choices = new Button[3];
        choices[0] = choice1;
        choices[1] = choice2;
        choices[2] = choice3;
        for(int i = 0; i < choices.length; i++){

        }
    }
    public void showCommunicationBox(String text, String[] options){
        this.text.setText(text);
        buttonVBox.getChildren().clear();
        parent.setOpacity(1);
        for(int i = 0; i < options.length; i++){
            buttonVBox.getChildren().add(choices[i]);
            choices[i].setText(options[i]);
        }
    }
    public void hideCommunicationBox(){
        parent.setOpacity(0);
    }
    public void buttonPressed(int choiceCase){
        switch (choiceCase){

        }

    }

}
