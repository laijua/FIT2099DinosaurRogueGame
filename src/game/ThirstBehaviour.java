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
            int dinoX = dinosaurLocation.x();
            int dinoY = dinosaurLocation.y();

            // check if any water source in range
            for (int x : dinosaurSearchRadius) {
                for (int y : dinosaurSearchRadius) {
                    if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                        Location location = map.at(dinoX + x, dinoY + y);
                        if (location.getGround() instanceof Water) {
                            if (distance(dinosaurLocation, location) == 1) {
                                dinosaur.increaseThirstLevel();
                                System.out.println(actor + " at " + "(" + dinoX + ", " + dinoY + ") drinks from the pool");
                                return null;

                            }
                            Location there = location;
                            int currentDistance = distance(dinosaurLocation, there);
                            for (Exit exit : dinosaurLocation.getExits()) {
                                Location destination = exit.getDestination();
                                if (destination.canActorEnter(actor)) {
                                    int newDistance = distance(destination, there);
                                    if (newDistance < currentDistance) {
                                        if (!destination.containsAnActor()) {
                                            return new MoveActorAction(destination, exit.getName());
                                        }
                                    }
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

