package dtu.players;

import dtu.board.FieldProperty;
import dtu.controllers.ControllerHandler;

public class PlayerHandler {

    private Player[] players;
    private Player currentPlayer;
    private int nID = -1;
    private static final int STARTMONEY = 30000;



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

        player.setPosition(nextFieldPlacement);

    }



    /**
     * Method for setting start-money for each player in a loop going from the iterator i=0 to i < length of player
     * array. Its sharp smaller than because index starts at 0. So for player[].length = 4, we will have index
     * 0, 1, 2, 3 - and therefore i needs to be sharp smaller than the lenght of the array. Change constant STARTMONEY
     * in class PlayerHandler to change startmoney amount.
     * @param player
     */
    public void PlayerStartMoney(Player player){
        for (int i=0; i<players.length; i++){
            players[i].setMoney(STARTMONEY);
        }
    }

    /**
     * Method for checking if player is bankrupt.
     * @param player
     */
    public void isPlayerBankrupt(Player player){
        if (player.getMoney() < 0){
            player.setBankrupt(true);
            playerIsBankrupt(player);

            changePlayerArray();

        }

    }


    /**
     * Method for when a player is bankrupt. It will remove the player from the game and set the player to null.
     * @param player
     */
    public void playerIsBankrupt(Player player){
        for (int i=0; i<player.getProperties().size();i++) {
            ((FieldProperty)player.getProperties().get(i)).setOwner(null);
            ((FieldProperty)player.getProperties().get(i)).getProperty().setOwned(false);
            ((FieldProperty)player.getProperties().get(i)).getProperty().setActiveRent(0);
            //player.getProperties().get(i).getProperty().setBuildings(0);

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

    public static void nearestFerry(Player player){
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

    public static void movePlayerChanceCard(Player player, int ID){
        int moveChanceCard;
        if(player.getPosition()<ID) {
            moveChanceCard = ID - player.getPosition();
            player.setPosition(player.getPosition()+moveChanceCard);
        }
        if(player.getPosition()>ID){
            moveChanceCard = (40-player.getPosition())+ID;
            player.setPosition(player.getPosition()+moveChanceCard);
        }
    }

    public static void changePlayerBalance(Player player, int amount){
        player.setMoney(player.getMoney()+amount);
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
}
