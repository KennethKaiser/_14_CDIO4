package dtu._14_cdio4;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class MenuScreenController {
    @FXML
    HBox player1;
    @FXML
    HBox player2;
    @FXML
    HBox player3;
    @FXML
    HBox player4;
    @FXML
    HBox player5;
    @FXML
    HBox player6;

    @FXML
    ComboBox colorPicker;
    @FXML
    TextField nameInput;

    String[] colors;
    String[] removedColors;
    int[] numbers;
    public void initController(){

       colors = new String[6];
       colors[0] = "Red";
       colors[1] = "Yellow";
       colors[2] = "Blue";
       colors[3] = "Green";
       colors[4] = "Orange";
       colors[5] = "Black";
       numbers = new int[6];
       removedColors = new String[6];
       for(int i = 0; i < 6; i++){
           numbers[i] = i;
           removedColors[i] = "";
       }


        colorPicker.getItems().addAll(colors[0], colors[1], colors[2], colors[3], colors[4], colors[5]);
    }

    public void addPlayerPressed(){
        String name = nameInput.getText();
        String color = (String) colorPicker.getValue();
        remove(color);
    }
    void remove(String color){
        colorPicker.getItems().removeAll();
        for (int i = 0; i < colors.length; i++){
            if(colors[i].equals(color)){
                colors[i] = "";
                for(int n = 0; n < removedColors.length; n++){
                    if(removedColors[n] == ""){
                        removedColors[n] = color;
                        break;
                    }
                }

            }
        }

    }

    public void startGamePressed(){

    }

}
