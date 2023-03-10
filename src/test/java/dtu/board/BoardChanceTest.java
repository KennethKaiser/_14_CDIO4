package dtu.board;

import dtu.chancecard.ChanceCardDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardChanceTest {

    @Test
    void LabelAndType() {
       final String LABEL = "Du er landet på prøv lykken";
       final String TYPE = "chance";

       Chance chance = new Chance();

       //Tester at label på Chance er rigtigt
        assertEquals(LABEL, chance.landedLabel(),"Expect Chance to have label: "+ LABEL +". Chance has label: "+chance.landedLabel());
        //Tester at Type på chance er rigtigt
        assertEquals(TYPE, chance.type(),"Expect chance to have type: "+ TYPE +". Chance has type as: "+ chance.type());

    }

    @Test
    void DrawCard() {
        String card;
        ChanceCardDeck chanceCardDeck = new ChanceCardDeck();
        Chance chance = new Chance();
        card = chance.getChanceCardDeck().getDeck().get(0)[1];

        //Tester at kortet der trækkes er det første i bunken
        assertEquals(card, chance.drawCard()[1],"Expect Chance to draw card: "+ card +". Chance draws card: "+chance.drawCard());
    }

}