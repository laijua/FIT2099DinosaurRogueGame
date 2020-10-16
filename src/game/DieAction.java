package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Action to have a dinosaur die
 */
public class DieAction extends Action {
    /**
     * Perform dying action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to output to console
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int x = map.locationOf(actor).x();
        int y = map.locationOf(actor).y();
        Location dinosaurLocation = map.locationOf(actor);
        dinosaurLocation.addItem(new DinosaurCorpse());
        map.removeActor(actor);
        return actor + " at " + "(" + x + ", " + y + ") dies";

    }

    /**
     * Description of action being performed
     * @param actor The actor performing the action.
     * @return description of action being performed
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " dies";
    }

}
