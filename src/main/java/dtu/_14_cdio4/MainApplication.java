package dtu._14_cdio4;

import dtu.controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private BoardController boardController;
    private ChanceCardsController chanceCardsController;
    private PlayerViewController playerViewController;
    private PropertyMenuController propertyMenuController;
    private StartGameController startGameController;
    private TradingMenuController tradingMenuController;
    private MenuScreenController menuScreenController;
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitch sceneSwitch = new SceneSwitch(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}