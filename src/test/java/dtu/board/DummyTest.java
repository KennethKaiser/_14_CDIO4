package dtu.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Skal muligvis ændres hvis Parkering giver penge sum
class DummyTest {

    @Test
    void testIDAndName() {
       final int ID = 2;
       final String NAME = "Jigsaw";
       Board board = new Board();

       Dummy dummy = new Dummy(ID,NAME);

       //Tester at label på Chance er rigtigt
        assertEquals(NAME, dummy.getName(),"Expect Dummy to have name: "+ NAME +". dummy has name: "+dummy.getName());
        //Tester at Type på chance er rigtigt
        assertEquals(ID, dummy.getID(),"Expect dummy to have ID: "+ ID +". dummy has ID as: "+ dummy.getID());

    }

    @Test
    void testLabelAndType() {
        final String LABEL = "Du er landet på Jigsaw.";
        final String TYPE = "dummy";
        Board board = new Board();

        Dummy dummy = new Dummy(2,"Jigsaw");
        DummyField dummyField = new DummyField(dummy);

        //Tester at label på Chance er rigtigt
        assertEquals(LABEL, dummyField.landedLabel(),"Expect dummyField to have label: "+ LABEL +". dummyField has label: "+dummyField.landedLabel());
        //Tester at Type på chance er rigtigt
        assertEquals(TYPE, dummyField.type(),"Expect dummyField to have type: "+ TYPE +". dummyField has type as: "+ dummyField.type());

    }

}