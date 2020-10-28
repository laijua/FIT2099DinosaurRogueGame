package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class DrinkAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();
        dinosaur.increaseThirstLevel();
        return actor + " at " + "(" + dinoX + ", " + dinoY + ") drinks from the pool";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
