package dtu.players;

import dtu.board.Field;

import java.util.ArrayList;

public class Player {

    private int id;
    private String name;
    private int position;
    private int money;
    private int lastPlayerPaid;
    private ArrayList<Field> properties = new ArrayList<>();
    private ArrayList<Field> ferries = new ArrayList<>();
    private ArrayList<Field> breweries = new ArrayList<>();
    private String color;

    private boolean bankrupt = false;
    private boolean jail = false;
    private boolean getOutOfJailCard = false;

    private int jailTurns = 0;

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

    public int getLastPlayerPaid() {
        return lastPlayerPaid;
    }

    public void setLastPlayerPaid(int lastPlayerPaid) {
        this.lastPlayerPaid = lastPlayerPaid;
    }

    public boolean isGetOutOfJailCard() {
        return getOutOfJailCard;
    }

    public void setGetOutOfJailCard(boolean getOutOfJailCard) {
        this.getOutOfJailCard = getOutOfJailCard;
    }
    public void setJailTurns(int turns){this.jailTurns = turns;}
    public int getJailTurns(){return jailTurns;}

    public ArrayList<Field> getFerries() {
        return ferries;
    }

    public void setFerries(ArrayList<Field> ferries) {
        this.ferries = ferries;
    }

    public ArrayList<Field> getBreweries() {
        return breweries;
    }

    public void setBreweries(ArrayList<Field> breweries) {
        this.breweries = breweries;
    }
}
