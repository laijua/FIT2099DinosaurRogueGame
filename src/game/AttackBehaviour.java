package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to determine who to hunt and attack
 */
public class AttackBehaviour extends CommonStuffBehaviour {
    /**
     * Determines if actor should attack or follow a prey within range
     *
     * @param actor the Actor acting
     * @param map   the GameMap containing the Actor
     * @return An action to follow or attack a target
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location dinosaurLocation = map.locationOf(actor);
        Dinosaur attacker = (Dinosaur) actor;


        // attacks if next to prey
        if (recursion(attacker, dinosaurLocation, 1) != null){
            return new AttackAction(recursion(attacker, dinosaurLocation, 1));

        }
//         goes after a prey if any in range
        if (recursion(attacker, dinosaurLocation, 4) != null){
            return new FollowBehaviour(recursion(attacker, dinosaurLocation, 4)).getAction(actor, map);
        }

        return null;
    }
}

