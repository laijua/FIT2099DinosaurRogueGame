package game;

import edu.monash.fit2099.engine.*;

public class BreedingBehaviour implements Behaviour {
    private Actor target;

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Dinosaur dinosaur = (Dinosaur) actor;

        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                if (location.getActor().getClass() == dinosaur.getClass()) {
                    Dinosaur otherDinosaur = (Dinosaur) location.getActor();
                    if ((otherDinosaur.isMale() && !dinosaur.isMale() || (!otherDinosaur.isMale() && dinosaur.isMale()))) {
                        if (otherDinosaur.isAdult()) {
                            return new BreedingAction(dinosaur);
                        }
                    }
                }
            }
        }
        return null;
    }
}
