package dtu.board;

import dtu.filereader.CSVFileReader;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private Field[] currentBoard;
    private CSVFileReader csvFileReader = new CSVFileReader();





    public Board(){

        currentBoard = new Field[40];

        ArrayList<String[]> fieldText = csvFileReader.getFieldinfo();

        for(int i = 1; i < fieldText.size(); i++){
            if(fieldText.get(i)[2].equals("street")){

                currentBoard[i-1] = new FieldProperty(new Property(Integer.parseInt(fieldText.get(i)[1]),Integer.parseInt(fieldText.get(i)[3]),
                            fieldText.get(i)[0],Integer.parseInt(fieldText.get(i)[4]),Integer.parseInt(fieldText.get(i)[5]),Integer.parseInt(fieldText.get(i)[6]),
                            Integer.parseInt(fieldText.get(i)[7]),Integer.parseInt(fieldText.get(i)[8]), Integer.parseInt(fieldText.get(i)[9]),
                            Integer.parseInt(fieldText.get(i)[10]),Integer.parseInt(fieldText.get(i)[11]), 0));

            }
        }



        //Needs more
    }

    public Field[] getCurrentBoard() {
        return currentBoard;
    }

    @Override
    public String toString() {
        return "Board{" +
                "currentBoard=" + Arrays.toString(currentBoard) +
                '}';
    }
}
