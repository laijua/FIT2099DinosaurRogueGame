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
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " has laid an egg";
    }

    private Egg breed() {
        return new Egg(parentDino);
    }
}
