package dtu.board;

public abstract class BuyableFields extends Field {


    public BuyableFields(Property property) {
        super(property);
    }

    public abstract void buy();

    public abstract void rent();



}
