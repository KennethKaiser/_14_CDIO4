package dtu.board;

import dtu.players.Player;

public class FerryField extends BuyableFields{


    private Ferry ferry;

    //
    private Boolean owned;

    private Player owner;

    private int activeRent;


    private boolean pledgeState;

    public FerryField(Ferry ferry){
        this.owned = false;
        this.ferry = ferry;
    }


    @Override
    public Boolean buy(Player player) {
        if(player.getMoney() >= this.ferry.getPrice()){
            player.setMoney(player.getMoney() - ferry.getPrice());
            this.owner = player;
            this.owned = true;
            this.activeRent = 0;
            this.pledgeState = false;
            player.getProperties().add(this);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void rent() {

    }


    @Override
    public String landedLabel() {
        return "Du er landet på færgen: " + ferry.getName() + ".";
    }

    @Override
    public String type() {
        return "ferry";
    }


    public Ferry getFerry() {
        return ferry;
    }

    public void setFerry(Ferry ferry) {
        this.ferry = ferry;
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
