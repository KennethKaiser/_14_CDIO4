package dtu.players;

public class PlayerHandler {

    private Player[] players;

    public void amountOfPlayers(int howManyPlayers){
        this.players = new Player[howManyPlayers];
    }

    public void initializePlayer(int id, String name, int money, String color){
        players[id] = new Player(id, name, money, color);
    }


    public Player[] getPlayers() {
        return players;
    }
}
