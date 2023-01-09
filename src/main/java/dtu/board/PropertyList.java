package dtu.board;

import dtu.filereader.CSVFileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PropertyList {

    final int NUMBER_PROPERTIES = 22;

    //Making field with csv
    public void instantiateFieldsCSV(){

        /*
        List<Field> fields;
        Field[] field = new Field[40];
        CSVFileReader csvFileReader = new CSVFileReader();
        String[] liste = csvFileReader.toString();
         */

//Eksperiment fra google

        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("fields.csv"));
        while ((line = br.readLine()) != null)   //Sikrer der er noget at læse
        {
            String[] fieldLine = line.split(splitBy);    // Komma seperering
            if (fieldLine[1] == "Street") {
                 i = 0;
                Property i = new Property(Integer.valueOf(fieldLine[0]), fieldLine[1], Integer.valueOf(fieldLine[2]), fieldLine[3], Integer.valueOf(fieldLine[4]), Integer.valueOf(fieldLine[5]), Integer.valueOf(fieldLine[6]), Integer.valueOf(fieldLine[7]), Integer.valueOf(fieldLine[8]), Integer.valueOf(fieldLine[9]), Integer.valueOf(fieldLine[10]), Integer.valueOf(fieldLine[11]), Integer.valueOf(fieldLine[12]));
                FieldProperty fieldProperty = new FieldProperty(i);
                i++;
            }
        }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }






    //Gammel
            String[] employee = line.split(splitBy);    // use comma as separator
            System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
        }

        for (int i = 0; i < field.length; i++){
            field[i] = new Field(i, liste[i],);
        }
        for (int i = 0; i<12;i++){
            Property csvFileReader

        }
        Property Bernstoffsvej = new Property(15,"Street",4,"Bernstoffsvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
        FieldProperty fieldBernstoffvej = new FieldProperty(Bernstoffsvej);
    }


    //Pledge/pantsætning er valgt til at være 50% pris
    //Her er en liste med properties
    //Familie 1
    static Property Rødovrevej = new Property(0,"Street",1,"Rødeovrevej",1200,1000,50,250,750,2250,4000,6000,600);
    FieldProperty fieldRødovrevej = new FieldProperty(Rødovrevej);
    public static Property getRødovrevej(){return Rødovrevej;}

    static Property Hvidovrevej = new Property(2,"Street",1,"Hvidovrevej",1200,1000,50,250,400,750,2250,6000,600);
    FieldProperty fieldHvidovrevej = new FieldProperty(Hvidovrevej);
    public static Property getHvidovrevej(){return Hvidovrevej;}
    //Familie 2
    static Property Roskildevej = new Property(5,"Street",2,"Roskildevej",2000,1000,100,600,1800,5400,8000,11000,1000);
    FieldProperty fieldRoskildevej = new FieldProperty(Roskildevej);
    public static Property getRoskildevej(){return Roskildevej;}

    static Property ValbyLanggade = new Property(7,"Street",2,"Valby Langgade",2000,1000,100,600,1800,5400,8000,11000,1000);
    FieldProperty fieldValbyLanggade = new FieldProperty(ValbyLanggade);
    public static Property getValbyLanggade(){return ValbyLanggade;}

    static Property Allegade = new Property(8,"Street",2,"Allégade",2400,1000,150,800,2000,6000,9000,12000,1200);
    FieldProperty fieldAllegade = new FieldProperty(Allegade);
    public static Property getAllegade(){return Allegade;}
    //Familie 3
    static Property Frederiksberg = new Property(10,"Street",3,"Frederiksberg Allé",2800,2000,200,1000,3000,9000,12500,15000,1400);
    FieldProperty fieldFrederiksberg = new FieldProperty(Frederiksberg);
    public static Property getFrederiksberg(){return Frederiksberg;}

    static Property Bullowsvej = new Property(12,"Street",3,"Büllowsvej",2800,2000,200,1000,3000,9000,12500,15000,1400);
    FieldProperty fieldBullowsvej = new FieldProperty(Bullowsvej);
    public static Property getBullowsvej(){return Bullowsvej;}

    static Property GlKongevej = new Property(13,"Street",3,"Gl. Kongevej",3200,2000,250,1250,3750,10000,14000,18000,1600);
    FieldProperty fieldGlKongevej = new FieldProperty(GlKongevej);
    public static Property getGlKongevej(){return GlKongevej;}
    //Familie 4
    static Property Bernstoffsvej = new Property(15,"Street",4,"Bernstoffsvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
    FieldProperty fieldBernstoffvej = new FieldProperty(Bernstoffsvej);
    public static Property getBernstoffsvej(){return Bernstoffsvej;}

    static Property Hellerupvej = new Property(17,"Street",4,"Hellerupvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
    FieldProperty fieldHellerupvej = new FieldProperty(Hellerupvej);
    public static Property getHellerupvej(){return Hellerupvej;}

    static Property Strandvejen = new Property(18,"Street",4,"Strandvejen",4000,2000,350,1600,4400,12000,16000,20000,2000);
    FieldProperty FieldStrandvejen = new FieldProperty(Strandvejen);
    public static Property getStrandvejen(){return Strandvejen;}

    //Familie 5
    static Property Trianglen = new Property(20,"Street",5,"Trianglen",4400,3000,350,1800,5000,14000,17500,21000,2200);
    FieldProperty fieldTrianglen = new FieldProperty(Trianglen);
    public static Property getTrianglen(){return Trianglen;}


    static Property Østerbrogade = new Property(22,"Street",5,"Østerbrogade",4400,3000,350,1800,5000,14000,17500,21000,2200);
    FieldProperty FieldØsterbrogade = new FieldProperty(Østerbrogade);
    public static Property getØsterbrogade(){return Østerbrogade;}


    static Property Grønningen = new Property(23,"Street",5,"Grønningen",4800,3000,400,2000,6000,15000,18500,22000,2400);
    FieldProperty fieldGrønningen = new FieldProperty(Grønningen);
    public static Property getGrønningen(){return Grønningen;}

    //Familie 6
    static Property Bredgade = new Property(25,"Street",6,"Bredgade",5200,3000,450,2200,6600,16000,19500,23000,2600);
    FieldProperty fieldBredgade = new FieldProperty(Bredgade);
    public static Property getBredgade(){return Bredgade;}


    static Property KgsNytorv = new Property(26,"Street",6,"Kgs. Nytorv",5200,3000,450,2200,6600,16000,19500,23000,2600);
    FieldProperty fieldKgsNytov = new FieldProperty(KgsNytorv);
    public static Property getKgsNytorv(){return KgsNytorv;}


    static Property Østergade = new Property(28,"Street",6,"Østergade",5600,3000,500,2400,7200,17000,20500,24000,2800);
    FieldProperty fieldØstergade = new FieldProperty(Østergade);
    public static Property getØstergade(){return Østergade;}

    //Familie 7
    static Property Amagertorv = new Property(30,"Street",7,"Amagertorv",6000,4000,550,2600,7800,18000,22000,25000,3000);
    FieldProperty fieldAmagertorv = new FieldProperty(Amagertorv);
    public static Property getAmagertorv(){return Amagertorv;}


    static Property Vimmelskaftet = new Property(31,"Street",7,"Vimmelskaftet",6000,4000,550,2600,7800,18000,22000,25000,3000);
    FieldProperty fieldVimmelskaftet = new FieldProperty(Vimmelskaftet);
    public static Property getVimmelskaftet(){return Vimmelskaftet;}


    static Property Nygade = new Property(33,"Street",7,"Nygade",6400,4000,600,3000,9000,20000,24000,28000,3200);
    FieldProperty fieldNygade = new FieldProperty(Nygade);
    public static Property getNygade(){return Nygade;}

    //Familie 8
    static Property Frederiksberggade = new Property(36,"Street",8,"Frederiksberggade",7000,4000,700,3500,10000,22000,26000,30000,3500);
    FieldProperty fieldFrederiksberggade = new FieldProperty(Frederiksberggade);
    public static Property getFrederiksberggade(){return Frederiksberggade;}


    static Property Rådhuspladsen = new Property(38,"Street",8,"Rådhuspladsen",8000,4000,1000,4000,12000,28000,34000,40000,4000);
    FieldProperty fieldRådhuspladsen = new FieldProperty(Rådhuspladsen);
    public static Property getRådhuspladsen(){return Rådhuspladsen;}


    //En række arrays som sætter properties i familier
    private static Property[] familie1 = {Rødovrevej,Hvidovrevej};
    private static Property[] familie2 = {Roskildevej, ValbyLanggade, Allegade};
    private static Property[] familie3 = {Frederiksberg, Bullowsvej, GlKongevej};
    private static Property[] familie4 = {Bernstoffsvej, Hellerupvej, Strandvejen};
    private static Property[] familie5 = {Trianglen, Østerbrogade, Grønningen};
    private static Property[] familie6 = {Bredgade, KgsNytorv, Østergade};
    private static Property[] familie7 = {Amagertorv, Vimmelskaftet, Nygade};
    private static Property[] familie8 = {Frederiksberggade, Rådhuspladsen};

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

    /**
     * Method to see if a player owns all properties in a fimilie
     * @param property Just one of the properties in question
     * @return True means a player owns all properties in the familie
     */
    public static Boolean getPermit(Property property) {
        Boolean answer = null;
        switch (property.getFamilie()) {
            case 1:
                if (PropertyList.getFamilieList(1)[0].getOwner() == PropertyList.getFamilieList(1)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 2:
                if (PropertyList.getFamilieList(2)[0].getOwner() == PropertyList.getFamilieList(2)[1].getOwner() && PropertyList.getFamilieList(2)[0].getOwner() == PropertyList.getFamilieList(2)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 3:
                if (PropertyList.getFamilieList(3)[0].getOwner() == PropertyList.getFamilieList(3)[1].getOwner() && PropertyList.getFamilieList(3)[0].getOwner() == PropertyList.getFamilieList(3)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 4:
                if (PropertyList.getFamilieList(4)[0].getOwner() == PropertyList.getFamilieList(4)[1].getOwner() && PropertyList.getFamilieList(4)[0].getOwner() == PropertyList.getFamilieList(4)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 5:
                if (PropertyList.getFamilieList(5)[0].getOwner() == PropertyList.getFamilieList(5)[1].getOwner() && PropertyList.getFamilieList(5)[0].getOwner() == PropertyList.getFamilieList(5)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 6:
                if (PropertyList.getFamilieList(6)[0].getOwner() == PropertyList.getFamilieList(6)[1].getOwner() && PropertyList.getFamilieList(6)[0].getOwner() == PropertyList.getFamilieList(6)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 7:
                if (PropertyList.getFamilieList(7)[0].getOwner() == PropertyList.getFamilieList(7)[1].getOwner() && PropertyList.getFamilieList(7)[0].getOwner() == PropertyList.getFamilieList(7)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 8:
                if (PropertyList.getFamilieList(8)[0].getOwner() == PropertyList.getFamilieList(8)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
        }
        return answer;
    }

}

