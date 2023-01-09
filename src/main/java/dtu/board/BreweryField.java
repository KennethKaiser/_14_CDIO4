package dtu.board;

import dtu.players.Player;



public class BreweryField extends BuyableFields{
    Brewery brewery;
    public BreweryField(Brewery brewery) {
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
}
