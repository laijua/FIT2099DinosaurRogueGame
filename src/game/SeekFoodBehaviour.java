package game;

import edu.monash.fit2099.engine.*;

public class SeekFoodBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                for(Item items: location.getItems()){
                    if (items instanceof Food){
                        Food food = (Food) items;
                        if (food.hasCapability(dinosaur.getEdibleType())){
                            return new MoveActorAction(location, "Ssdsdsdsdsdsd");
                        }
                    }
                }
            }
        }


        return null;
    }

}
