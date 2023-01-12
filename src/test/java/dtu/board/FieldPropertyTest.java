package dtu.board;

import dtu.controllers.BoardController;
import dtu.players.PlayerHandler;
import dtu.board.Board;
import dtu.board.FieldProperty;
import dtu.controllers.ControllerHandler;
import org.junit.jupiter.api.Test;
import dtu.board.HousingLogic;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FieldPropertyTest {

    @Test
    void testLabelAndType() {
        //expected
        final String LABEL = "Du er landet på Rødovrevej";
        final String TYPE = "buyablefield";
        BoardController boardController = new BoardController();
        Board board = new Board();

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];

        //Tester at FieldProperty kan give label og type
        assertEquals(LABEL, fieldProperty1.landedLabel(),"expect Rødovrevej to have label: " + LABEL + ". Rødovrevej has: " + fieldProperty1.landedLabel());
        assertEquals(TYPE,fieldProperty1.type(),"expect Rødovrevej to have type: " + TYPE + ". Rødovrevej has type: " + fieldProperty1.type());
    }

    @Test
    void testSetProperty() {
        //expected
        final int NewID = 2;
        final int NewFamilie = 3;
        final String NewName = "Bornholm";
        BoardController boardController = new BoardController();
        Board board = new Board();

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        Property property2 = new Property(NewID,NewFamilie,NewName,1,2,3,4,5,6,7,8,9);

        //Test at Rødovrevej er det rette felt
        assertEquals("Rødovrevej",fieldProperty1.getProperty().getName(),"expect Rødovrevej to at start be named: " + "Rødovrevej" + ". Rødovrevej is named: " + fieldProperty1.getProperty().getName());
        assertEquals(1,fieldProperty1.getProperty().getID(),"expect Rødovrevej to have ID: " + 1 + ". Rødovrevej has ID: " + fieldProperty1.getProperty().getID());
        assertEquals(1,fieldProperty1.getProperty().getFamilie(),"expect Rødovrevej to have family: " + 1 + ". Rødovrevej has family: " + fieldProperty1.getProperty().getFamilie());

        fieldProperty1.setProperty(property2);

        //Test at setProperty virker
        assertEquals(NewName,fieldProperty1.getProperty().getName(),"expect new name to be: " + NewName + ". the name is: " + fieldProperty1.getProperty().getName());
        assertEquals(NewID,fieldProperty1.getProperty().getID(),"expect new ID to be: " + NewID + ". ID is: " + fieldProperty1.getProperty().getID());
        assertEquals(NewFamilie,fieldProperty1.getProperty().getFamilie(),"expect new family to be: " + NewFamilie + ". family is: " + fieldProperty1.getProperty().getFamilie());

    }

    @Test
    void testPledge() {
        //expected
        final boolean STARTPLEDGE = false;
        final boolean NEWPLEDGE = true;
        BoardController boardController = new BoardController();
        Board board = new Board();

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];

        //Test at FieldProperty ikke er pledge i starten
        assertEquals(STARTPLEDGE,fieldProperty1.isPledgeState(),"expect Rødovrevej to have pledgestate: " + STARTPLEDGE + ". Rødovrevej is pledged as: " + fieldProperty1.isPledgeState());


        fieldProperty1.setPledgeState(NEWPLEDGE);

        //Test at setPledgeState virker
        assertEquals(NEWPLEDGE,fieldProperty1.isPledgeState(),"expect Rødovrevej to have pledgestate: " + NEWPLEDGE + ". Rødovrevej is pledged as: " + fieldProperty1.isPledgeState());

    }

/*
    @Test
    void testActiveRent() {
        //expected
        final int ActiveRent0 = 50;
        final int ActiveRent1 = 250;
        final int ActiveRent2 = 750;
        final int ActiveRent3 = 2250;
        final int ActiveRent4 = 4000;
        final int ActiveRent5 = 6000;
        Board board = new Board();
        PlayerHandler playerHandler = new PlayerHandler();
        ControllerHandler controllerHandler = new ControllerHandler();
        BoardController boardController = new BoardController();
        HousingLogic housingLogic = new HousingLogic();

        playerHandler.initializePlayers(3);
        playerHandler.initializePlayerInPlayers(0,"Niels", 20000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 20000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 20000, "red");

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];
        FieldProperty fieldProperty2 = (FieldProperty) board.getCurrentBoard()[3];
        fieldProperty1.buy(playerHandler.getPlayers()[0]);
        fieldProperty2.buy(playerHandler.getPlayers()[1]);

        //Test at FieldProperty har rette rent aktiv
        assertEquals(ActiveRent0,fieldProperty1.findActiveRent(),"expect Rødovrevej to have rent: " + ActiveRent0 + ". Rødovrevej has rent: " + fieldProperty1.findActiveRent());


        fieldProperty1.setBuildings(1);

        //Test at FieldProperty har rette rent aktiv
        assertEquals(ActiveRent1,fieldProperty1.findActiveRent(),"expect Rødovrevej to have rent: " + ActiveRent1 + ". Rødovrevej has rent: " + fieldProperty1.findActiveRent());

        fieldProperty1.setBuildings(2);

        //Test at FieldProperty har rette rent aktiv
        assertEquals(ActiveRent2,fieldProperty1.findActiveRent(),"expect Rødovrevej to have rent: " + ActiveRent2 + ". Rødovrevej has rent: " + fieldProperty1.findActiveRent());

    }

 */

    @Test
    void testOwnership() {
        //expected
        final boolean FOwn = false;
        final boolean NOwn = true;
        BoardController boardController = new BoardController();
        Board board = new Board();

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];

        //Test at FieldProperty ikke er pledge i starten
        assertEquals(FOwn,fieldProperty1.getOwned(),"expect Rødovrevej to have no owner: " + FOwn + ". Rødovrevej is has owner as: " + fieldProperty1.getOwned());


        fieldProperty1.setOwned(NOwn);

        //Test at setPledgeState virker
        assertEquals(NOwn,fieldProperty1.isOwned(),"expect Rødovrevej to have pledgestate: " + NOwn + ". Rødovrevej is pledged as: " + fieldProperty1.isOwned());

    }

    @Test
    void testFamily() {
        //expected
        final int FFAMILIE = 1;
        final int NFAMILIE = 3;
        BoardController boardController = new BoardController();
        Board board = new Board();

        FieldProperty fieldProperty1 = (FieldProperty) board.getCurrentBoard()[1];

        //Test at FieldProperty ikke er pledge i starten
        assertEquals(FFAMILIE,fieldProperty1.getFamilie(),"expect Rødovrevej to have familie: " + FFAMILIE + ". Rødovrevej has familie as: " + fieldProperty1.getFamilie());


        fieldProperty1.setFamilie(NFAMILIE);

        //Test at setPledgeState virker
        assertEquals(NFAMILIE,fieldProperty1.getFamilie(),"expect Rødovrevej to have familie: " + NFAMILIE + ". Rødovrevej has familie as: " + fieldProperty1.getFamilie());

    }

}