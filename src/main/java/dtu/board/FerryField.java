package dtu.board;

import dtu.players.Player;

public class FerryField extends BuyableFields{


    private Ferry ferry;

    //
    private Boolean owned;

    private Player owner;



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
            this.pledgeState = false;
            player.getFerries().add(this);
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
        return "Du er landet på færgen: " + ferry.getName() + ".";
    }

    @Override
    public String type() {
        return "ferry";
    }

    public int findActiveRent(){

        int temp = owner.getFerries().size();
        int activeRent = 0;


        switch (temp){
            case 1:
                activeRent = ferry.getRent1();
                return activeRent;
            case 2:
                activeRent = ferry.getRent2();
                return  activeRent;
            case 3:
                activeRent = ferry.getRent3();
                return  activeRent;
            case 4:
                activeRent = ferry.getRent4();
                return  activeRent;

        }
        return  activeRent;
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

    public boolean isPledgeState() {
        return pledgeState;
    }

    public void setPledgeState(boolean pledgeState) {
        this.pledgeState = pledgeState;
    }
}
