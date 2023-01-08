package dtu.controllers;

import dtu._14_cdio4.SceneSwitch;

public class ControllerHandler {


    private BoardController boardController;
    private ChanceCardsController chanceCardsController;
    private PlayerViewController playerViewController;
    private PropertyMenuController propertyMenuController;
    private StartGameController startGameController;
    private TradingMenuController tradingMenuController;
    private MenuScreenController menuScreenController;
    private SceneSwitch sceneSwitch;

    public static ControllerHandler controllerHandler = null;

    public static ControllerHandler getInstance(){
        if(controllerHandler == null) controllerHandler = new ControllerHandler();
        return controllerHandler;
    }

    public void switchToMenu(){
        sceneSwitch.switchToMenu();
    }
    public void switchToBoard(){
        sceneSwitch.switchToBoard();
        playerViewController.updatePlayerName();
        playerViewController.updatePlayerMoney();
    }


    //region getters and setters
    public SceneSwitch getSceneSwitch() {
        return sceneSwitch;
    }

    public void setSceneSwitch(SceneSwitch sceneSwitch) {
        this.sceneSwitch = sceneSwitch;
    }

    public MenuScreenController getMenuScreenController() {
        return menuScreenController;
    }

    public void setMenuScreenController(MenuScreenController menuScreenController) {
        this.menuScreenController = menuScreenController;
    }



    public BoardController getBoardController() {
        return boardController;
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
    }

    public ChanceCardsController getChanceCardsController() {
        return chanceCardsController;
    }

    public void setChanceCardsController(ChanceCardsController chanceCardsController) {
        this.chanceCardsController = chanceCardsController;
    }

    public PlayerViewController getPlayerViewController() {
        return playerViewController;
    }

    public void setPlayerViewController(PlayerViewController playerViewController) {
        this.playerViewController = playerViewController;
    }

    public PropertyMenuController getPropertyMenuController() {
        return propertyMenuController;
    }

    public void setPropertyMenuController(PropertyMenuController propertyMenuController) {
        this.propertyMenuController = propertyMenuController;
    }

    public StartGameController getStartGameController() {
        return startGameController;
    }

    public void setStartGameController(StartGameController startGameController) {
        this.startGameController = startGameController;
    }

    public TradingMenuController getTradingMenuController() {
        return tradingMenuController;
    }

    public void setTradingMenuController(TradingMenuController tradingMenuController) {
        this.tradingMenuController = tradingMenuController;
    }
    //endregion
}
