package dtu.chancecard;

import dtu.filereader.CSVFileReader;

import java.io.FileReader;

public class ChanceCardHandler {

    public void readCSVChanceCard(){
        CSVFileReader.readColon(1, "src/main/java/dtu/chancecard/chancecarddesc.csv", ";");
    }
    public void shuffleCards(){

    }

    public void deckCreator(){

    }
}
