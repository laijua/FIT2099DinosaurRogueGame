package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class DieAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        int x = map.locationOf(actor).x();
        int y = map.locationOf(actor).y();
        Location dinosaurLocation = map.locationOf(actor);
        dinosaurLocation.addItem(new DinosaurCorpse());
        map.removeActor(actor);
        return actor + " at " + "(" + x + ", " + y + ") dies";

    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " dies";
    }

}
