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

    public Field getField(int number){
        return currentBoard[number];
    }

    //En række arrays som sætter properties i familier
    public FieldProperty[] familie1 = {(FieldProperty) currentBoard[1],(FieldProperty) currentBoard[3]};

    private FieldProperty[] getFamilie1() {
        return familie1;
    }

    public FieldProperty[] familie2 = {(FieldProperty) currentBoard[5],(FieldProperty) currentBoard[6],(FieldProperty) currentBoard[8]};
    private FieldProperty[] getFamilie2() {
        return familie2;
    }
    public FieldProperty[] familie3 = {(FieldProperty) currentBoard[9],(FieldProperty) currentBoard[11],(FieldProperty) currentBoard[13]};
    private FieldProperty[] getFamilie3() {
        return familie3;
    }
    public FieldProperty[] familie4 = {(FieldProperty) currentBoard[14],(FieldProperty) currentBoard[16],(FieldProperty) currentBoard[18]};
    private FieldProperty[] getFamilie4() {
        return familie4;
    }
    public FieldProperty[] familie5 = {(FieldProperty) currentBoard[19],(FieldProperty) currentBoard[21],(FieldProperty) currentBoard[23]};
    private FieldProperty[] getFamilie5() {
        return familie5;
    }
    public FieldProperty[] familie6 = {(FieldProperty) currentBoard[24],(FieldProperty) currentBoard[26],(FieldProperty) currentBoard[27]};
    private FieldProperty[] getFamilie6() {
        return familie6;
    }
    public FieldProperty[] familie7 = {(FieldProperty) currentBoard[29],(FieldProperty) currentBoard[31],(FieldProperty) currentBoard[32]};
    private FieldProperty[] getFamilie7() {
        return familie7;
    }
    private static FieldProperty[] familie8 = {(FieldProperty) currentBoard[34],(FieldProperty) currentBoard[37]};
    private static FieldProperty[] getFamilie8() {
        return familie8;
    }

    //Spørg efter familie metode
    public FieldProperty[] getFamilieList(int familieNum){
        FieldProperty[] send = new FieldProperty[0];
        switch (familieNum) {
            case 1:
                send = getFamilie1();
                break;
            case 2:
                send = getFamilie2();
                break;
            case 3:
                send = getFamilie3();
                break;
            case 4:
                send = getFamilie4();
                break;
            case 5:
                send = getFamilie5();
                break;
            case 6:
                send = getFamilie6();
                break;
            case 7:
                send = getFamilie7();
                break;
            case 8:
                send = getFamilie8();
                break;
        }
        return send;
    }

    /**
     * Method to see if a player owns all properties in a fimilie
     * @param property Just one of the properties in question
     * @return True means a player owns all properties in the familie
     */
    public Boolean getPermit(Property property) {
        Boolean answer = null;
        switch (property.getFamilie()) {
            case 1:
                if (getFamilieList(1)[0].getOwner() == getFamilieList(1)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 2:
                if (getFamilieList(2)[0].getOwner() == getFamilieList(2)[1].getOwner() && getFamilieList(2)[0].getOwner() == getFamilieList(2)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 3:
                if (getFamilieList(3)[0].getOwner() == getFamilieList(3)[1].getOwner() && getFamilieList(3)[0].getOwner() == getFamilieList(3)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 4:
                if (getFamilieList(4)[0].getOwner() == getFamilieList(4)[1].getOwner() && getFamilieList(4)[0].getOwner() == getFamilieList(4)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 5:
                if (getFamilieList(5)[0].getOwner() == getFamilieList(5)[1].getOwner() && getFamilieList(5)[0].getOwner() == getFamilieList(5)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 6:
                if (getFamilieList(6)[0].getOwner() == getFamilieList(6)[1].getOwner() && getFamilieList(6)[0].getOwner() == getFamilieList(6)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 7:
                if (getFamilieList(7)[0].getOwner() == getFamilieList(7)[1].getOwner() && getFamilieList(7)[0].getOwner() == getFamilieList(7)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 8:
                if (getFamilieList(8)[0].getOwner() == getFamilieList(8)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
        }
        return answer;
    }

}
