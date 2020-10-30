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
     * @return An action to follow or attack a otherDinosaur
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location dinosaurLocation = map.locationOf(actor);
        Dinosaur attacker = (Dinosaur) actor;


        // attacks if next to prey
        if (findDinosaur(attacker, dinosaurLocation, 1, GameCapability.ATTACK) != null){
            return new AttackAction(findDinosaur(attacker, dinosaurLocation, 1, GameCapability.ATTACK));

        }
//         goes after a prey if any in range
        if (findDinosaur(attacker, dinosaurLocation, 4, GameCapability.ATTACK) != null){
            return new FollowBehaviour(findDinosaur(attacker, dinosaurLocation, 4, GameCapability.ATTACK)).getAction(actor, map);
        }

        return null;
    }
}

