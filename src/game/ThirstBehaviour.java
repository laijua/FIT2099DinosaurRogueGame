package game;

import edu.monash.fit2099.engine.*;


public class ThirstBehaviour extends CommonStuffBehaviour {


    /**
     * Method to determine what to do when finding food
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return an action to do when finding food
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        final int LEVEL = 30;

        Dinosaur dinosaur = (Dinosaur) actor;

        if (dinosaur.getThirstLevel() < LEVEL) {
            System.out.println(dinosaur + " at " + "(" + map.locationOf(dinosaur).x() + ", " + map.locationOf(dinosaur).y() + ") is getting thirsty!");
            Location dinosaurLocation = map.locationOf(actor);

            if (findWater(dinosaurLocation, 1,  null) != null) {
                return new DrinkAction();
            }

            if (findWater(dinosaurLocation, 4,  null) != null) {

                Location there = findWater(dinosaurLocation, 4,  null).getDestination();
                return move(actor, dinosaurLocation, there);

            }


        }
        return null;
    }

    private Exit findWater( Location location, int range, Exit exit) {
        if (location.getGround() instanceof Water && !location.containsAnActor()) {
            return exit;
        }

        if (range > 0) {
            for (Exit exits : location.getExits()) {
                if (findWater(exits.getDestination(), range - 1,  exits) != null) {
                    return findWater(exits.getDestination(), range - 1, exits);
                }
            }
        }
        return null;
    }

}

