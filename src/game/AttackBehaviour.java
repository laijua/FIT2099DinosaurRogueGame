package game;

import edu.monash.fit2099.engine.*;

public class AttackBehaviour implements Behaviour {
    private Actor target;

    @Override
    public Action getAction(Actor actor, GameMap map) {
//        if (!map.contains(target) || !map.contains(actor))
//            return null;
//
//        Location here = map.locationOf(actor);
//        Location there = map.locationOf(target);
//
//        int currentDistance = distance(here, there);
//        if (currentDistance == 1) {
//            return new AttackAction(target);
//        }

        Dinosaur dinosaur = (Dinosaur) actor;
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurSearchRadius = {0, 1, -1};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                if (map.isAnActorAt(location)){
                    if (map.getActorAt(location) instanceof  Dinosaur){
                        Dinosaur target = (Dinosaur) map.getActorAt(location);
                        if (target.hasCapability(GameCapability.ALLOSAURATTACKABLE)){
                            return new AttackAction(target);
                        }
                    }
                }
            }
        }

        return null;
    }
}

