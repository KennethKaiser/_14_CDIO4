package dtu.chancecard;

import dtu.filereader.CSVFileReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ChanceCardDeck {

    private String[] deck;

    private CSVFileReader csvFileReader = new CSVFileReader();


    public ChanceCardDeck(){

        String[] deck = new String[csvFileReader.getChancecarddesc().size()];

        for(int i = 0; i < deck.length; i++){
            deck[i] = csvFileReader.getChancecarddesc().get(i)[0];
        }

        //Shuffle Deck
        this.deck = deck;

        shuffle();

    }

    public void shuffle(){

        Random random = new Random();

        for(int i = 0; i < deck.length; i++){
            int swapIndex = random.nextInt(deck.length);
            String temp = deck[swapIndex];
            deck[swapIndex] = deck[i];
            deck[i] = temp;
        }


    }

    public String[] getDeck() {
        return deck;
    }



}
