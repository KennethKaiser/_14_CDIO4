package dtu.players;

public class PlayerHandler {

    private Player[] players;
    private static final int STARTMONEY = 30000;

    public void amountOfPlayers(int howManyPlayers){
        this.players = new Player[howManyPlayers];
    }

    public void initializePlayer(int id, String name, int money, String color){
        players[id] = new Player(id, name, money, color);
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

    public Player[] getPlayers() {
        return players;
    }
}
