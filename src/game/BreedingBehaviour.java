package game;

import edu.monash.fit2099.engine.*;

public class BreedingBehaviour implements Behaviour{
    private Actor target;

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                if (location.getActor().getClass() == actor.getClass()){
                  Stegosaur s =  (Stegosaur) location.getActor();
                if (s.isMale()){

                }
                }
            }
            }
        return null;
    }
}
