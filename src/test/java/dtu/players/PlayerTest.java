package dtu.players;

import dtu.board.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void changePlayerPropertiesTest(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 0, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 0, "green");

        playerHandler.getPlayers()[0].setId(10);
        assertEquals(10, playerHandler.getPlayers()[0].getId());
        playerHandler.getPlayers()[0].setName("Testitest");
        assertEquals("Testitest", playerHandler.getPlayers()[0].getName());
        playerHandler.getPlayers()[0].setColor("testicolor");
        assertEquals("testicolor", playerHandler.getPlayers()[0].getColor());
    }

    @Test
    void testFerries(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Freddy Krueger", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Amanda Young", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Jason Vorhees", 0, "red");
        playerHandler.initializePlayerInPlayers(3, "Micael Myers", 0, "green");
        Ferry ferry =  new Ferry(0,"The Flying Dutchman",9,200,10,20,30,40);
        FerryField ferryField = new FerryField(ferry);
        ArrayList<Field> list = new ArrayList<>();
        list.add(ferryField);

        playerHandler.getPlayers()[0].setFerries(list);

        assertEquals(list, playerHandler.getPlayers()[0].getFerries(),
                "Expect player to have ferry: "+ list +". Player has: "+ playerHandler.getPlayers()[0].getFerries());
    }

    @Test
    void testBreweries(){
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Freddy Krueger", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Amanda Young", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Jason Vorhees", 0, "red");
        playerHandler.initializePlayerInPlayers(3, "Micael Myers", 0, "green");
        Brewery brewery =  new Brewery(0,"Pepsi",9,200,10,20);
        BreweryField breweryField = new BreweryField(brewery);
        ArrayList<Field> list = new ArrayList<>();
        list.add(breweryField);

        playerHandler.getPlayers()[0].setBreweries(list);

        assertEquals(list, playerHandler.getPlayers()[0].getBreweries(),
                "Expect player to have brewery: "+ list +". Player has: "+ playerHandler.getPlayers()[0].getBreweries());
    }

    @Test
    void testJailTurns(){
        //Variable
        final int   TURNS = 7;
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Freddy Krueger", 0, "black");
        playerHandler.initializePlayerInPlayers(1, "Amanda Young", 0, "blue");
        playerHandler.initializePlayerInPlayers(2, "Jason Vorhees", 0, "red");
        playerHandler.initializePlayerInPlayers(3, "Micael Myers", 0, "green");

        playerHandler.getPlayers()[0].setJailTurns(TURNS);

        assertEquals(TURNS, playerHandler.getPlayers()[0].getJailTurns(),
                "Expect player to JailTurns: "+ TURNS +". Player has: "+ playerHandler.getPlayers()[0].getJailTurns());
    }

}