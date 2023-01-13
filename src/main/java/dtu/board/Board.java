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
            else if(fieldText.get(i)[2].equals("ferry")){
                currentBoard[i-1] = new FerryField(new Ferry(Integer.parseInt(fieldText.get(i)[1]),fieldText.get(i)[0],Integer.parseInt(fieldText.get(i)[3]),
                        Integer.parseInt(fieldText.get(i)[4]),Integer.parseInt(fieldText.get(i)[6]),Integer.parseInt(fieldText.get(i)[7]),Integer.parseInt(fieldText.get(i)[8]),
                                Integer.parseInt(fieldText.get(i)[9])));
            }

            else if(fieldText.get(i)[2].equals("brewery")){
                currentBoard[i-1] = new BreweryField( new Brewery(Integer.parseInt(fieldText.get(i)[1]),(fieldText.get(i)[0]),
                        Integer.parseInt(fieldText.get(i)[3]), Integer.parseInt(fieldText.get(i)[4]),
                        Integer.parseInt(fieldText.get(i)[5]),Integer.parseInt(fieldText.get(i)[6])));
            }

            else if(fieldText.get(i)[2].equals("start")||fieldText.get(i)[2].equals("jailvisit")||fieldText.get(i)[2].equals("parking")){
                currentBoard[i-1] = new DummyField(new Dummy(Integer.parseInt(fieldText.get(i)[1]),fieldText.get(i)[0]));
            }
            else if(fieldText.get(i)[2].equals("tax")){
                currentBoard[i-1] = new TaxField(new Tax(Integer.parseInt(fieldText.get(i)[1]),fieldText.get(i)[0],Integer.parseInt(fieldText.get(i)[4])));
            }
            else if(fieldText.get(i)[2].equals("chance")){
                currentBoard[i-1] = new Chance();
            }
            else if(fieldText.get(i)[2].equals("jail")){
                currentBoard[i-1] = new GoPrisonField();
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
