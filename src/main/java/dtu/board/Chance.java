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

    public String[] drawCard(int index){
        cardIndex++;
        if(cardIndex >= chanceCardDeck.getDeck().size()){
            cardIndex = 0;
        }

        return chanceCardDeck.getDeck().get(index);
    }

    public ChanceCardDeck getChanceCardDeck() {
        return chanceCardDeck;
    }
}
