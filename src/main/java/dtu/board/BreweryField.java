package dtu.board;

import dtu.players.Player;



public class BreweryField extends BuyableFields{
    Brewery brewery;

    private Boolean owned;

    private Player owner;

    private boolean pledgeState;


    public BreweryField(Brewery brewery) {
        this.owned = false;
        this.brewery = brewery;
    }

    @Override
    public Boolean buy(Player player) {
        if(player.getMoney() >= this.brewery.getPrice()){
            player.setMoney(player.getMoney() - brewery.getPrice());
            this.owner = player;
            this.owned = true;
            this.pledgeState = false;
            player.getBreweries().add(this);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void rent(Player player, int rent) {
        player.setMoney(player.getMoney() - rent);
        owner.setMoney(owner.getMoney() + rent);
    }


    @Override
    public String landedLabel() {
        return "Du er landet på " + brewery.getName() + ".";
    }

    @Override
    public String type() {
        return "brewery";
    }

    public int findActiveRent(int currentRoll){

        int temp = owner.getFerries().size();
        int activeRent = 0;


        switch (temp){
            case 1:
                activeRent = brewery.getRent1() * currentRoll;
                return activeRent;
            case 2:
                activeRent = brewery.getRent2() * currentRoll;
                return  activeRent;
        }
        return  activeRent;
    }


    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public Boolean getOwned() {
        return owned;
    }

    public void setOwned(Boolean owned) {
        this.owned = owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public boolean isPledgeState() {
        return pledgeState;
    }

    public void setPledgeState(boolean pledgeState) {
        this.pledgeState = pledgeState;
    }
}
