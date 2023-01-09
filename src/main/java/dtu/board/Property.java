package dtu.board;

import dtu.players.Player;

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

    public String getName() {
        return name;
    }

    public int getRentNormal() {
        return rentNormal;
    }

    public int getRent1House() {
        return rent1House;
    }

    public int getRent2House() {
        return rent2House;
    }

    public int getRent3House() {
        return rent3House;
    }

    public int getRent4House() {
        return rent4House;
    }

    public int getRentHotel() {
        return rentHotel;
    }


    //Roder igen

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
                send = Board.getFamilie8();
                break;
        }
        return send;
    }

    public Boolean getPermision(){
        Boolean answer = null;
        switch (getFamilie()) {
            case 1:
                if (Board.getFamilieList(1)[0].getOwner() == getFamilieList(1)[1].getOwner()) {
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
