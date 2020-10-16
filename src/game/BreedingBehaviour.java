package game;

import edu.monash.fit2099.engine.*;

public class BreedingBehaviour extends CommonStuffBehaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        final int WELLFEDFOODLEVEL = 50;
        Dinosaur dinosaur = (Dinosaur) actor;
        if (dinosaur.getFoodLevel() > WELLFEDFOODLEVEL && dinosaur.isAdult() && !dinosaur.isPregnant()) {
            Location dinosaurLocation = map.locationOf(actor);
            int dinoX = dinosaurLocation.x();
            int dinoY = dinosaurLocation.y();


            for (int x : dinosaurInteractionRadius) {
                for (int y : dinosaurInteractionRadius) {
                    if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                        Location location = map.at(dinoX + x, dinoY + y);
                        if (location.containsAnActor()) {
                            if (location.getActor().getClass() == dinosaur.getClass()) {
                                Dinosaur otherDinosaur = (Dinosaur) location.getActor();
                                if ((otherDinosaur.isMale() && !dinosaur.isMale() || (!otherDinosaur.isMale() && dinosaur.isMale()))) {
                                    if (otherDinosaur.isAdult() && !otherDinosaur.isPregnant()) {
                                        otherDinosaur.impregnate();
                                        dinosaur.impregnate();
                                        System.out.println(actor + " and " + otherDinosaur + " have bred");
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for (int x : dinosaurSearchRadius) {
                for (int y : dinosaurSearchRadius) {
                    if (dinoX + x <= 79 && dinoY + y <= 24 && dinoX + x >= 0 && dinoY + y >= 0) {
                        Location location = map.at(dinoX + x, dinoY + y);
                        if (location.containsAnActor()) {
                            if (location.getActor().getClass() == dinosaur.getClass()) {
                                Dinosaur otherDinosaur = (Dinosaur) location.getActor();
                                if ((otherDinosaur.isMale() && !dinosaur.isMale() || (!otherDinosaur.isMale() && dinosaur.isMale()))) {
                                    if (otherDinosaur.isAdult() && !otherDinosaur.isPregnant()) {
                                        return new FollowBehaviour(otherDinosaur).getAction(actor, map);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
