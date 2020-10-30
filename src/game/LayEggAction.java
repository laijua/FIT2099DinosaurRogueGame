package game;

import edu.monash.fit2099.engine.*;

/**
 * Action for laying an egg
 */
public class LayEggAction extends Action {

    private Dinosaur parentDino;

    /**
     * Constructor for laying an egg
     * @param parentDinoClass the dinosaur that lays the egg
     */
    public LayEggAction(Dinosaur parentDinoClass) {
        this.parentDino = parentDinoClass;
    }

    /**
     * Performs the laying egg action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to output to console
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        dinosaurLocation.addItem(makeEgg());
        return actor + " at " + "(" + dinoX + ", " + dinoY + ") has laid an egg";
    }

    /**
     * returns the description of the action
     * @param actor The actor performing the action.
     * @return the description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    /**
     * returns a new Egg
     * @return a new Egg
     */
    private Egg makeEgg() {
        return new Egg(parentDino);
    }
}
