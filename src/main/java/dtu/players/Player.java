package dtu.players;

import dtu.board.Field;

import java.util.ArrayList;

public class Player {

    private int id;
    private String name;
    private int position;
    private int money;
    private ArrayList<Field> properties;
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
}
