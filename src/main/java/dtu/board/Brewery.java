package dtu.board;

import dtu.players.Player;

public class Brewery {
    Player owner;
    Boolean owned;
    String name, type, empty;
    int position, type, family, price, rent1, rent2

    public Brewery(String name, int position, String type, int family, int price,String empty,int rent1, int rent2){
        this.name = name;
        this.position = position;
        this.type = type;
        this.family = family;
        this.price = price;
        this.empty = empty;
        this.rent1 = rent1;
        this.rent2 = rent2;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getFamily() {
        return family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getRent1() {
        return rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public Player getOwner() {
        return owner;
    }
    public void setOwner(Player owner){
        this.owner = owner;
    }

    public void setOwned(Boolean owned){
        this.owned = owned;
    }

    public Boolean getOwned(){
        return owned;
    }
}
