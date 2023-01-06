package dtu.board;

import dtu.filereader.CSVFileReader;
import dtu.players.Player;

import java.util.List;

public class Property {

   private int ID;//ID er hvilket felt på boardet de står ved Rødovrevej starter som 0.
    private String name;
    private int price;
    private int housePrice;
    private int rentNormal, rent1House, rent2House, rent3House, rent4House, rentHotel;
    private int pledge;
    private int familie;

    private int buildings;

    int ActiveRent;

    //Ejerskab
    private Boolean owned;
    private Player owner;
    private Boolean pledgestate;

    public Property(int ID, int familie, String name, int price, int housePrice, int rentNormal, int rent1House, int rent2House, int rent3House, int rent4House, int rentHotel, int pledge) {
        this.ID = ID;
        this.familie = familie;
        this.name = name;
        this.price = price;
        this.housePrice = housePrice;
        this.rentNormal = rentNormal;
        this.rent1House = rent1House;
        this.rent2House = rent2House;
        this.rent3House = rent3House;
        this.rent4House = rent4House;
        this.rentHotel = rentHotel;
        this.pledge = pledge;
        pledgestate = false;
    }

    public void instantiateFieldsCSV(){
        List<Property> properties;
        Property[] test = new Property[40];
        CSVFileReader csvFileReader = new CSVFileReader();
        String[] liste = csvFileReader.fileReader(1);

        for (int i = 0; i < cards.length; i++){
            cards[i] = new Card(i, liste[i]);
        }
        for (int i = 0; i<12;i++){

        }
        Property Bernstoffsvej = new Property(15,4,"Bernstoffsvej",3600,2000,300,1400,4000,11000,15000,19000,1800);
        FieldProperty fieldBernstoffvej = new FieldProperty(Bernstoffsvej);
    }

    //Change the rent after the amount of buildings
    public void setActiveRent(int rentNumber){

        switch (rentNumber){
            case 0:
                ActiveRent = rentNormal;
                setBuidlings(0);
            break;
            case 1:
                ActiveRent = rent1House;
                setBuidlings(1);
            break;
            case 2:
                ActiveRent = rent2House;
                setBuidlings(2);
            break;
            case 3:
                ActiveRent = rent3House;
                setBuidlings(3);
            break;
            case 4:
                ActiveRent = rent4House;
                setBuidlings(4);
            break;
            case 5:
                ActiveRent = rentHotel;
                setBuidlings(5);
            break;
        }
    }

    public int getPrice() {
        return price;
    }

    public int setPrice(){
        return price;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean ownership) {
        owned = ownership;
    }

    public int getActiveRent(){
        return ActiveRent;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int newPrice){housePrice = newPrice;}

    public void setBuidlings(int amount){buildings = amount;}

    public int getBuildings(){
        return buildings;}

    public int getFamilie(){
        return familie;
    }

    public void setFamilie(int newFamilie){
        familie = newFamilie;
    }

    public int getID(){
        return ID;
    }

    public void setID(int newID){
        ID = newID;
    }

    public Boolean getPledgestate() {
        return pledgestate;
    }

    public void setPledgestate(Boolean newPledgestate) {
        this.pledgestate = newPledgestate;
    }

    public int getPledge(){
        return pledge;
    }

    public void setPledge(int newPledge){
        pledge = newPledge;}

}
