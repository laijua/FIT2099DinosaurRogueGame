package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to determine who to hunt and attack
 */
public class AttackBehaviour extends CommonStuffBehaviour {
    /**
     * Determines if actor should attack or follow a prey within range
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return An action to follow or attack a target
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        // attacks if next to prey
        for (int x : dinosaurInteractionRadius) {
            for (int y : dinosaurInteractionRadius) {
                if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                    Location location = map.at(dinoX + x, dinoY + y);
                    if (map.isAnActorAt(location)) {
                        if (map.getActorAt(location) instanceof Dinosaur) {
                            Dinosaur target = (Dinosaur) map.getActorAt(location);
                            if (target.hasCapability(GameCapability.CARNIVOREATTACKABLE)) {
                                return new AttackAction(target);
                            }
                        }
                    }
                }
            }
        }
        // goes after a prey if any in range
        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                    Location location = map.at(dinoX + x, dinoY + y);
                    if (location.containsAnActor()) {
                        if (location.getActor() instanceof Dinosaur) {
                            Dinosaur target = (Dinosaur) location.getActor();
                            if (target.hasCapability(GameCapability.CARNIVOREATTACKABLE)) {
                                return new FollowBehaviour(target).getAction(actor, map);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}

