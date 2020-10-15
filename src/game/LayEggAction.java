package game;

import edu.monash.fit2099.engine.*;

public class LayEggAction extends Action {

    private Dinosaur parentDino;

    public LayEggAction(Dinosaur parentDinoClass) {
        this.parentDino = parentDinoClass;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location dinosaurLocation = map.locationOf(actor);
        dinosaurLocation.addItem(breed());
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " and " + parentDino + " have bred";
    }

    private Egg breed() {
        return new Egg(parentDino);
    }
}