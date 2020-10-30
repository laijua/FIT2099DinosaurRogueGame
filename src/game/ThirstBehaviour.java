package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to determine the action when thirsty
 */
public class ThirstBehaviour extends CommonStuffBehaviour {


    /**
     * Method to determine what to do when finding food
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an action to drink
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        final int THIRSTLEVEL = 30;

        Dinosaur dinosaur = (Dinosaur) actor;

        if (dinosaur.getThirstLevel() < THIRSTLEVEL) {
            System.out.println(dinosaur + " at " + "(" + map.locationOf(dinosaur).x() + ", " + map.locationOf(dinosaur).y() + ") is getting thirsty!");
            Location dinosaurLocation = map.locationOf(actor);

            if (findWater(dinosaurLocation, 1) != null) {
                return new DrinkAction();
            }

            if (findWater(dinosaurLocation, 4) != null) {

                Location there = findWater(dinosaurLocation, 4).getDestination();
                return move(actor, dinosaurLocation, there);

            }


        }
        return null;
    }

    /**
     * Method to find water
     * @param location location of dinosaur finding trying to find water
     * @param range how far the dinosaur can see when finding water
     * @return exit towards where the water is
     */
    private Exit findWater(Location location, int range) {
        return findWaterRecursion(location, range, null);
    }

    /**
     * helper method for findWater
     * @param location location of dinosaur finding trying to find water
     * @param range how far the dinosaur can see when finding water
     * @param exit input as null by the findWater function
     * @return a route towards water if any in range
     */
    private Exit findWaterRecursion(Location location, int range, Exit exit) {
        if (location.getGround() instanceof Water && !location.containsAnActor()) {
            return exit;
        }

        if (range > 0) {
            for (Exit exits : location.getExits()) {
                if (findWaterRecursion(exits.getDestination(), range - 1, exits) != null) {
                    return findWaterRecursion(exits.getDestination(), range - 1, exits);
                }
            }
        }
        return null;
    }

}

