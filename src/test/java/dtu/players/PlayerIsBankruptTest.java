package dtu.players;

import dtu.board.Board;
import dtu.board.Field;
import dtu.board.FieldProperty;
import dtu.board.Property;
import dtu.controllers.BoardController;
import dtu.controllers.ControllerHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PlayerIsBankruptTest {

    @Test
    void playerIsBankruptTest() {
        ControllerHandler controllerHandler = new ControllerHandler();
        BoardController boardController = new BoardController();
        ArrayList<Field> properties = new ArrayList<>();
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        controllerHandler.setBoardController(boardController);
        controllerHandler.setBoard(board);

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");

        properties.add(board.getCurrentBoard()[1]);
        playerHandler.getPlayers()[0].setProperties(properties);
        FieldProperty fieldProperty = (FieldProperty) playerHandler.getPlayers()[0].getProperties().get(0);
        fieldProperty.setOwner(playerHandler.getPlayers()[0]);
        //fieldProperty.setOwned(true);
        //fieldProperty.setActiveRent(500);
        //fieldProperty.setBuildings(1);

        playerHandler.playerIsBankrupt(playerHandler.getPlayers()[0]);
        assertEquals(false, playerHandler.getPlayers()[0].isBankrupt());
    }

    @Test
    void playerIsBankruptTest2() {
        //ArrayList<Field> properties = new ArrayList<>();
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        //Player player = new Player(0, "test0", 4000, "black");

        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 4000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 4000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 4000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 4000, "green");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(3);
        FieldProperty fieldProperty34 = (FieldProperty) board.getCurrentBoard()[34];
        fieldProperty34.buy(playerHandler.getPlayers()[0]);
        fieldProperty34.setBuildings(3);

        System.out.println(playerHandler.getPlayers()[0].getProperties().size());

        playerHandler.playerIsBankrupt(playerHandler.getPlayers()[0]);


    }
}



