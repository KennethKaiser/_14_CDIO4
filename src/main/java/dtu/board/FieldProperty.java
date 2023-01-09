package dtu.board;

import dtu.players.Player;

import static dtu.board.PropertyHandler.getPermit;

public class FieldProperty extends BuyableFields{

    protected Property property;

    //Nyt
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

    public FieldProperty(Property property){
        super(property);
        this.property = property;
    }

    /**
     * Method for when the player lands on a property, getting the choice to buy it or must pay rent
     * @param player the player who landed on the field
     */
    @Override
    public void action(Player player) {
        if(getOwned() == false){
            //En besked giver valget for at købe grunden
            //Hvis ja:
            buyProperty(player, property);
            //Hvis nej, intet
        }
        if(getOwned() == true){
            //En besked fortæller summen af penge der gives og til hvem
            payRent(player, property);
        }
    }

    /**
     * Method for buying property, takes money, changes ownership and sets basic rent
     * @param player the player buying the property
     * @param property the property being bought
     */
    public void buyProperty(Player player, FieldProperty property){
        if(player.getMoney() > getPrice()) {
            player.setMoney(player.getMoney() - getPrice());
            setOwner(player);
            setOwned(true);
            setActiveRent(0);
            setPledgestate(false);
        }
        else{System.out.println("Du har ikke penge nok");}
    }


    /**
     * Method for paying rent, retrieves rent frem property and removes money accordingly.
     * Also delivers money to the properties owner
     * @param player the player who must pay rent
     * @param property the property which the player landed on
     */
    public static void payRent(Player player, FieldProperty property) {
        if(property.getPledgestate() == false) {
            if(getPermit(property) == true && property.getBuildings() == 0){
                player.setMoney(player.getMoney() - (property.getActiveRent() * 2));
                property.getOwner().setMoney(property.getOwner().getMoney() + (property.getActiveRent() * 2));
            }
            else{
                player.setMoney(player.getMoney() - property.getActiveRent());
                property.getOwner().setMoney(property.getOwner().getMoney() + property.getActiveRent());
            }
        }}


    /**
     * Metode til at ændre leje
     * @param rentNumber er antallet af huse 0 til 5 (5 er hotel)
     */
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }


    public void setBuildings(int buildings) {
        this.buildings = buildings;
    }

    public int getPrice() {
        return price;
    }

    public int setPrice(){
        return price;
    }

    public Player getOwner() {
        return owner;
    }

    public Boolean getOwned() {
        return owned;
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


    @Override
    public void buy() {

    }

    @Override
    public void rent() {

    }
}
