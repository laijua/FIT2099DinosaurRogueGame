package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class EatAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur d = (Dinosaur) actor;
        d.increaseFoodLevel(1);
        map.
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
