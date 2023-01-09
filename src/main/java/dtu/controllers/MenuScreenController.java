package dtu.controllers;

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
    Text communicator;
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
    Text name1;
    @FXML
    Text name2;
    @FXML
    Text name3;
    @FXML
    Text name4;
    @FXML
    Text name5;
    @FXML
    Text name6;
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
    Button button1;
    @FXML
    Button button2;
    @FXML
    Button button3;
    @FXML
    Button button4;
    @FXML
    Button button5;
    @FXML
    Button button6;
    @FXML
    ComboBox colorPicker;
    @FXML
    TextField nameInput;

    int playersAdded;
    String[] playerNamesAdded;
    Image[] playerColorsAdded;
    String[] colors;
    String[] colorsDanish;
    String[] removedColors;
    HBox[] players;
    Image[] carImages;
    ImageView[] cars;
    Text[] names;
    Button[] buttons;
    int[] numbers;




    @FXML
    public void initialize() {
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
        colorsDanish = new String[6];
        colors[0] = "Rød";
        colors[1] = "Gul";
        colors[2] = "Blå";
        colors[3] = "Grøn";
        colors[4] = "Orange";
        colors[5] = "Sort";
        players = new HBox[6];
        players[0] = player1;
        players[1] = player2;
        players[2] = player3;
        players[3] = player4;
        players[4] = player5;
        players[5] = player6;
        for(int i = 0; i < players.length; i++){
            players[i].setOpacity(0);
        }
        numbers = new int[6];
        removedColors = new String[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = i;
            removedColors[i] = "";
        }
        updateColorPicker();
        buttons = new Button[6];
        buttons[0] = button1;
        buttons[1] = button2;
        buttons[2] = button3;
        buttons[3] = button4;
        buttons[4] = button5;
        buttons[5] = button6;
        names = new Text[6];
        names[0] = name1;
        names[1] = name2;
        names[2] = name3;
        names[3] = name4;
        names[4] = name5;
        names[5] = name6;
        cars = new ImageView[6];
        cars[0] = car1;
        cars[1] = car2;
        cars[2] = car3;
        cars[3] = car4;
        cars[4] = car5;
        cars[5] = car6;
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
    private Image getCarImage(String color){
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
        colorPicker.getItems().clear();
        for(int i = 0; i < colors.length; i++){
            if(colors[i] != ""){
                colorPicker.getItems().add(colorDanishfy(colors[i]));
            }
        }
    }
    private String colorDanishfy(String color){
        switch (color){
            case "Red":
            case "Rød":
                return "Rød";
            case "Yellow":
            case "Gul" :
                    return "Gul";
            case "Blue":
            case "Blå":
                return "Blå";
            case "Orange": return "Orange";
            case "Green":
            case "Grøn":
                    return "Grøn";
            case "Black":
            case "Sort":
                return "Sort";
        }
        return "fejl";
    }
    private String colorEnglishfy(String color){
        switch (color){
            case "Rød": return "Red";
            case "Gul": return "Yellow";
            case "Blå": return "Blue";
            case "Orange": return "Orange";
            case "Grøn": return "Green";
            case "Sort": return "Black";
        }
        return "fejl";
    }
    public void addPlayerPressed(){
        if(playersAdded < 6){
            if(nameInput.getText().length() < 16){
                if(!nameInput.getText().equals("")) {
                    boolean free = true;
                    for(int currentNames = 0; currentNames < playersAdded; currentNames++){
                        if(nameInput.getText().equals(names[currentNames].getText())) {
                            free = false;
                        }
                    }
                    if(free){
                        if(colorPicker.getValue() != null){
                            String name = nameInput.getText();
                            String color = colorEnglishfy(colorPicker.getValue().toString());
                            removeColor(color);
                            for(int i = 0; i < players.length; i++){
                                if(players[i].getOpacity() < 1){
                                    setPlayer(i,name,color);
                                    break;
                                }
                            }
                            playersAdded++;
                            communicator.setText("Tilføjede " + name + " til spillet");

                        }
                        else{
                            communicator.setText("Du skal vælge en farve, med dropdown menuen");
                        }
                    }
                    else{
                        communicator.setText("Du kan ikke hedde det samme navn to gange");
                    }
                }
                else{
                    communicator.setText("Indsæt et navn til spilleren");
                }
            }
            else{
                communicator.setText("Dit navn skal være på maximum 15 karakterer");
            }
        }
        else{
            communicator.setText("Du kan kun tilføje op til 6 spillere");
        }
    }
    private void setPlayer(int playerNumber, String name, String color){
        players[playerNumber].setOpacity(1);
        names[playerNumber].setText(name);
        cars[playerNumber].setImage(getCarImage(color));
        buttons[playerNumber].setOnAction(e -> removePlayer(playerNumber, color));
    }
    private void removePlayer(int playerNumber, String colorToReturn){
        for(int i = 0; i < colors.length;i++){
            if(colors[i] == "") {
                colors[i] = colorToReturn;
                break;
            }
        }
        if(playerNumber < playersAdded-1){
            moveDown(playerNumber+1, colorToReturn);
        }
        else{
            players[playerNumber].setOpacity(0);
        }
        playersAdded--;
        updateColorPicker();
    }
    private void moveDown(int playerNumber, String color){
        names[playerNumber-1].setText(names[playerNumber].getText());
        cars[playerNumber-1].setImage(cars[playerNumber].getImage());
        buttons[playerNumber-1].setOnAction(e -> removePlayer(playerNumber-1, color));
        if(playerNumber < playersAdded-1){
            moveDown(playerNumber+1, color);
        }
        else{
            players[playerNumber].setOpacity(0);
        }
    }
    private void removeColor(String color){
        colorPicker.getItems().removeAll();
        for (int i = 0; i < colors.length; i++){
            if(colors[i].equals(colorDanishfy(color))){
                colors[i] = "";
            }
        }
        updateColorPicker();
    }
    public void startGamePressed(){
        if(playersAdded < 3){
            communicator.setText("Du skal tilføje minimum 3 spillere før du kan starte spillet");
        }
        else{
            playerColorsAdded = new Image[playersAdded];
            playerNamesAdded = new String[playersAdded];
            for(int i = 0; i < playersAdded; i++){
                playerColorsAdded[i] = cars[i].getImage();
                playerNamesAdded[i] = names[i].getText();
            }
            ControllerHandler.getInstance().switchToBoard();
        }

    }
    public String[] getMenuNames(){
        return playerNamesAdded;
    }
    public Image[] getMenuCarColorImages(){
        Image[] carColors = new Image[playersAdded];
        for(int i = 0; i <carColors.length; i++){
            carColors[i] = cars[i].getImage();
        }

        return carColors;
    }
    public String[] getColorNames(){
        String[] colors = new String[playersAdded];
        for(int i = 0; i < playersAdded; i++){
            if(cars[i].getImage() == carImages[0]){
                colors[i] = "Green";
            } else if(cars[i].getImage() == carImages[1]){
                colors[i] = "Blue";
            } else if(cars[i].getImage() == carImages[2]){
                colors[i] = "Yellow";
            } else if(cars[i].getImage() == carImages[3]){
                colors[i] = "Red";
            } else if(cars[i].getImage() == carImages[4]){
                colors[i] = "Orange";
            } else if(cars[i].getImage() == carImages[5]){
                colors[i] = "Black";
            }
        }
        return colors;
    }

    public int getMenuAmountOfPlayers(){
        return playersAdded;
    }

}
