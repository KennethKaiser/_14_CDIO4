package dtu.board;

import dtu.players.Player;

public class PropertyHandler {

    private Board board = new Board();



    /**
     * Method for buying property, takes money, changes ownership and sets basic rent
     * @param player the player buying the property
     * @param property the property being bought
     */
    public static void buyProperty(Player player, Property property){
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
     * Method for building house or hotel, removes money and set activeRent accordingly.
     * Doesn't check if requirements for building is met, in any form.
     * But does change price to hotel standard if four houses is already placed.
     * @param player the player paying (could be changed to property owner)
     * @param property the property getting houses build on it
     */
    public void buildHouse(Player player, Property property) {
        // En besked fortæller pris og giver mulighed for at bekræfte køb
        //hvis der trykkes køb:
        if(getPermit(property) == true) {//Sikrer man ikke kan bygge før man har alle grunde i farven
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
     * Method to see if a player owns all properties in a fimilie
     * @param property Just one of the properties in question
     * @return True means a player owns all properties in the familie
     */
    public static Boolean getPermit(Property property) {
        Boolean answer = null;
        switch (property.getFamilie()) {
            case 1:
                if (Board.getFamilieList(1)[0].getOwner() == Board.getFamilieList(1)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 2:
                if (Board.getFamilieList(2)[0].getOwner() == Board.getFamilieList(2)[1].getOwner() && Board.getFamilieList(2)[0].getOwner() == Board.getFamilieList(2)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 3:
                if (Board.getFamilieList(3)[0].getOwner() == Board.getFamilieList(3)[1].getOwner() && Board.getFamilieList(3)[0].getOwner() == Board.getFamilieList(3)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 4:
                if (Board.getFamilieList(4)[0].getOwner() == Board.getFamilieList(4)[1].getOwner() && Board.getFamilieList(4)[0].getOwner() == Board.getFamilieList(4)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 5:
                if (Board.getFamilieList(5)[0].getOwner() == Board.getFamilieList(5)[1].getOwner() && Board.getFamilieList(5)[0].getOwner() == Board.getFamilieList(5)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 6:
                if (Board.getFamilieList(6)[0].getOwner() == Board.getFamilieList(6)[1].getOwner() && Board.getFamilieList(6)[0].getOwner() == Board.getFamilieList(6)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 7:
                if (Board.getFamilieList(7)[0].getOwner() == Board.getFamilieList(7)[1].getOwner() && Board.getFamilieList(7)[0].getOwner() == Board.getFamilieList(7)[2].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
            case 8:
                if (Board.getFamilieList(8)[0].getOwner() == Board.getFamilieList(8)[1].getOwner()) {
                    answer = true;
                } else {
                    answer = false;
                }
                break;
        }
        return answer;
    }


    /**
     * Method for determining what ferry a player should move to when drawing a chancecard that says "Move to nearest ferry".
     * @param player
     */
}
