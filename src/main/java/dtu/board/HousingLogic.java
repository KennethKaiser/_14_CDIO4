package dtu.board;

import dtu.controllers.ControllerHandler;
import dtu.players.PlayerHandler;

import java.util.ArrayList;

public class HousingLogic {
    PlayerHandler playerHandler;
    public boolean checkForHasAllOfFamily(FieldProperty property, int player){
        if(playerHandler == null) playerHandler = ControllerHandler.getInstance().getBoardController().getPlayerHandler();
        ArrayList<Field> playerProperties = playerHandler.getPlayers()[player].getProperties();
        Field[] allProperties = ControllerHandler.getInstance().getBoard().getCurrentBoard();
        switch (property.getProperty().getFamilie()){
            case 1: //Blå (de starter fra 1)
                if(playerProperties.contains(allProperties[1]) && playerProperties.contains(allProperties[3])){


                    return true;
                }
                else return false;
            case 2:
                if(playerProperties.contains(allProperties[6]) && playerProperties.contains(allProperties[8]) && playerProperties.contains(allProperties[9])){
                    return true;
                }
                else return false;
            case 3:
                if(playerProperties.contains(allProperties[11]) && playerProperties.contains(allProperties[13]) && playerProperties.contains(allProperties[14])){
                    return true;
                }
                else return false;
            case 4:
                if(playerProperties.contains(allProperties[16]) && playerProperties.contains(allProperties[18]) && playerProperties.contains(allProperties[19])){
                    return true;
                }
                else return false;
            case 5:
                if(playerProperties.contains(allProperties[21]) && playerProperties.contains(allProperties[23]) && playerProperties.contains(allProperties[24])){
                    return true;
                }
                else return false;
            case 6:
                if(playerProperties.contains(allProperties[26]) && playerProperties.contains(allProperties[27]) && playerProperties.contains(allProperties[29])){
                    return true;
                }
                else return false;
            case 7:
                if(playerProperties.contains(allProperties[31]) && playerProperties.contains(allProperties[32]) && playerProperties.contains(allProperties[34])){
                    return true;
                }
                else return false;
            case 8:
                if(playerProperties.contains(allProperties[37]) && playerProperties.contains(allProperties[39])){
                    return true;
                }
                else return false;
            default:
                System.out.println("Family of building does not exists (0 is ignored, starts at 1)");
                return false;
        }
    }
    public boolean canBuild(FieldProperty property, int player){
        int family = property.getProperty().getFamilie();
        if(property.isPledgeState()) return  false;
        ArrayList<Field> properties = playerHandler.getPlayers()[player].getProperties();
        ArrayList<Field> sameFamily = new ArrayList<>();
        for(int i = 0; i < properties.size(); i++){
            if(((FieldProperty)properties.get(i)).getProperty().getFamilie() == family) {
                if((FieldProperty) properties.get(i) != property) sameFamily.add(properties.get(i));
            }
        }
        boolean canBuild = true;
        for(int i = 0; i < sameFamily.size(); i++){
            int buildings = ((FieldProperty)sameFamily.get(i)).getBuildings();
            if(buildings < property.getBuildings()) canBuild = false;
        }
        return canBuild;
    }
    public boolean canRemove(FieldProperty property, int player){
        int family = property.getProperty().getFamilie();
        if(property.isPledgeState()) return  false;
        ArrayList<Field> properties = playerHandler.getPlayers()[player].getProperties();
        ArrayList<Field> sameFamily = new ArrayList<>();
        for(int i = 0; i < properties.size(); i++){
            if(((FieldProperty)properties.get(i)).getProperty().getFamilie() == family) {
                if((FieldProperty) properties.get(i) != property) sameFamily.add(properties.get(i));
            }
        }
        boolean canRemove = true;
        for(int i = 0; i < sameFamily.size(); i++){
            int buildings = ((FieldProperty)sameFamily.get(i)).getBuildings();
            if(buildings > property.getBuildings()) canRemove = false;
        }
        return canRemove;
    }
    public boolean canAfford(FieldProperty property, int player){
        return true;
    }

}
