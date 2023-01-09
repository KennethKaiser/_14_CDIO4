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
        return null;
    }

    @Override
    public void rent() {

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
}
