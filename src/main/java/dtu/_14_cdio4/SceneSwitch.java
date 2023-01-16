package dtu._14_cdio4;

import dtu.board.Field;
import dtu.board.Property;
import dtu.controllers.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
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
    private CommunicationController communicationController;
    private PauseMenuController pauseMenuController;
    //endregion
    //region loads
    AnchorPane menu;
    HBox root;
    HBox playerView;
    AnchorPane board;
    AnchorPane chanceCards;
    AnchorPane propertyMenu;
    AnchorPane communication;
    AnchorPane tradeMenu;
    AnchorPane pauseMenu;
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
        menu = (AnchorPane) fxmlLoader.load();
        menuScreenController = fxmlLoader.getController();
        ControllerHandler.getInstance().setMenuScreenController(menuScreenController);
    }
    public void loadNew() {
        try{
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Background.fxml"));
            root = (HBox) fxmlLoader.load();
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PlayerView.fxml"));
            playerView = (HBox) fxmlLoader.load();
            playerViewController = fxmlLoader.getController();
            ControllerHandler.getInstance().setPlayerViewController(playerViewController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Board.fxml"));
            board = (AnchorPane) fxmlLoader.load();
            boardController = fxmlLoader.getController();
            ControllerHandler.getInstance().setBoardController(boardController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("ChanceCards.fxml"));
            chanceCards = (AnchorPane) fxmlLoader.load();
            chanceCardsController = fxmlLoader.getController();
            ControllerHandler.getInstance().setChanceCardsController(chanceCardsController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PropertyMenu.fxml"));
            propertyMenu = (AnchorPane) fxmlLoader.load();
            propertyMenuController = fxmlLoader.getController();
            ControllerHandler.getInstance().setPropertyMenuController(propertyMenuController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Communication.fxml"));
            communication = (AnchorPane) fxmlLoader.load();
            communicationController = fxmlLoader.getController();
            ControllerHandler.getInstance().setCommunicationController(communicationController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("TradeMenu.fxml"));
            tradeMenu = (AnchorPane) fxmlLoader.load();
            tradingMenuController = fxmlLoader.getController();
            ControllerHandler.getInstance().setTradingMenuController(tradingMenuController);
            fxmlLoader = new FXMLLoader(MainApplication.class.getResource("PauseMenu.fxml"));
            pauseMenu = (AnchorPane) fxmlLoader.load();
            pauseMenuController = fxmlLoader.getController();
            ControllerHandler.getInstance().setPauseMenuController(pauseMenuController);
        } catch (Exception e){
            System.out.println("Failed To load");
        }

    }
    private void collectBoard(){
        loadNew();
        showChanceCardPileInMiddle();
        boardController.getMiddleParent().getChildren().add(3, communication);
        playerViewController.getWholeArea().getChildren().add(1, board);
        root.getChildren().add(playerView);
        boardScene = new Scene(root);
    }
    public void switchToMenu(){
        stage.setTitle("Matador");
        menuScene = new Scene(menu);
        stage.setScene(menuScene);
        stage.show();
    }
    public void switchToBoard(boolean isLoad){
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setScene(boardScene);
        stage.setMaximized(true);
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
        boardController.initializingPlayers(menuScreenController.getMenuAmountOfPlayers(), menuScreenController.getMenuNames(), menuScreenController.getColorNames(isLoad));
        boardController.giveButtonsFunctions();
        boardController.startCars(isLoad);
        boardController.initializeStartPlayerTurn();
        boardController.initCheating();
    }
    public void showCardInMiddle(Field[] properties, int player){
        boardController.getMiddleMenuVBox().getChildren().clear();
        boardController.getMiddleMenuVBox().getChildren().add(propertyMenu);
        propertyMenuController.showProperties(properties, player);
    }
    public void showChanceCardPileInMiddle(){
        boardController.getMiddleMenuVBox().getChildren().clear();
        boardController.getMiddleMenuVBox().getChildren().add(chanceCards);
    }
    public void switchToPauseMenu(){
        if(!boardController.getMiddleParent().getChildren().contains(pauseMenu)){
            boardController.getMiddleParent().getChildren().add(pauseMenu);
            pauseMenuController.open();
        }
    }
    public void removePauseMenu(){
        boardController.getMiddleParent().getChildren().remove(pauseMenu);
    }
    public void showTradingMenu(){
        System.out.println("Switching to trade Menu");
        boardController.getMiddleMenuVBox().getChildren().clear();
        boardController.getMiddleMenuVBox().getChildren().add(tradeMenu);
        tradingMenuController.onSwitched();
    }

}
