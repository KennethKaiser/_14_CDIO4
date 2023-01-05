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


    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Background.fxml"));
        HBox root = (HBox) fxmlLoader.load();
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PlayerView.fxml"));
        HBox playerView = (HBox) fxmlLoader.load();
        playerViewController = fxmlLoader.getController();*/
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Board.fxml"));
        StackPane board = (StackPane) fxmlLoader.load();
        boardController = fxmlLoader.getController();

        //playerView.getChildren().add(1, board);
        //root.getChildren().add(board);





        Scene scene = new Scene(board, 1500, 700);
        stage.setTitle("Matador");
        stage.setScene(scene);
        stage.show();

        //BoardController1 controller = fxmlLoader.getController();
        //controller.instantiateBoard();

    }

    public static void main(String[] args) {
        launch();
    }
}