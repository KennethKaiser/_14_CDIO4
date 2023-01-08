package dtu._14_cdio4;

import dtu.controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitch {

    Stage stage;
    //region controllers
    private BoardController boardController;
    private ChanceCardsController chanceCardsController;
    private PlayerViewController playerViewController;
    private PropertyMenuController propertyMenuController;
    private StartGameController startGameController;
    private TradingMenuController tradingMenuController;
    private MenuScreenController menuScreenController;
    //endregion
    //region loads
    VBox menu;
    HBox root;
    HBox playerView;
    StackPane board;
    StackPane chanceCards;
    StackPane propertyMenu;
    //endregion
    Scene menuScene;
    Scene boardScene;
    public SceneSwitch(Stage stage) throws IOException {
        this.stage = stage;
        ControllerHandler.getInstance().setSceneSwitch(this);
        loadScenes();
        collectBoard();
        switchToMenu();
        //switchToBoard();
    }
    private void loadScenes() throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MenuScreen.fxml"));
        menu = (VBox) fxmlLoader.load();
        menuScreenController = fxmlLoader.getController();
        ControllerHandler.getInstance().setMenuScreenController(menuScreenController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Background.fxml"));
        root = (HBox) fxmlLoader.load();
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PlayerView.fxml"));
        playerView = (HBox) fxmlLoader.load();
        playerViewController = fxmlLoader.getController();
        ControllerHandler.getInstance().setPlayerViewController(playerViewController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Board.fxml"));
        board = (StackPane) fxmlLoader.load();
        boardController = fxmlLoader.getController();
        ControllerHandler.getInstance().setBoardController(boardController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ChanceCards.fxml"));
        chanceCards = (StackPane) fxmlLoader.load();
        chanceCardsController = fxmlLoader.getController();
        ControllerHandler.getInstance().setChanceCardsController(chanceCardsController);
        fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PropertyMenu.fxml"));
        propertyMenu = (StackPane) fxmlLoader.load();
        propertyMenuController = fxmlLoader.getController();
        ControllerHandler.getInstance().setPropertyMenuController(propertyMenuController);
    }
    private void collectBoard(){
        boardController.getMiddleMenuVBox().getChildren().add(0, chanceCards);
        playerView.getChildren().add(1, board);
        root.getChildren().add(playerView);

        boardScene = new Scene(root, 1500, 700);
    }
    public void switchToMenu(){
        stage.setTitle("Matador");
        menuScene = new Scene(menu, 800, 700);
        stage.setScene(menuScene);
        stage.show();
    }
    public void switchToBoard(){
        stage.setScene(boardScene);
        stage.setX(10);
        stage.setY(20);
        stage.setResizable(false);
        stage.show();
        boardController.initializingPlayers(menuScreenController.getMenuAmountOfPlayers(), menuScreenController.getMenuNames(), menuScreenController.getMenuCarColorImages(), menuScreenController.getColorNames());
        playerViewController.addCard(0, 0);
        playerViewController.addCard(0, 0);
        playerViewController.addCard(4, 0);
        playerViewController.addCard(4, 0);
        playerViewController.addCard(4, 0);
    }

}
