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
        FXMLLoader fxmlLoader;

        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MenuScreen.fxml"));
        VBox menu = (VBox) fxmlLoader.load();
        menuScreenController = fxmlLoader.getController();
        ControllerHandler.getInstance().setMenuScreenController(menuScreenController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Background.fxml"));
        HBox root = (HBox) fxmlLoader.load();
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PlayerView.fxml"));
        HBox playerView = (HBox) fxmlLoader.load();
        playerViewController = fxmlLoader.getController();
        ControllerHandler.getInstance().setPlayerViewController(playerViewController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Board.fxml"));
        StackPane board = (StackPane) fxmlLoader.load();
        boardController = fxmlLoader.getController();
        ControllerHandler.getInstance().setBoardController(boardController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ChanceCards.fxml"));
        StackPane chanceCards = (StackPane) fxmlLoader.load();
        chanceCardsController = fxmlLoader.getController();
        ControllerHandler.getInstance().setChanceCardsController(chanceCardsController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PropertyMenu.fxml"));
        StackPane propertyMenu = (StackPane) fxmlLoader.load();
        propertyMenuController = fxmlLoader.getController();
        ControllerHandler.getInstance().setPropertyMenuController(propertyMenuController);


        boardController.getMiddleMenuVBox().getChildren().add(0, propertyMenu);

        //Method needed here to switch which thing is in the middle of the board. Normally



        playerView.getChildren().add(1, board);
        root.getChildren().add(playerView);





        Scene scene = new Scene(root, 1500, 700);
        stage.setTitle("Matador");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}