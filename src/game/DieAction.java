package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class DieAction extends Action {
    @Override
    public String execute(Actor actor, GameMap map) {
        Location dinosaurLocation = map.locationOf(actor);
        dinosaurLocation.addItem(new DinosaurCorpse());
        map.removeActor(actor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " dies";
    }

}
