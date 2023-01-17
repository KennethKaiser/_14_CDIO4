package dtu.board;


public abstract class Field {

    protected Property property;


    public Field(){

    }

    public abstract String landedLabel();

    public abstract String type();


}
