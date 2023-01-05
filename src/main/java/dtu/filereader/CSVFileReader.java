package dtu.filereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class CSVFileReader {

    private String[] chancecarddesc;
    private String[] fieldinfo;
    public CSVFileReader() {
        chancecarddesc = readCSV(1,"dtu/chancecard/chancecarddesc.csv", ";");
        fieldinfo = readCSV(1, "test", ";");
    }
    /**
     * fileReader loads in a CSV file on a certain colon (para 1), and splits at delimiter (para 3) in the array data, and saves and returns the value.
     * @param colon
     * @return
     */

    /*public String[] readCSV(int colon, String URL, String delimiter){
        String[] data = readColon(colon,URL, delimiter);
        return data;
    }
     */


    /**
     * readColon takes the data from fileReader + and handles data, split the data and adds all the data into an ArrayList colData.
     * @param colon
     * @param filepath
     * @param delimiter
     * @return
     */
    public static String[] readCSV(int colon, String filepath, String delimiter) {
        String data[];
        String currentLine;
        ArrayList<String> colData = new ArrayList<>();

        try
        {
            FileReader read = new FileReader(filepath);
            BufferedReader bread = new BufferedReader(read);
            while((currentLine = bread.readLine()) != null)
            {
                data = currentLine.split(delimiter);
                colData.add(data[colon]);
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return colData.toArray(new String[0]);
    }

    public String[] getChancecarddesc() {
        return chancecarddesc;
    }

    public String[] getFieldinfo() {
        return fieldinfo;
    }
}
