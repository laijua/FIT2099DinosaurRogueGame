package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Action for breeding with another dinosaur
 */
public class BreedingAction extends Action {
    private Dinosaur otherDinosaur;

    /**
     * constructor for BreedingAction
     * @param target the dinosaur to breed with
     */
    public BreedingAction(Actor target) {
        this.otherDinosaur = (Dinosaur) target;
    }

    /**
     * perform breeding action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return String to output to console
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;
        otherDinosaur.impregnate();
        dinosaur.impregnate();
        return dinosaur + " and " + otherDinosaur + " have bred";
    }

    /**
     * Method to describe action
     * @param actor The actor performing the action.
     * @return String describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return null;
    }
}
