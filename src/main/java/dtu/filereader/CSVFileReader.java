package dtu.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;


public class CSVFileReader {

    private ArrayList<String[]> chancecarddesc;
    private ArrayList<String[]> fieldinfo;
    public CSVFileReader() {
        chancecarddesc = readCSV("src/main/java/dtu/chancecard/chancecarddesc.csv", ";");
        fieldinfo = readCSV( "src/main/java/dtu/board/fields.csv", ";");
    }

    /**
     * readColon takes the data from fileReader + and handles data, split the data and adds all the data into an ArrayList colData.
     * @param filepath
     * @param delimiter
     * @return
     */
    public ArrayList<String[]> readCSV(String filepath, String delimiter) {
        String[] data;
        String currentLine;
        ArrayList<String[]> colData = new ArrayList<>();

        try
        {
            FileReader read = new FileReader(filepath);
            BufferedReader bread = new BufferedReader(read);
            while((currentLine = bread.readLine()) != null)
            {
                data = currentLine.split(delimiter);
                colData.add(data);
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return colData;
    }

    public ArrayList<String[]> getChancecarddesc() {
        return chancecarddesc;
    }

    public ArrayList<String[]> getFieldinfo() {
        return fieldinfo;
    }
}
