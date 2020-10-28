package game;

import edu.monash.fit2099.engine.*;

/**
 * A class for determining if dinosaurs can breed
 */
public class BreedingBehaviour extends CommonStuffBehaviour {
    /**
     * Determines if actor should breed or follow a potential breeding partner
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return An action to follow
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        final int WELLFEDFOODLEVEL = 50;
        Dinosaur dinosaur = (Dinosaur) actor;
        if (dinosaur.getFoodLevel() > WELLFEDFOODLEVEL && dinosaur.isAdult() && !dinosaur.isPregnant()) {
            Location dinosaurLocation = map.locationOf(actor);

            // breed next to opposite sex dinosaur of same kind
            if (recursion(dinosaur, dinosaurLocation, 1, "breed") != null){
                return new BreedingAction(recursion(dinosaur, dinosaurLocation, 1, "breed"));
            }
            // follow opposite sex dinosaur of same kind
            if (recursion(dinosaur, dinosaurLocation, 4, "breed") != null){
                return new FollowBehaviour(recursion(dinosaur, dinosaurLocation, 4, "breed")).getAction(actor, map);
            }
        }
        return null;
    }
}
