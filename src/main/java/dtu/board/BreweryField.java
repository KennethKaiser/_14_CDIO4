package dtu.board;

import dtu.players.Player;



public class BreweryField extends BuyableFields{
    Brewery brewery;

    private Boolean owned;

    private Player owner;

    private int activeRent;

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
            this.activeRent = 0;
            this.pledgeState = false;
            player.getBreweries().add(this);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void rent(Player player) {

    }


    @Override
    public String landedLabel() {
        return "Du er landet på " + brewery.getName() + ".";
    }

    @Override
    public String type() {
        return "brewery";
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

    public int getActiveRent() {
        return activeRent;
    }

    public void setActiveRent(int activeRent) {
        this.activeRent = activeRent;
    }

    public boolean isPledgeState() {
        return pledgeState;
    }

    public void setPledgeState(boolean pledgeState) {
        this.pledgeState = pledgeState;
    }
}
