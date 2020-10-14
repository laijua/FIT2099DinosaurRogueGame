package game;

import edu.monash.fit2099.engine.*;

public class SeekFoodBehaviour implements Behaviour {
    private Capabilities capabilities;

    public SeekFoodBehaviour(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {

        Location dinosaurLocation = map.locationOf(actor);
        int dinoX = dinosaurLocation.x();
        int dinoY = dinosaurLocation.y();

        int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3};

        for (int x : dinosaurSearchRadius) {
            for (int y : dinosaurSearchRadius) {
                Location location = map.at(dinoX + x, dinoY + y);
                for(Item items: location.getItems()){
                    if (capabilities.hasCapability(GameCapability.TEST)){
                        return new AttackAction(actor);
                    }
                }
            }
        }


        return null;
    }

}
