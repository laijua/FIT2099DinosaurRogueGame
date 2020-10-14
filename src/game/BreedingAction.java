package game;

import edu.monash.fit2099.engine.*;

public class BreedingAction extends Action {

    private Dinosaur parentDino;

    public BreedingAction(Dinosaur parentDinoClass) {
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
        return null;
    }

    private Egg breed(){
        return new Egg(parentDino);
    }
}
