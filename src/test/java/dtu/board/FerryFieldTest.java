package dtu.board;

import dtu.players.PlayerHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FerryFieldTest {

    @Test
    void buy() {
        //Varriable
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", 40000, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", 40000, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", 40000, "red");
        playerHandler.initializePlayerInPlayers(3, "test", 40000, "green");

        //Making Ferries
        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField1 = new FerryField(ferry1);
        Ferry ferry2 = new Ferry((ID+1),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField2 = new FerryField(ferry2);
        Ferry ferry3 = new Ferry((ID+2),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField3 = new FerryField(ferry3);
        Ferry ferry4 = new Ferry((ID+3),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField4 = new FerryField(ferry4);

        ferryField1.buy(playerHandler.getPlayers()[0]);

        //Tester at ferry1 er ejet
        assertEquals(true, ferryField1.getOwned(),"Expect ferry1 ownership to be"+ true +". ferry1 is"+ ferryField1.getOwned());
        //Tester at ejeren er rigtig
        assertEquals(playerHandler.getPlayers()[0], ferryField1.getOwner(), "Expect ferry1 to be owned by: "+ playerHandler.getPlayers()[0] +". Owner is"+ ferryField1.getOwner());
        //Tester at ferry1 ikke er pantsat
        assertEquals(false, ferryField1.isPledgeState(),"Expect ferry1 pledgestate to be"+ false +". ferry1 is"+ ferryField1.isPledgeState());

    }

    @Test
    void rent() {
        //Varriable
        final int STAR_MONEY = 40000;
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;
        int moneyRent1 = (STAR_MONEY - RENT1);
        int moneyRent2 = (moneyRent1 -RENT2);
        int moneyRent3 = (moneyRent2 - RENT3);
        int moneyRent4 = (moneyRent3 - RENT4);
        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", STAR_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", STAR_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", STAR_MONEY, "red");
        playerHandler.initializePlayerInPlayers(3, "test", STAR_MONEY, "green");

        //Making Ferries
        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField1 = new FerryField(ferry1);
        Ferry ferry2 = new Ferry((ID+1),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField2 = new FerryField(ferry2);
        Ferry ferry3 = new Ferry((ID+2),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField3 = new FerryField(ferry3);
        Ferry ferry4 = new Ferry((ID+3),NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField4 = new FerryField(ferry4);

        //Tester rent1
        ferryField1.buy(playerHandler.getPlayers()[0]);
        ferryField1.rent(playerHandler.getPlayers()[1],ferryField1.findActiveRent());

        assertEquals(moneyRent1, playerHandler.getPlayers()[1].getMoney(), "expect player to have money: "+ moneyRent1 +". Player has: "+ playerHandler.getPlayers()[0].getMoney());

        //Tester rent2
        ferryField2.buy(playerHandler.getPlayers()[0]);
        ferryField2.rent(playerHandler.getPlayers()[1],ferryField1.findActiveRent());

        assertEquals(moneyRent2, playerHandler.getPlayers()[1].getMoney(), "expect player to have money: "+ moneyRent2 +". Player has: "+ playerHandler.getPlayers()[0].getMoney());

        //Tester rent3
        ferryField3.buy(playerHandler.getPlayers()[0]);
        ferryField3.rent(playerHandler.getPlayers()[1],ferryField1.findActiveRent());

        assertEquals(moneyRent3, playerHandler.getPlayers()[1].getMoney(), "expect player to have money: "+ moneyRent3 +". Player has: "+ playerHandler.getPlayers()[0].getMoney());

        //Tester rent4
        ferryField4.buy(playerHandler.getPlayers()[0]);
        ferryField4.rent(playerHandler.getPlayers()[1],ferryField1.findActiveRent());

        assertEquals(moneyRent4, playerHandler.getPlayers()[1].getMoney(), "expect player to have money: "+ moneyRent4 +". Player has: "+ playerHandler.getPlayers()[0].getMoney());

    }

    @Test
    void LabelAndType() {
        //Variable
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;
        //expected
        final String LABEL = "Du er landet på færgen: "+NAME+".";
        final String TYPE = "ferry";
        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField1 = new FerryField(ferry1);

        //Tester label på ferry
        assertEquals(LABEL, ferryField1.landedLabel(),"expect ferry label to be: "+ LABEL +". Ferry label is: " + ferryField1.landedLabel());
        //Tester type på ferry
        assertEquals(TYPE, ferryField1.type(),"expect ferry type to be: "+ TYPE +". Ferry type is: " + ferryField1.type());

    }

    @Test
    void Ferry() {
        //Variable
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final String NAME2 = "Molslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;
        //expected
        final String LABEL = "Du er landet på færgen: " + NAME + ".";
        final String TYPE = "ferry";
        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        Ferry ferry2 = new Ferry((ID+1), NAME2, (FAMILY+1), (PRICE+500), (RENT1+500), (RENT2+500), (RENT3+500), (RENT4+500));
        FerryField ferryField1 = new FerryField(ferry1);

        //Tester ferry på ferryField
        assertEquals(ferry1, ferryField1.getFerry(), "expect ferry to be: " + ferry1 + ". Ferry is: " + ferryField1.getFerry());
        //Tester ferry på ferryField efter ændring
        ferryField1.setFerry(ferry2);
        assertEquals(ferry2, ferryField1.getFerry(), "expect ferry after change to be: " + ferry2 + ". Ferry is: " + ferryField1.getFerry());
    }

    @Test
    void OwnerShip() {
        //Variable
        final int STAR_MONEY = 40000;
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final String NAME2 = "Molslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;

        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", STAR_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", STAR_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", STAR_MONEY, "red");
        playerHandler.initializePlayerInPlayers(3, "test", STAR_MONEY, "green");

        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField1 = new FerryField(ferry1);

        //Tester ferry ikke ejes
        assertEquals(false, ferryField1.getOwned(), "expect ferry ownership to be: " + false + ". Ferry is: " + ferryField1.getOwned());
        assertEquals(null, ferryField1.getOwner(), "expect ferry owner to be: " + null + ". Ferry is: " + ferryField1.getOwner());
        //Tester ferry på ferryField efter ændring
        ferryField1.setOwner(playerHandler.getPlayers()[0]);
        ferryField1.setOwned(true);
        assertEquals(true, ferryField1.getOwned(), "expect ferry ownership to be: " + true + ". Ferry is: " + ferryField1.getOwned());
        assertEquals(playerHandler.getPlayers()[0], ferryField1.getOwner(), "expect ferry owner to be: " + null + ". Ferry is: " + ferryField1.getOwner());
   }

    @Test
    void Pledgestate() {
        //Variable
        final int STAR_MONEY = 40000;
        final int ID = 5;
        final String NAME = "Bornholmslinjen";
        final String NAME2 = "Molslinjen";
        final int FAMILY = 9;
        final int PRICE = 1000;
        final int RENT1 = 500;
        final int RENT2 = 1000;
        final int RENT3 = 1500;
        final int RENT4 = 3000;

        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.initializePlayers(4);
        playerHandler.initializePlayerInPlayers(0, "Niels", STAR_MONEY, "black");
        playerHandler.initializePlayerInPlayers(1, "Karl", STAR_MONEY, "blue");
        playerHandler.initializePlayerInPlayers(2, "Hans", STAR_MONEY, "red");
        playerHandler.initializePlayerInPlayers(3, "test", STAR_MONEY, "green");

        Ferry ferry1 = new Ferry(ID,NAME,FAMILY,PRICE,RENT1,RENT2,RENT3,RENT4);
        FerryField ferryField1 = new FerryField(ferry1);

        ferryField1.buy(playerHandler.getPlayers()[0]);
        ferryField1.setPledgeState(true);
        //Tester ferry er pledged
        assertEquals(true, ferryField1.isPledgeState(), "expect ferry pledgestate to be: " + true + ". Ferry is: " + ferryField1.isPledgeState());
        //Tester at ejeren stadig er den samme
        assertEquals(playerHandler.getPlayers()[0], ferryField1.getOwner(), "expect ferry owner to be: " + null + ". Ferry is: " + ferryField1.getOwner());
        }

    }