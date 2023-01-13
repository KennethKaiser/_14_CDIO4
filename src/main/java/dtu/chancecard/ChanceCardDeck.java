package dtu.chancecard;

import dtu.filereader.CSVFileReader;

import java.util.*;

public class ChanceCardDeck {

    private ArrayList<String[]> deck;

    private CSVFileReader csvFileReader = new CSVFileReader();


    public ChanceCardDeck(){

        ArrayList<String[]> deck = new ArrayList<>();

        for(int i = 0; i < csvFileReader.getChancecarddesc().size(); i++){
            deck.add(csvFileReader.getChancecarddesc().get(i));
        }

        //Shuffle Deck
        this.deck = deck;

        //shuffle();

    }

    public void shuffle(){

        Collections.shuffle(deck);


    }

    public ArrayList<String[]> getDeck() {
        return deck;
    }



}
