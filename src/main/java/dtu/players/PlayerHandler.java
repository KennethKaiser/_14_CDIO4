package dtu.players;

import dtu.board.*;
import dtu.controllers.ControllerHandler;

import java.util.ArrayList;

public class PlayerHandler {

    private Player[] players;
    private Player currentPlayer;
    private int nID = -1;

    private boolean overStart = false;
    private static final int STARTMONEY = 30000;

    private Jackpot jackpot;



    public void currentPlayer(){
        nID++;
        if(nID >= players.length){
            nID = 0;
        }
        currentPlayer = players[nID];
    }

    //Should be called when the game ask how many are playing
    public void initializePlayers(int size){
        players = new Player[size];
    }

    //Should be called after player has entered name and what color
    public void initializePlayerInPlayers(int id, String name, int money, String color){

        players[id] = new Player(id, name, money, color);
    }


    /**
     * Method for moving player based on how many times to move on board.
     * @param player
     * @param deltaMove
     */
    public void movePlayer(Player player, int deltaMove){
        int nextFieldPlacement = player.getPosition() + deltaMove;

        newSetPosition(player, nextFieldPlacement);

        //getPlayers()[player.getId()].setPosition(nextFieldPlacement);

    }

    public void newSetPosition(Player player, int nextFieldPlacement){

        overStart = false;

        int position = nextFieldPlacement;

        if(position > 39){
            position = position - 40;
            if(!player.isJail()){
                overStart = true;
            }

        }
        else if(position<0){
            position = position + 40;
        }

        player.setPosition(position);


    }

    /**
     * Takes players position, and calculates the difference between the fieldID you want to move player to.
     * Needed for awarding player money over START.
     * @param player
     * @param ID
     */
    public void movePlayerChanceCard(Player player, int ID){
        int moveChanceCard;
        if(player.getPosition()<ID) {
            moveChanceCard = ID - player.getPosition();
            newSetPosition(player, player.getPosition()+moveChanceCard);
        }
        if(player.getPosition()>ID){
            moveChanceCard = (40-player.getPosition())+ID;
            newSetPosition(player, player.getPosition()+moveChanceCard);
        }
    }

    /**
     * Method for determining what ferry a player should move to when drawing a chancecard that says "Move to the nearest ferry".
     * @param player
     */
    public void nearestFerry(Player player){
        int ferry1 = 5;
        int ferry2 = 15;
        int ferry3 = 25;
        int ferry4 = 35;
        if (player.getPosition()>=35 || player.getPosition()<5){
            movePlayerChanceCard(player, ferry1);
        }
        else if (player.getPosition()>=5 && player.getPosition()<15){
            movePlayerChanceCard(player, ferry2);
        }
        else if (player.getPosition()>=15 && player.getPosition()<25){
            movePlayerChanceCard(player, ferry3);
        }
        else if (player.getPosition()>=25 && player.getPosition()<35){
            movePlayerChanceCard(player, ferry4);
        }
    }



    /**
     * Method for setting start-money for each player in a loop going from the iterator i=0 to i < length of player
     * array. Its sharp smaller than because index starts at 0. So for player[].length = 4, we will have index
     * 0, 1, 2, 3 - and therefore i needs to be sharp smaller than the lenght of the array. Change constant STARTMONEY
     * in class PlayerHandler to change startmoney amount.
     * @param player
     */
    public void playerStartMoney(Player player){
        for (int i=0; i<players.length; i++){
            changePlayerBalance(getPlayers()[i], STARTMONEY);
        }
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    /**
     * Method for checking if player is bankrupt.
     * @param player
     */
    public void isPlayerBankrupt(Player player){
        if (player.getMoney() < 0){
            player.setBankrupt(true);
            playerIsBankrupt(player);
        }
    }


    /**
     * Method for when a player is bankrupt. It will remove the player from the game and set the player to null.
     * @param player
     */
    public void playerIsBankrupt(Player player){
        if (getPlayers() != null){
            for (int i=0; i<player.getProperties().size();i++) {
                ((FieldProperty)player.getProperties().get(i)).setOwner(null);
                ((FieldProperty)player.getProperties().get(i)).setOwned(false);
                ((FieldProperty)player.getProperties().get(i)).setBuildings(0);
                ((FieldProperty)player.getProperties().get(i)).setPledgeState(false);

                if(((FieldProperty)player.getProperties().get(i)).getProperty().getFamilie() <9){
                    ControllerHandler.getInstance().getBoardController().setHousesOn(0, ((FieldProperty)player.getProperties().get(i)).getProperty().getID());
                }
            }
            for(int i = 0; i < player.getFerries().size(); i++){
                ((FerryField)player.getFerries().get(i)).setOwner(null);
                ((FerryField)player.getFerries().get(i)).setOwned(false);
                ((FerryField)player.getFerries().get(i)).setPledgeState(false);
            }
            for(int i = 0; i < player.getBreweries().size(); i++){
                ((BreweryField)player.getBreweries().get(i)).setOwner(null);
                ((BreweryField)player.getBreweries().get(i)).setOwned(false);
                ((BreweryField)player.getBreweries().get(i)).setPledgeState(false);
            }
        }
    }

    /**
     *  Method that changes the player to null and moves all players to new array.
     */
    public void changePlayerArray(){
        int j = 0;
        for (int i=0; i<players.length; i++){
            if (!players[i].isBankrupt()){
                j++;
            }
        }

        Player[] newPlayers = new Player[j];

        int k = 0;
        for (int i=0; i<players.length; i++){
            if (!players[i].isBankrupt()){
                newPlayers[k] = players[i];
                k++;
            }
        }

        players = newPlayers;
    }





    /**
     *
     * getMoneyFromOtherPlayers takes the length of the array of players, and adds that amount times para2 times to the current player
     * after that it deducts para2 from each player, also the current player to compensate for the para 2 amount the current player
     * gets too much. Adding money before retracting, so you can't go bankrupt from picking this chancecard.
     * @param player
     * @param amount
     */
    public void getMoneyFromOtherPlayers(Player player, int amount) {
            changePlayerBalance(getPlayers()[player.getId()], amount*getPlayers().length);
            for(int i=0; i < getPlayers().length; i++){
                changePlayerBalance(getPlayers()[i], -(amount));
        }
        }
        /*
        player.setMoney(player.getMoney()+(players.length*amount));
        for (int i=0; i<players.length; i++){
        getPlayers()[i].setMoney(getPlayers()[i].getMoney()-amount);

         */

    /**
     * True = flattax
     * False = 10% of current money.
     * For False, uses a method for rounding number up to nearest 50 by using math.ceil(). method is tenPercentTax()
     * @param player
     * @param choice
     */
    public void incomeTax(Player player, boolean choice){

        if (choice == true){
            changePlayerBalance(player, -4000);
        }
        if (choice == false){
            tenPercentTax(player);
        }
    }

    public void tenPercentTax(Player player){
        double roundUpTenPercent = (((player.getMoney()*0.10)/50));
        double roundUpFifty = Math.ceil(roundUpTenPercent)*50;
        int roundedToFifty = (int)roundUpFifty;
        changePlayerBalance(player, -roundedToFifty);
    }
    public int nonPledgeTax(int pledgeAmount){
        double nonPledgeTax = (((pledgeAmount*0.10)/100));
        double roundUpHundred = Math.ceil(nonPledgeTax)*100;
        int roundedToHundred = (int)roundUpHundred;

        return roundedToHundred;
    }

    public void changePlayerBalance(Player player, int amount){
        player.setMoney(player.getMoney()+amount);
    }

    /**
     * method for finding out the familiy of each property in a players property ArrayList, and telling how many houses have been build on each property.
     * Calculating the total amount of the value of all houses on all properties in family 1 to 8. Neeeded for chanceCard.
     * @param player
     * @return
     */
    public int valueOfAllHousesOnPlayerProperties(Player player) {
        Board board = new Board();
        int valueOfAllHouses;
        int familie1 = 0;
        int familie1HousePrice = ((FieldProperty) board.getCurrentBoard()[1]).getProperty().getHousePrice();
        int familie2 = 0;
        int familie2HousePrice = ((FieldProperty) board.getCurrentBoard()[6]).getProperty().getHousePrice();
        int familie3 = 0;
        int familie3HousePrice = ((FieldProperty) board.getCurrentBoard()[11]).getProperty().getHousePrice();
        int familie4 = 0;
        int familie4HousePrice = ((FieldProperty) board.getCurrentBoard()[16]).getProperty().getHousePrice();
        int familie5 = 0;
        int familie5HousePrice = ((FieldProperty) board.getCurrentBoard()[21]).getProperty().getHousePrice();
        int familie6 = 0;
        int familie6HousePrice = ((FieldProperty) board.getCurrentBoard()[26]).getProperty().getHousePrice();
        int familie7 = 0;
        int familie7HousePrice = ((FieldProperty) board.getCurrentBoard()[31]).getProperty().getHousePrice();
        int familie8 = 0;
        int familie8HousePrice = ((FieldProperty) board.getCurrentBoard()[37]).getProperty().getHousePrice();

            for (int i = 0; i < getPlayers()[player.getId()].getProperties().size(); i++) {
                int getBuildings = ((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getBuildings();
                int getFamily = ((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getProperty().getFamilie();
                if (getFamily == 1) {
                    familie1 += getBuildings * familie1HousePrice;
                } else if (getFamily == 2) {
                    familie2 += getBuildings * familie2HousePrice;
                } else if (getFamily == 3) {
                    familie3 += getBuildings * familie3HousePrice;
                } else if (getFamily == 4) {
                    familie4 += getBuildings * familie4HousePrice;
                } else if (getFamily == 5) {
                    familie5 += getBuildings * familie5HousePrice;
                } else if (getFamily == 6) {
                    familie6 += getBuildings * familie6HousePrice;
                } else if (getFamily == 7) {
                    familie7 += getBuildings * familie7HousePrice;
                } else if (getFamily == 8) {
                    familie8 += getBuildings * familie8HousePrice;
                }
            }
        valueOfAllHouses = familie1 + familie2 + familie3 + familie4 + familie5 + familie6 + familie7 + familie8;
        return valueOfAllHouses;
    }

    public int amountOfHouses(Player player){
        int amountOfHouses = 0;
        for(int i = 0; i<getPlayers()[player.getId()].getProperties().size();i++){
            if(((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getBuildings() < 5) {
                amountOfHouses += ((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getBuildings();
            }
        }
        return amountOfHouses;
    }
    public int amountOfHotels(Player player){
        int amountOfHotels = 0;
        for(int i = 0; i<getPlayers()[player.getId()].getProperties().size();i++){
            if(((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getBuildings() == 5) {
                amountOfHotels += ((FieldProperty) getPlayers()[player.getId()].getProperties().get(i)).getBuildings();
            }
        }
        return amountOfHotels/5;

    }

    /**
     * Takes the getPlayers[].getProperties size (arrayList), and for the player asking on ex. player[0], calculates the value of all properties.
     * This is one of two methods for calculating the total asset of a player if they draw the chanceCard with ID: 24
     * @param player
     * @return
     */
    public int getValueOfPlayersProperties(Player player) {
        int valueOfProperties = 0;
        if (getPlayers() != null) {
            for (int i = 0; i < getPlayers()[player.getId()].getProperties().size(); i++) {
                valueOfProperties += ((FieldProperty)getPlayers()[player.getId()].getProperties().get(i)).getProperty().getPrice();
            }
        }
        return valueOfProperties;
    }

    public int valueOfAllAssets(Player player){
        int allAssetsValue;

        allAssetsValue = player.getMoney() + getValueOfPlayersProperties(player) + valueOfAllHousesOnPlayerProperties(player);
        return allAssetsValue;
    }

    public boolean checkForChickenDinner(){
        int temp = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i].isBankrupt() != true){
                temp++;
            }
        }
        if(temp == 1){
            return true;
        }
        else{
            return false;
        }


    }

    public void moveToPrison(Player player){
        player.setPosition(10);
        player.setJail(true);
    }

    /**
     * Method that allows the player to quit the game
     * @param player
     */
    public void quitGame(Player player){
        player.setBankrupt(true);
        playerIsBankrupt(player);
        player.setMoney(0);
        changePlayerArray();
    }




    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isOverStart() {
        return overStart;
    }

    public void setOverStart(boolean overStart) {
        this.overStart = overStart;
    }

    public Jackpot getJackpot() {
        return jackpot;
    }

    public void setJackpot(Jackpot jackpot) {
        this.jackpot = jackpot;
    }
}
