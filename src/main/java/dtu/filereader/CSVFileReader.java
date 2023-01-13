package dtu.filereader;

import java.io.*;
import java.util.ArrayList;

public class CSVFileReader {

    private ArrayList<String[]> chancecarddesc;
    private ArrayList<String[]> fieldinfo;
    private ArrayList<String[]> saveData;
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
        {   FileReader read = new FileReader(filepath);

              BufferedReader bRead = new BufferedReader(read);
            while((currentLine = bRead.readLine()) != null)
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
    public ArrayList<String[]> getSavedGame(String name){
        ArrayList<String[]> allData = readCSV("src/main/java/dtu/SaveAndLoad/savedGames.csv", ";");
        ArrayList<String[]> saveData = null;
        for(int i = 0; i < allData.size(); i++){
            if(allData.get(i)[0].equals("NEXT_LOAD")){
                if(allData.get(i)[1].equals(name)){
                    saveData = new ArrayList<>();
                    for(int n = i+1; n < allData.size(); n++){
                        if(allData.get(n)[0].equals("NEXT_LOAD")){
                            break;
                        }
                        else if(allData.get(n)[0].equals("END")){
                            break;
                        }
                        else{
                            saveData.add(allData.get(n));
                        }
                    }
                    break;
                }
            }
        }
        if(saveData == null) {
            return null;
        }
        else return saveData;



    }
    public void saveGame(ArrayList<String[]> newSaveData, String name){
        try{
            ArrayList<String[]> allData = readCSV("src/main/java/dtu/SaveAndLoad/savedGames.csv", ";");
            FileWriter writer = new FileWriter("src/main/java/dtu/SaveAndLoad/savedGames.csv");
            BufferedWriter bw = new BufferedWriter(writer);
            boolean foundName = false;
            for(int i = 0; i < allData.size(); i++){ //Deletes Current Version
                if(allData.get(i)[0].equals("NEXT_LOAD")){
                    if(allData.get(i)[1].equals(name)){
                        allData.remove(i);
                        foundName = true;
                        for(int n = i; n < allData.size(); n++){
                            if(allData.get(n)[0].equals("NEXT_LOAD")){
                                break;
                            }
                            else if(allData.get(n)[0].equals("END")){
                                break;
                            }
                            else{
                                allData.remove(n);
                                n--;
                            }
                        }
                        break;
                    }
                }
            }//Deletes Current Version
            if(allData.size()>0) allData.remove(allData.size()-1);
            for(int i = 0; i < allData.size(); i++){ //Writes old data
                String line = "";
                for(int n = 0; n < allData.get(i).length; n++){
                    line += allData.get(i)[n] + ";";
                }
                bw.write(line);
                bw.newLine();
            } //Writes old data
            bw.write("NEXT_LOAD;" + name + ";"); //Starts new Save data
            bw.newLine();
            for(int i = 0; i < newSaveData.size(); i++){ //Writes new Save data
                String line = "";
                for(int n = 0; n < newSaveData.get(i).length; n++){
                    line += newSaveData.get(i)[n] + ";";
                }
                bw.write(line);
                bw.newLine();
            }
            bw.write("END");
            bw.newLine();
            bw.close();
        } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex2) {
        ex2.printStackTrace();
    }
    }
    public ArrayList<String> getSaves(){
        ArrayList<String[]> allData = readCSV("src/main/java/dtu/SaveAndLoad/savedGames.csv", ";");
        ArrayList<String> names = null;
        for(int i = 0; i < allData.size(); i++){ //Saves names
            if(allData.get(i)[0].equals("NEXT_LOAD")){
                if(names == null) names = new ArrayList<>();
                names.add(allData.get(i)[1]);
            }
        }
        return names;
    }
    public boolean deleteSave(String name){

        ArrayList<String[]> allData = readCSV("src/main/java/dtu/SaveAndLoad/savedGames.csv", ";");
        boolean found = false;
        for(int i = 0; i < allData.size(); i++){ //Deletes Current Version
            if(allData.get(i)[0].equals("NEXT_LOAD")){
                if(allData.get(i)[1].equals(name)){
                    allData.remove(i);
                    found = true;
                    for(int n = i; n < allData.size(); n++){
                        if(allData.get(n)[0].equals("NEXT_LOAD")){
                            break;
                        }
                        else if(allData.get(n)[0].equals("END")){
                            allData.remove(n);
                            break;
                        }
                        else{
                            allData.remove(n);
                            n--;
                        }
                    }
                    break;
                }
            }
        }//Deletes Current Version
        try{
            FileWriter writer = new FileWriter("src/main/java/dtu/SaveAndLoad/savedGames.csv");
            BufferedWriter bw = new BufferedWriter(writer);


            for(int i = 0; i < allData.size(); i++){ //Writes new Save data
                String line = "";
                for(int n = 0; n < allData.get(i).length; n++){
                    line += allData.get(i)[n] + ";";
                }
                bw.write(line);
                bw.newLine();
            }
            bw.close();

        } catch (FileNotFoundException ex) {
        ex.printStackTrace();
        } catch (IOException ex2) {
        ex2.printStackTrace();
        }

        return found;
    }
    public ArrayList<String[]> getChancecarddesc() {
        return chancecarddesc;
    }

    public ArrayList<String[]> getFieldinfo() {
        return fieldinfo;
    }
}
