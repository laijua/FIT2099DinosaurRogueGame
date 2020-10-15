package game;

import edu.monash.fit2099.engine.*;

public class SeekFoodBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        boolean foundFood = false;

        int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3, 4, -4};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                for(Item items: location.getItems()){
                    if (items instanceof Food){
                        Food food = (Food) items;
                        if (food.hasCapability(dinosaur.getEdibleType())){
                            if(false){
                                // increase dino food level, remove food in the returned EatAction?
                                foundFood = true;
                            }
                            return new MoveActorAction(location, "Ssdsdsdsdsdsd");
                        }
                    }
                }
            }
        }

        if(!foundFood){
            if (dinosaur.getEdibleType() == GameCapability.CARNIVOREEDIBLE){
                for (int x : dinosaurSearchRadius) {
                    for (int y : dinosaurSearchRadius) {
                        Location location = map.at(dinoX + x, dinoY + y);
                        if(location.containsAnActor()){
                            if (location.getActor() instanceof Dinosaur){
                                Dinosaur target = (Dinosaur) location.getActor();
                                if (target.hasCapability(GameCapability.ALLOSAURATTACKABLE)){
                                    System.out.println("SD");
                                    return new FollowBehaviour(target).getAction(target, map);
                                }
                            }
                        }
                    }
                }
            }
        }


        return null;
    }

}
