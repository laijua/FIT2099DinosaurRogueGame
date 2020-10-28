package game;

import edu.monash.fit2099.engine.*;


public class ThirstBehaviour extends CommonStuffBehaviour {
    final int LEVEL = 30;


    /**
     * Method to determine what to do when finding food
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an action to do when finding food
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;

        if (dinosaur.getThirstLevel() < LEVEL) {
            System.out.println(dinosaur + " at " + "(" + map.locationOf(dinosaur).x() + ", " + map.locationOf(dinosaur).y() + ") is getting thirsty!");
            Location dinosaurLocation = map.locationOf(actor);

            // check if any water source in range
            if (find(dinosaurLocation,1, "water", null) != null){
                return new DrinkAction();
            }

            if (find(dinosaurLocation,4, "water", null) != null){

                Location there = find(dinosaurLocation,4, "water", null).getDestination();
                return move ( actor,  dinosaurLocation,  there);

            }


        }
        return null;
    }

    


}

