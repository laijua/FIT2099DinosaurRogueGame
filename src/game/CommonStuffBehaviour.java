package game;

import edu.monash.fit2099.engine.*;

/**
 * Abstract behaviour class that contains common data members. To be inherited by behaviour class that needs its data members.
 */
public abstract class CommonStuffBehaviour implements Behaviour {
    /**
     * data for determining the range a dinosaur can see
     */
    protected int[] dinosaurSearchRadius = {0, 1, -1, 2, -2, 3, -3, 4, -4};
    /**
     * the range a dinosaur can interact with objects and other dinosaurs
     */
//    protected int[] dinosaurInteractionRadius = {0, 1, -1};

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    public static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

    public Actor findDinosaur(Dinosaur dinosaur, Location location, int range, String reason) {
        if (location.containsAnActor()) {
            if (location.getActor() instanceof Dinosaur) {
                Dinosaur target = (Dinosaur) location.getActor();

                if (reason.equals("attack")) {
                    if (target.hasCapability(dinosaur.getCanAttackTier()) && target.getClass() != dinosaur.getClass()) {
                        return target;
                    }
                } else if (reason.equals("breed")) {
                    if (location.getActor().getClass() == dinosaur.getClass()) {
                        Dinosaur otherDinosaur = (Dinosaur) location.getActor();
                        if ((otherDinosaur.isMale() && !dinosaur.isMale() || (!otherDinosaur.isMale() && dinosaur.isMale()))) {
                            if (otherDinosaur.isAdult() && !otherDinosaur.isPregnant()) {
                                return otherDinosaur;
                            }
                        }
                    }
                }
            }
        }
        if (range > 0) {
            for (Exit exits : location.getExits()) {
                if (findDinosaur(dinosaur, exits.getDestination(), range - 1, reason) != null) {
                    return findDinosaur(dinosaur, exits.getDestination(), range - 1, reason);
                }
            }
        }
        return null;
    }

    public Action move(Actor actor, Location here, Location there) {

        int currentDistance = distance(here, there);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(actor)) {
                int newDistance = distance(destination, there);
                if (newDistance < currentDistance) {
                    if (!destination.containsAnActor()) {
                        return new MoveActorAction(destination, exit.getName());
                    }
                }
            }
        }
        return null;
    }


}
