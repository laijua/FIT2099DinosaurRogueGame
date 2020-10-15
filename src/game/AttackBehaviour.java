package game;

import edu.monash.fit2099.engine.*;

public class AttackBehaviour extends CommonStuffBehaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {

        // attacks if next
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurAttackRadius = {0, 1, -1};

        for (int x : dinosaurAttackRadius) {
            for (int y : dinosaurAttackRadius) {
                if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                    Location location = map.at(dinoX + x, dinoY + y);
                    if (map.isAnActorAt(location)) {
                        if (map.getActorAt(location) instanceof Dinosaur) {
                            Dinosaur target = (Dinosaur) map.getActorAt(location);
                            if (target.hasCapability(GameCapability.ALLOSAURATTACKABLE)) {
                                return new AttackAction(target);
                            }
                        }
                    }
                }
            }
        }
//pasted from seek food behaviour
        // chases

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                    Location location = map.at(dinoX + x, dinoY + y);
                    if (location.containsAnActor()) {
                        if (location.getActor() instanceof Dinosaur) {
                            Dinosaur target = (Dinosaur) location.getActor();
                            if (target.hasCapability(GameCapability.ALLOSAURATTACKABLE)) {
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

