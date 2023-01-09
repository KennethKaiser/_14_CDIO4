package dtu.players;

import dtu.board.Field;
import dtu.board.FieldProperty;

import java.text.FieldPosition;
import java.util.ArrayList;

public class Player {

    private int id;
    private String name;
    private int position;
    private int money;
    private ArrayList<Field> properties = new ArrayList<>();
    private String color;

    private boolean bankrupt;
    private boolean jail = false;
    private boolean getOutOfJailCard = false;

    public Player(int id, String name, int money, String color) {
        this.id = id;
        this.name = name;
        this.position = 0;
        this.money = money;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        if(position > 39){
            position = position - 40;
        }
        if(position<0){
            position = position + 40;
        }
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public ArrayList<Field> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Field> properties) {
        this.properties = properties;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public boolean isJail() {
        return jail;
    }

    public void setJail(boolean jail) {
        this.jail = jail;
    }

    public boolean isGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(boolean getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }
}
