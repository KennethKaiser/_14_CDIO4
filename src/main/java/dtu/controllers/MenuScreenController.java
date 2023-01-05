package dtu.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    int playersAdded;
    String[] colors;
    String[] removedColors;
    HBox[] players;
    Image[] carImages;
    int[] numbers;
    @FXML
    public void initialize(){
        carImages = new Image[6];
        carImages[0] = image("src/textures/greenCar.png");
        carImages[1] = image("src/textures/blueCar.png");
        carImages[2] = image("src/textures/yellowCar.png");
        carImages[3] = image("src/textures/redCar.png");
        carImages[4] = image("src/textures/orangeCar.png");
        carImages[5] = image("src/textures/blackCar.png");
        colors = new String[6];
        colors[0] = "Red";
        colors[1] = "Yellow";
        colors[2] = "Blue";
        colors[3] = "Green";
        colors[4] = "Orange";
        colors[5] = "Black";
        players = new HBox[6];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        players[4] = player5;
        players[5] = player6;
        numbers = new int[6];
        removedColors = new String[6];
        for(int i = 0; i < 6; i++){
            numbers[i] = i;
            removedColors[i] = "";
        }
        updateColorPicker();
    }
    public Image image(String url){
        try{
            InputStream stream = new FileInputStream(url);
            Image newImage = new Image(stream);
            return newImage;
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public Image getCarImage(String color){
        switch (color){
            case "Green":
                return carImages[0];
            case "Blue":
                return carImages[1];
            case "Yellow":
                return carImages[2];
            case "Red":
                return carImages[3];
            case "Orange":
                return carImages[4];
            case "Black":
                return carImages[5];
            default:
                return null;
        }
    }
    private void updateColorPicker(){
        for(int i = 0; i < colors.length; i++){
            if(colors[i] != ""){
                colorPicker.getItems().add(colors[i]);
            }
        }
    }
    public void addPlayerPressed(){
        String name = nameInput.getText();
        String color = (String) colorPicker.getValue();
        removeColor(color);
        Text nameText = new Text(name);
        ImageView carImage = new ImageView();
        carImage.setImage(getCarImage(color));
        carImage.setFitWidth(30);
        Button button = new Button("X");
        button.setOnAction(e -> removePlayer(playersAdded));
        players[playersAdded].getChildren().clear();
        players[playersAdded].getChildren().addAll(nameText, carImage, button);
        playersAdded++;
    }
    private void removePlayer(int player){
        if(player < playersAdded){
            players[player].getChildren().clear();
            players[player].getChildren().addAll(players[player+1]);
            if(player+1 < playersAdded){
                players[player+1].getChildren().clear();
                players[player+1].getChildren().addAll(players[player+2]);
                if(player+2 < playersAdded){
                    players[player+2].getChildren().clear();
                    players[player+2].getChildren().addAll(players[player+3]);
                    if(player+3 < playersAdded){
                        players[player+3].getChildren().clear();
                        players[player+3].getChildren().addAll(players[player+4]);
                        if(player+4 < playersAdded){
                            players[player+4].getChildren().clear();
                            players[player+4].getChildren().addAll(players[player+5]);
                            players[player+5].getChildren().clear();
                        }
                        else players[player+4].getChildren().clear();
                    }
                    else players[player+3].getChildren().clear();
                }
                else players[player+2].getChildren().clear();
            }
            else players[player+1].getChildren().clear();
        }
        else{
            players[player].getChildren().clear();
        }
        for(int i = 0; i < players.length; i++){
            Button b = (Button) players[i].getChildren().get(2);
            int tempIndex = i;
            b.setOnAction(e -> removePlayer(tempIndex));
            players[i].getChildren().set(2, b);
        }
    }
    void removeColor(String color){
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
