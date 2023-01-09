package dtu.board;

import dtu.players.Player;

public class PropertyHandler {

    private Board board = new Board();



    /**
     * Method for buying property, takes money, changes ownership and sets basic rent
     * @param player the player buying the property
     * @param property the property being bought
     */
    public void buyProperty(Player player, Property property){
        if(player.getMoney() > property.getPrice()) {
            player.setMoney(player.getMoney() - property.getPrice());
            property.setOwner(player);
            property.setOwned(true);
            property.setActiveRent(0);
            property.setPledgestate(false);
        }
        else{System.out.println("Du har ikke penge nok");}
    }

    /**
     * Method for paying rent, retrieves rent frem property and removes money accordingly.
     * Also delivers money to the properties owner
     * @param player the player who must pay rent
     * @param property the property which the player landed on
     */
    public static void payRent(Player player, Property property) {
        if(property.getPledgestate() == false) {
            if(PropertyList.getPermit(property) == true && property.getBuildings() == 0){
                player.setMoney(player.getMoney() - (property.getActiveRent() * 2));
                property.getOwner().setMoney(property.getOwner().getMoney() + (property.getActiveRent() * 2));
            }
            else{
                player.setMoney(player.getMoney() - property.getActiveRent());
                property.getOwner().setMoney(property.getOwner().getMoney() + property.getActiveRent());
            }
        }}


    /**
     * Method for building house or hotel, removes money and set activeRent accordingly.
     * Doesn't check if requirements for building is met, in any form.
     * But does change price to hotel standard if four houses is already placed.
     * @param player the player paying (could be changed to property owner)
     * @param property the property getting houses build on it
     */
    public void buildHouse(Player player, Property property) {
        // En besked fortæller pris og giver mulighed for at bekræfte køb
        //hvis der trykkes køb:
        if(PropertyList.getPermit(property) == true) {//Sikrer man ikke kan bygge før man har alle grunde i farven
            if (property.getBuildings() < 4) {
                if (player.getMoney() > property.getHousePrice()) {
                    player.setMoney(player.getMoney() - property.getHousePrice());
                    property.setActiveRent(property.getBuildings() + 1);
                } else {
                    System.out.println("Du har ikke penge nok");
                }
            } else if (property.getBuildings() == 4) {
                if (player.getMoney() > property.getHousePrice() * 5) {
                    player.setMoney(player.getMoney() - (property.getHousePrice() * 5));
                    property.setActiveRent(property.getBuildings() + 1);
                } else {
                    System.out.println("Du har ikke penge nok");
                }
            } else {
                System.out.println("Du kan ikke bygge mere");
            }
            //Hvis ikke der trykkes køb sker intet
        }
        else{System.out.println("Du skal eje alle properties af denne farve først");}
    }

    /**
     * Method to pledge a property
     * @param player
     * @param property
     */
    public void pledgeProperty(Player player,Property property){
        if(property.getPledgestate() == false) {
            player.setMoney(player.getMoney() + (property.getPledge()));
            property.setPledgestate(true);
        }
        else{
            if(player.getMoney() > (property.getPledge() + (property.getPledge()/10))){
                player.setMoney(player.getMoney() - (property.getPledge() + (property.getPledge()/10)));
                property.setPledgestate(false);}
            else{System.out.println("Du har ikke penge nok til at få grunden tilbage");}
        }
    }

    /**
     * Method for determining what ferry a player should move to when drawing a chancecard that says "Move to nearest ferry".
     * @param player
     */
}
