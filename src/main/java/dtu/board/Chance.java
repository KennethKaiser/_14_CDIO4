package dtu.board;

import dtu.chancecard.ChanceCardDeck;

public class Chance extends Field{

    private ChanceCardDeck chanceCardDeck = new ChanceCardDeck();

    private int cardIndex = -1;

    @Override
    public String landedLabel() {
        return "Du er landet på prøv lykken";
    }

    @Override
    public String type() {
        return "chance";
    }

    public String drawCard(){
        cardIndex++;
        if(cardIndex == chanceCardDeck.getDeck().length){
            chanceCardDeck.shuffle();
            cardIndex = 0;
        }

        return chanceCardDeck.getDeck()[cardIndex];
    }

    public ChanceCardDeck getChanceCardDeck() {
        return chanceCardDeck;
    }
}
