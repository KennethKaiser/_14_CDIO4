package dtu.board;

public class PropertyList {

    final int NUMBER_PROPERTIES = 22;
    Property[] listOfProperties = new Property[NUMBER_PROPERTIES];

    //Pledge/pantsætning er valgt til at være 50% pris
    //Her er en liste med properties
    //Familie 1
    Property Rødovrevej = new Property(0,1,"Rødeovrevej",1200,1000,50,250,750,2250,4000,6000,600);
    FieldProperty fieldRødovrevej = new FieldProperty(Rødovrevej);

    Property Hvidovrevej = new Property(2,1,"Hvidovrevej",1200,1000,50,250,400,750,2250,6000,600);
    FieldProperty fieldHvidovrevej = new FieldProperty(Hvidovrevej);
    //Familie 2
    Property Roskildevej = new Property(5,2,"Roskildevej",2000,1000,100,600,1800,5400,8000,11000,1000);
    FieldProperty fieldRoskildevej = new FieldProperty(Roskildevej);

    Property ValbyLanggade = new Property(7,2,"Valby Langgade",2000,1000,100,600,1800,5400,8000,11000,1000);
    FieldProperty fieldValbyLanggade = new FieldProperty(ValbyLanggade);

    Property Allegade = new Property(8,2,"Allégade",2400,1000,150,800,2000,6000,9000,12000,1200);
    FieldProperty fieldAllegade = new FieldProperty(Allegade);
    //Familie 3
    Property Frederiksberg = new Property(10,3,"Frederiksberg Allé",2800,2000,200,1000,3000,9000,12500,15000,1400);
    FieldProperty fieldFrederiksberg = new FieldProperty(Frederiksberg);

    Property Bullowsvej = new Property(12,3,"Büllowsvej",2800,2000,200,1000,3000,9000,12500,15000,1400);
    FieldProperty fieldBullowsvej = new FieldProperty(Bullowsvej);

    Property GlKongevej = new Property(13,3,"Gl. Kongevej",3200,2000,250,1250,3750,10000,14000,18000,1600);
    FieldProperty fieldGlKongevej = new FieldProperty(GlKongevej);
    //Familie 4
    Property Bernstoffsvej = new Property(15,4,"Bernstoffsvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
    FieldProperty fieldBernstoffvej = new FieldProperty(Bernstoffsvej);

    Property Hellerupvej = new Property(17,4,"Hellerupvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
    FieldProperty fieldHellerupvej = new FieldProperty(Hellerupvej);

    Property Strandvejen = new Property(18,4,"Strandvejen",4000,2000,350,1600,4400,12000,16000,20000,2000);
    FieldProperty FieldStrandvejen = new FieldProperty(Strandvejen);
    //Familie 5
    Property Trianglen = new Property(20,5,"Trianglen",4400,3000,350,1800,5000,14000,17500,21000,2200);
    FieldProperty fieldTrianglen = new FieldProperty(Trianglen);

    Property Østerbrogade = new Property(22,5,"Østerbrogade",4400,3000,350,1800,5000,14000,17500,21000,2200);
    FieldProperty FieldØsterbrogade = new FieldProperty(Østerbrogade);

    Property Grønningen = new Property(23,5,"Grønningen",4800,3000,400,2000,6000,15000,18500,22000,2400);
    FieldProperty fieldGrønningen = new FieldProperty(Grønningen);
    //Familie 6
    Property Bredgade = new Property(25,6,"Bredgade",5200,3000,450,2200,6600,16000,19500,23000,2600);
    FieldProperty fieldBredgade = new FieldProperty(Bredgade);

    Property KgsNytorv = new Property(26,6,"Kgs. Nytorv",5200,3000,450,2200,6600,16000,19500,23000,2600);
    FieldProperty fieldKgsNytov = new FieldProperty(KgsNytorv);

    Property Østergade = new Property(28,6,"Østergade",5600,3000,500,2400,7200,17000,20500,24000,2800);
    FieldProperty fieldØstergade = new FieldProperty(Østergade);
    //Familie 7
    Property Amagertorv = new Property(30,7,"Amagertorv",6000,4000,550,2600,7800,18000,22000,25000,3000);
    FieldProperty fieldAmagertorv = new FieldProperty(Amagertorv);

    Property Vimmelskaftet = new Property(31,7,"Vimmelskaftet",6000,4000,550,2600,7800,18000,22000,25000,3000);
    FieldProperty fieldVimmelskaftet = new FieldProperty(Vimmelskaftet);

    Property Nygade = new Property(33,7,"Nygade",6400,4000,600,3000,9000,20000,24000,28000,3200);
    FieldProperty fieldNygade = new FieldProperty(Nygade);
    //Familie 8
    Property Frederiksberggade = new Property(36,8,"Frederiksberggade",7000,4000,700,3500,10000,22000,26000,30000,3500);
    FieldProperty fieldFrederiksberggade = new FieldProperty(Frederiksberggade);

    Property Rådhuspladsen = new Property(38,8,"Rådhuspladsen",8000,4000,1000,4000,12000,28000,34000,40000,4000);
    FieldProperty fieldRådhuspladsen = new FieldProperty(Rådhuspladsen);
}

