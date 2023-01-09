package dtu.board;

import dtu.filereader.CSVFileReader;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private Field[] currentBoard;
    private CSVFileReader csvFileReader = new CSVFileReader();

    private static Property[] familie1 = new Property[2];
    int f1 = 0;
    private static Property[] familie2 = new Property[3];
    int f2 = 0;
    private static Property[] familie3 = new Property[3];
    int f3 = 0;
    private static Property[] familie4 = new Property[3];
    int f4 = 0;
    private static Property[] familie5 = new Property[3];
    int f5 = 0;
    private static Property[] familie6 = new Property[3];
    int f6 = 0;
    private static Property[] familie7 = new Property[3];
    int f7 = 0;
    private static Property[] familie8 = new Property[2];
    int f8 = 0;


    public Board(){
        currentBoard = new Field[40];

        ArrayList<String[]> fieldText = csvFileReader.getFieldinfo();

        for(int i = 1; i < fieldText.size(); i++){
            if(fieldText.get(i)[2].equals("street")){

                currentBoard[i-1] = new FieldProperty(new Property(Integer.parseInt(fieldText.get(i)[1]),Integer.parseInt(fieldText.get(i)[3]),
                            fieldText.get(i)[0],Integer.parseInt(fieldText.get(i)[4]),Integer.parseInt(fieldText.get(i)[5]),Integer.parseInt(fieldText.get(i)[6]),
                            Integer.parseInt(fieldText.get(i)[7]),Integer.parseInt(fieldText.get(i)[8]), Integer.parseInt(fieldText.get(i)[9]),
                            Integer.parseInt(fieldText.get(i)[10]),Integer.parseInt(fieldText.get(i)[11]), 0));

                //Udedigere street til deres familie
                switch(Integer.parseInt(fieldText.get(i)[3])){
                    case 1:
                        familie1[f1] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f1++;
                        break;
                    case 2:
                        familie2[f2] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f2++;
                        break;
                    case 3:
                        familie3[f3] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f3++;
                        break;
                    case 4:
                        familie4[f4] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f4++;
                        break;
                    case 5:
                        familie5[f5] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f5++;
                        break;
                    case 6:
                        familie6[f6] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f6++;
                        break;
                    case 7:
                        familie7[f7] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f7++;
                        break;
                    case 8:
                        familie8[f8] = (((FieldProperty)currentBoard[i-1]).getProperty());
                        f8++;
                        break;
                }
            }
            else if(fieldText.get(i)[2].equals("ferry")){
                currentBoard[i-1] = new FerryField(new Ferry(Integer.parseInt(fieldText.get(i)[1]),fieldText.get(i)[0],Integer.parseInt(fieldText.get(i)[3]),
                        Integer.parseInt(fieldText.get(i)[4]),Integer.parseInt(fieldText.get(i)[6]),Integer.parseInt(fieldText.get(i)[7]),Integer.parseInt(fieldText.get(i)[8]),
                                Integer.parseInt(fieldText.get(i)[9])));
            }
            else if(fieldText.get(i)[2].equals("start")||fieldText.get(i)[2].equals("jailvisit")||fieldText.get(i)[2].equals("parking")){
                currentBoard[i-1] = new DummyField(new Dummy(Integer.parseInt(fieldText.get(i)[1]),fieldText.get(i)[0]));
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

    //Metode til at skaffe familie
    public static Property[] getFamilieList(int familieNum){
        Property[] send = new Property[0];
        switch (familieNum) {
            case 1:
                send = familie1;
                break;
            case 2:
                send = familie2;
                break;
            case 3:
                send = familie3;
                break;
            case 4:
                send = familie4;
                break;
            case 5:
                send = familie5;
                break;
            case 6:
                send = familie6;
                break;
            case 7:
                send = familie7;
                break;
            case 8:
                send = familie8;
                break;
        }
        return send;
    }
}
