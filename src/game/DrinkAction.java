package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Action for drinking
 */
public class DrinkAction extends Action {
    /**
     * Method to perform drinking action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to output to console
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        dinosaur.increaseThirstLevel();
        return actor + " at " + "(" + dinoX + ", " + dinoY + ") drinks from the pool";
    }

    /**
     * Method to describe action
     * @param actor The actor performing the action.
     * @return String describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
