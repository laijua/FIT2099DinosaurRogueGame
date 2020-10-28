package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class BreedingAction extends Action {
    protected Dinosaur otherDinosaur;
    public BreedingAction(Actor target) {
        this.otherDinosaur = (Dinosaur) target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;
        otherDinosaur.impregnate();
        dinosaur.impregnate();
        return dinosaur + " and " + otherDinosaur + " have bred";
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
