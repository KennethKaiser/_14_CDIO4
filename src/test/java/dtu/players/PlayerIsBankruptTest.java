package dtu.players;

import dtu.board.*;
import dtu.controllers.BoardController;
import dtu.controllers.ControllerHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PlayerIsBankruptTest {

    @Test
    void playerIsBankruptTest2() {
        //ArrayList<Field> properties = new ArrayList<>();
        PlayerHandler playerHandler = new PlayerHandler();
        Board board = new Board();
        //Player player = new Player(0, "test0", 4000, "black");

        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Test1", 40000, "black");
        playerHandler.initializePlayerInPlayers(1, "Test2", 40000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Test3", 40000, "red");
        playerHandler.initializePlayerInPlayers(3, "Test4", 40000, "green");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty1.setBuildings(3);
        fieldProperty1.setPledgeState(true);
        FieldProperty fieldProperty34 = (FieldProperty) board.getCurrentBoard()[34];
        fieldProperty34.buy(playerHandler.getPlayers()[0]);
        fieldProperty34.setBuildings(3);

        FerryField ferryField = (FerryField) board.getCurrentBoard()[5];
        ferryField.buy(playerHandler.getPlayers()[0]);
        ferryField.setPledgeState(true);

        BreweryField breweryField = (BreweryField) board.getCurrentBoard()[12];
        breweryField.buy(playerHandler.getPlayers()[0]);
        breweryField.setPledgeState(true);


        playerHandler.playerIsBankrupt(playerHandler.getPlayers()[0]);

        assertEquals(null, fieldProperty1.getOwner());
        assertEquals(false, fieldProperty1.isOwned());
        assertEquals(0, fieldProperty1.getBuildings());
        assertEquals(false, fieldProperty1.isPledgeState());

        assertEquals(null, ferryField.getOwner());
        assertEquals(false, ferryField.getOwned());
        assertEquals(false, ferryField.isPledgeState());

        assertEquals(null, breweryField.getOwner());
        assertEquals(false, breweryField.getOwned());
        assertEquals(false, breweryField.isPledgeState());





    }


}



